/***************************************************************************
 * Copyright (c) 2013 Sysord.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Sysord - initial API and implementation
 ****************************************************************************/
package com.sysord.mad.functionparser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;
import org.antlr.runtime.tree.CommonTree;

import com.sysord.mad.functionparser.grammar.functionLexer;
import com.sysord.mad.functionparser.grammar.functionParser;
import com.sysord.mad.functionparser.grammar.functionParser.root_return;

/**
 * Parser for expressions represented by strings.
 * <p>
 * An <em>Expression</em> can be :
 * <ul>
 * <li>a Function</li>
 * <li>a Boolean</li>
 * <li>an Integer</li>
 * <li>a Double</li>
 * <li>a Variable : a variable is prefixed with a <em>$</em></li>
 * <li>a String : a string is between simple quotes</li>
 * </ul>
 * <p>
 * A <em>Function</em> is defined by its <em>identifier</em> followed by a sequence
 * (potentially empty) of <em>Expressions</em> between parentheses.
 * <p>
 * A {@code FunctionParser} uses a {@link FunctionProcessor} to process expressions and
 * evaluate functions.
 * <p>
 * Examples :
 * 
 * <pre>
 * funcOne()
 * 
 * mult(6, 7.9)
 * 
 * add($number, mult(6, 3))
 * 
 * $VALUE
 * 
 * 42.0000001
 * </pre>
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 * @see FunctionProcessor
 */
public class FunctionParser {

	/**
	 * The {@link FunctionProcessor} used by this {@code FunctionParser}.
	 */
	protected FunctionProcessor processor;

	/**
	 * Creates a new {@code FunctionParser} with the given {@link FunctionProcessor
	 * processor}.
	 * 
	 * @param processor The {@link FunctionProcessor processor} to use for obtaining the
	 *        desired objects for each expression type.
	 * @throws IllegalArgumentException if the given processor is {@code null}.
	 */
	public FunctionParser(FunctionProcessor processor) {
		if (processor == null) {
			throw new IllegalArgumentException(M.err_processorCannotBeNull);
		}
		this.processor = processor;
	}

	/**
	 * Parses the given string into a function and returns the result of the parsed
	 * function.
	 * 
	 * @param expression The string <em>expression</em> to parse.
	 * @return the result of the parsed expression.
	 * @throws FunctionParseException if the given string is malformed or if an error
	 *         occurs during the evaluation.
	 */
	public Object parse(String expression) throws FunctionParseException {
		Object result = null;
		CommonTree ast = internalParse(expression);
		try {
			result = doSwitch(ast);
		} catch (FunctionProcessingException e) {
			throw new FunctionParseException(M.err_processingErrorOccured, e);
		}
		return result;
	}

	/**
	 * Parses the string using the ANTLR {@link functionParser}.
	 * 
	 * @param expression
	 * @return the root AST node of the expression.
	 * @throws FunctionParseException
	 */
	private CommonTree internalParse(String expression) throws FunctionParseException {
		CharStream stream = new ANTLRStringStream(expression);
		functionLexer lexer = new functionLexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		functionParser parser = new functionParser(tokenStream);
		root_return result;
		try {
			result = parser.root();
			return (CommonTree) result.getTree();
		} catch (RecognitionException e) {
			throw new FunctionParseException(M.bind(M.err_functionStringMalformed, expression), e);
		}
	}

	/**
	 * Creates the {@link Func function} corresponding to the given AST node.
	 * 
	 * @param ast The AST node of the function.
	 * @return the created function corresponding to the AST node.
	 * @throws FunctionProcessingException if an error occurs during the expressions
	 *         processing.
	 * @throws FunctionParseException if the given AST node is not a function node.
	 */
	private Func createFunction(CommonTree ast) throws FunctionProcessingException, FunctionParseException {
		if (ast.getType() != functionLexer.ID) {
			String[] labels = new String[] {
					String.valueOf(ast.getType()),
					ast.getText(),
					String.valueOf(ast.getTokenStartIndex()),
					String.valueOf(ast.getTokenStopIndex()) };
			throw new FunctionParseException(M.bind(M.err_createFuncFromNonAstFunc, labels));
		}// else

		Func function = new Func();

		// The Function name
		function.name = ast.getText();

		// The Function arguments
		List<Object> arguments;
		if (ast.getChildren() == null || ast.getChildren().size() == 0) {
			arguments = Collections.emptyList();
		} else {
			arguments = new ArrayList<Object>(ast.getChildren().size());
			for (Object astArg : ast.getChildren()) {
				arguments.add(doSwitch((CommonTree) astArg));
			}
		}
		function.arguments = arguments;

		return function;
	}

	/**
	 * Processes the given AST node using the {@link FunctionProcessor processor}.
	 * 
	 * @param astArg AST node to process.
	 * @return The value of the AST node.
	 * @throws FunctionProcessingException if an error occurs during the process of a
	 *         node.
	 * @throws FunctionParseException if the AST node is a malformed function node.
	 */
	private Object doSwitch(CommonTree astArg) throws FunctionProcessingException, FunctionParseException {
		Object arg = null;
		switch (astArg.getType()) {
		case functionLexer.ID:
			if (identifierIsFunction(astArg)) {
				// Function identifier case
				arg = createFunction(astArg).eval();
			} else {
				// Simple identifier case
				arg = processor.caseIdentifier(astArg.getText());
			}
			break;
		case functionLexer.VAR:
			arg = processor.caseVar(astArg.getText().substring(1));
			break;
		case functionLexer.STRING_LITERAL:
			arg = processor.caseString(astArg.getText());
			break;
		case functionLexer.FALSE: /* Falls through */
		case functionLexer.TRUE:
			arg = processor.caseBoolean(Boolean.valueOf(astArg.getText()));
			break;
		case functionLexer.DECIMAL:
			arg = processor.caseDecimal(Double.valueOf(astArg.getText()));
			break;
		case functionLexer.INTEGER:
			arg = processor.caseInteger(Integer.valueOf(astArg.getText()));
			break;
		default:
			throw new UnsupportedOperationException(M.bind(M.err_typeOfASTNotSupported, astArg.getType()));
		}
		return arg;
	}

	/**
	 * Indicates if the given AST node is a function node.
	 * 
	 * @param astArg
	 * @return {@code true} if the given AST node is a function node;<br>
	 *         {@code false} otherwise.
	 */
	private boolean identifierIsFunction(CommonTree astArg) {
		if (astArg.getChildren() != null) {
			return true;
		}// else
			// The start and stop indexes are equal if it is a simple ID
		return astArg.getTokenStartIndex() != astArg.getTokenStopIndex();
	}

	/**
	 * Internal definition of a function.
	 */
	private class Func {

		private String name;

		private List<Object> arguments;

		/**
		 * Call the processor for evaluating this function.
		 * 
		 * @return the result returned by the function evalutation.
		 * @throws FunctionProcessingException
		 */
		public Object eval() throws FunctionProcessingException {
			return processor.evalFunction(name, arguments);
		}
	}
}
