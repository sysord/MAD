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
package com.sysord.mad.functionparser.grammar;

import java.util.List;

import org.antlr.runtime.RecognitionException;
import org.eclipse.core.runtime.Assert;

import com.sysord.mad.functionparser.FunctionParser;
import com.sysord.mad.functionparser.FunctionProcessingException;
import com.sysord.mad.functionparser.FunctionProcessor;

/**
 * Test class for the {@link FunctionParser} and {@link functionParser}.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public class Ttest {

	// Tests
	static String[] tests = {
			"toto('abc '' est\r\n une chaine', i_d, _id, id_, $var, 12, t2(z, bb(true, false), 8.9))",
			"func(t(empty(), empty()))",
			"empty()",
			"func(3, 1.0, -5.2, -10, 4.0, 5.66541124, zz)",
			"$Variable",
			"identifier",
			"12",
			"42.0",
			"-1",
			"-67.937647384",
			"'Chaîne de caractères $e & '' \" @v'",
			"true",
			"false" };

	// Results we should obtain
	static String[] results = {
			"toto('abc ' est\r\n une chaine', i_d, _id, id_, $var, 12, t2(z, bb(true, false), 8.9))",
			"func(t(empty(), empty()))",
			"empty()",
			"func(3, 1.0, -5.2, -10, 4.0, 5.66541124, zz)",
			"$Variable",
			"identifier",
			"12",
			"42.0",
			"-1",
			"-67.937647384",
			"'Chaîne de caractères $e & ' \" @v'",
			"true",
			"false" };

	public static void main(String[] args) throws RecognitionException {
		functionParserProcessorTest();
	}

	static void functionParserProcessorTest() {
		ToStringFunctionProcessor processor = new ToStringFunctionProcessor();
		FunctionParser parser = new FunctionParser(processor);

		// Verification of the test cases
		Assert.isTrue(tests.length == results.length, "Test cases not corrects");

		int errors = tests.length;
		for (int i = 0; i < tests.length; i++) {
			try {
				Object result = parser.parse(tests[i]);
				Assert.isTrue(results[i].equals(result), "Test n° " + i + " is incorrect : " + tests[i] + "\nresult : "
						+ result);
				errors--;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		String message;
		if (errors == 0) {
			message = "Done : SUCCES";
		} else {
			message = "Done : " + errors + " tests FAILED on " + tests.length;
		}
		System.out.println(message);
	}

	/**
	 * {@link FunctionProcessor} for testing purpose.
	 * <p>
	 * Transforms the received expression into their corresponding String value.
	 * <p>
	 * The {@link #evalFunction(String, List)} method returns the string expression of the
	 * given function.
	 */
	static class ToStringFunctionProcessor implements FunctionProcessor {

		@Override
		public Object caseIdentifier(String identifier) throws FunctionProcessingException {
			return identifier;
		}

		@Override
		public Object caseVar(String varname) throws FunctionProcessingException {
			return '$' + varname;
		}

		@Override
		public Object caseString(String value) throws FunctionProcessingException {
			return "'" + value + "'";
		}

		@Override
		public Object caseBoolean(boolean value) throws FunctionProcessingException {
			return String.valueOf(value);
		}

		@Override
		public Object caseInteger(int value) throws FunctionProcessingException {
			return String.valueOf(value);
		}

		@Override
		public Object caseDecimal(double value) throws FunctionProcessingException {
			return String.valueOf(value);
		}

		@Override
		public Object evalFunction(String name, List<Object> arguments) throws FunctionProcessingException {
			StringBuilder func = new StringBuilder(name);
			func.append('(');
			for (Object arg : arguments) {
				func.append(arg).append(',').append(' ');
			}
			if (arguments.size() > 0) {
				// Delete the comma and space at the end of the arguments list
				func.delete(func.length() - 2, func.length());
			}
			func.append(')');
			return func.toString();
		}

	}
}
