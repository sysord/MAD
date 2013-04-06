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


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.tree.*;

public class functionParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "OPEN_PAREN", "CLOSE_PAREN", "COMMA", "TRUE", "FALSE", "ID", "VAR", "INTEGER", "DECIMAL", "STRING_LITERAL", "LETTER", "DIGIT", "UNDERSCORE", "WS", "COMMENT"
    };
    public static final int INTEGER=11;
    public static final int WS=17;
    public static final int STRING_LITERAL=13;
    public static final int DECIMAL=12;
    public static final int COMMA=6;
    public static final int LETTER=14;
    public static final int OPEN_PAREN=4;
    public static final int UNDERSCORE=16;
    public static final int VAR=10;
    public static final int CLOSE_PAREN=5;
    public static final int DIGIT=15;
    public static final int COMMENT=18;
    public static final int ID=9;
    public static final int FALSE=8;
    public static final int EOF=-1;
    public static final int TRUE=7;

    // delegates
    // delegators


        public functionParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public functionParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return functionParser.tokenNames; }
    public String getGrammarFileName() { return "/home/fabien/workspaces/umlDesigner/com.sysord.mad.functionparser/src/com/sysord/mad/functionparser/grammar/function.g"; }


    public static class root_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "root"
    // /home/fabien/workspaces/umlDesigner/com.sysord.mad.functionparser/src/com/sysord/mad/functionparser/grammar/function.g:25:1: root : expression ;
    public final functionParser.root_return root() throws RecognitionException {
        functionParser.root_return retval = new functionParser.root_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        functionParser.expression_return expression1 = null;



        try {
            // /home/fabien/workspaces/umlDesigner/com.sysord.mad.functionparser/src/com/sysord/mad/functionparser/grammar/function.g:26:3: ( expression )
            // /home/fabien/workspaces/umlDesigner/com.sysord.mad.functionparser/src/com/sysord/mad/functionparser/grammar/function.g:26:5: expression
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_expression_in_root109);
            expression1=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expression1.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "root"

    public static class function_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "function"
    // /home/fabien/workspaces/umlDesigner/com.sysord.mad.functionparser/src/com/sysord/mad/functionparser/grammar/function.g:29:1: function : ID OPEN_PAREN ( parameters )? CLOSE_PAREN ;
    public final functionParser.function_return function() throws RecognitionException {
        functionParser.function_return retval = new functionParser.function_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token ID2=null;
        Token OPEN_PAREN3=null;
        Token CLOSE_PAREN5=null;
        functionParser.parameters_return parameters4 = null;


        CommonTree ID2_tree=null;
        CommonTree OPEN_PAREN3_tree=null;
        CommonTree CLOSE_PAREN5_tree=null;

        try {
            // /home/fabien/workspaces/umlDesigner/com.sysord.mad.functionparser/src/com/sysord/mad/functionparser/grammar/function.g:30:3: ( ID OPEN_PAREN ( parameters )? CLOSE_PAREN )
            // /home/fabien/workspaces/umlDesigner/com.sysord.mad.functionparser/src/com/sysord/mad/functionparser/grammar/function.g:30:5: ID OPEN_PAREN ( parameters )? CLOSE_PAREN
            {
            root_0 = (CommonTree)adaptor.nil();

            ID2=(Token)match(input,ID,FOLLOW_ID_in_function122); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ID2_tree = (CommonTree)adaptor.create(ID2);
            root_0 = (CommonTree)adaptor.becomeRoot(ID2_tree, root_0);
            }
            OPEN_PAREN3=(Token)match(input,OPEN_PAREN,FOLLOW_OPEN_PAREN_in_function125); if (state.failed) return retval;
            // /home/fabien/workspaces/umlDesigner/com.sysord.mad.functionparser/src/com/sysord/mad/functionparser/grammar/function.g:30:21: ( parameters )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( ((LA1_0>=TRUE && LA1_0<=STRING_LITERAL)) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // /home/fabien/workspaces/umlDesigner/com.sysord.mad.functionparser/src/com/sysord/mad/functionparser/grammar/function.g:30:21: parameters
                    {
                    pushFollow(FOLLOW_parameters_in_function128);
                    parameters4=parameters();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, parameters4.getTree());

                    }
                    break;

            }

            CLOSE_PAREN5=(Token)match(input,CLOSE_PAREN,FOLLOW_CLOSE_PAREN_in_function131); if (state.failed) return retval;

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "function"

    public static class parameters_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "parameters"
    // /home/fabien/workspaces/umlDesigner/com.sysord.mad.functionparser/src/com/sysord/mad/functionparser/grammar/function.g:33:1: parameters : expression ( COMMA expression )* ;
    public final functionParser.parameters_return parameters() throws RecognitionException {
        functionParser.parameters_return retval = new functionParser.parameters_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token COMMA7=null;
        functionParser.expression_return expression6 = null;

        functionParser.expression_return expression8 = null;


        CommonTree COMMA7_tree=null;

        try {
            // /home/fabien/workspaces/umlDesigner/com.sysord.mad.functionparser/src/com/sysord/mad/functionparser/grammar/function.g:34:3: ( expression ( COMMA expression )* )
            // /home/fabien/workspaces/umlDesigner/com.sysord.mad.functionparser/src/com/sysord/mad/functionparser/grammar/function.g:34:5: expression ( COMMA expression )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_expression_in_parameters147);
            expression6=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expression6.getTree());
            // /home/fabien/workspaces/umlDesigner/com.sysord.mad.functionparser/src/com/sysord/mad/functionparser/grammar/function.g:34:16: ( COMMA expression )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==COMMA) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /home/fabien/workspaces/umlDesigner/com.sysord.mad.functionparser/src/com/sysord/mad/functionparser/grammar/function.g:34:17: COMMA expression
            	    {
            	    COMMA7=(Token)match(input,COMMA,FOLLOW_COMMA_in_parameters150); if (state.failed) return retval;
            	    pushFollow(FOLLOW_expression_in_parameters153);
            	    expression8=expression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression8.getTree());

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "parameters"

    public static class expression_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "expression"
    // /home/fabien/workspaces/umlDesigner/com.sysord.mad.functionparser/src/com/sysord/mad/functionparser/grammar/function.g:37:1: expression : ( ID | ( function )=> function | VAR | INTEGER | DECIMAL | bool | STRING_LITERAL );
    public final functionParser.expression_return expression() throws RecognitionException {
        functionParser.expression_return retval = new functionParser.expression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token ID9=null;
        Token VAR11=null;
        Token INTEGER12=null;
        Token DECIMAL13=null;
        Token STRING_LITERAL15=null;
        functionParser.function_return function10 = null;

        functionParser.bool_return bool14 = null;


        CommonTree ID9_tree=null;
        CommonTree VAR11_tree=null;
        CommonTree INTEGER12_tree=null;
        CommonTree DECIMAL13_tree=null;
        CommonTree STRING_LITERAL15_tree=null;

        try {
            // /home/fabien/workspaces/umlDesigner/com.sysord.mad.functionparser/src/com/sysord/mad/functionparser/grammar/function.g:38:3: ( ID | ( function )=> function | VAR | INTEGER | DECIMAL | bool | STRING_LITERAL )
            int alt3=7;
            switch ( input.LA(1) ) {
            case ID:
                {
                int LA3_1 = input.LA(2);

                if ( (LA3_1==OPEN_PAREN) && (synpred1_function())) {
                    alt3=2;
                }
                else if ( (LA3_1==EOF||(LA3_1>=CLOSE_PAREN && LA3_1<=COMMA)) ) {
                    alt3=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 3, 1, input);

                    throw nvae;
                }
                }
                break;
            case VAR:
                {
                alt3=3;
                }
                break;
            case INTEGER:
                {
                alt3=4;
                }
                break;
            case DECIMAL:
                {
                alt3=5;
                }
                break;
            case TRUE:
            case FALSE:
                {
                alt3=6;
                }
                break;
            case STRING_LITERAL:
                {
                alt3=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // /home/fabien/workspaces/umlDesigner/com.sysord.mad.functionparser/src/com/sysord/mad/functionparser/grammar/function.g:38:5: ID
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    ID9=(Token)match(input,ID,FOLLOW_ID_in_expression170); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ID9_tree = (CommonTree)adaptor.create(ID9);
                    adaptor.addChild(root_0, ID9_tree);
                    }

                    }
                    break;
                case 2 :
                    // /home/fabien/workspaces/umlDesigner/com.sysord.mad.functionparser/src/com/sysord/mad/functionparser/grammar/function.g:39:5: ( function )=> function
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_function_in_expression182);
                    function10=function();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, function10.getTree());

                    }
                    break;
                case 3 :
                    // /home/fabien/workspaces/umlDesigner/com.sysord.mad.functionparser/src/com/sysord/mad/functionparser/grammar/function.g:40:5: VAR
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    VAR11=(Token)match(input,VAR,FOLLOW_VAR_in_expression188); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    VAR11_tree = (CommonTree)adaptor.create(VAR11);
                    adaptor.addChild(root_0, VAR11_tree);
                    }

                    }
                    break;
                case 4 :
                    // /home/fabien/workspaces/umlDesigner/com.sysord.mad.functionparser/src/com/sysord/mad/functionparser/grammar/function.g:41:5: INTEGER
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    INTEGER12=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_expression194); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INTEGER12_tree = (CommonTree)adaptor.create(INTEGER12);
                    adaptor.addChild(root_0, INTEGER12_tree);
                    }

                    }
                    break;
                case 5 :
                    // /home/fabien/workspaces/umlDesigner/com.sysord.mad.functionparser/src/com/sysord/mad/functionparser/grammar/function.g:42:5: DECIMAL
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    DECIMAL13=(Token)match(input,DECIMAL,FOLLOW_DECIMAL_in_expression200); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DECIMAL13_tree = (CommonTree)adaptor.create(DECIMAL13);
                    adaptor.addChild(root_0, DECIMAL13_tree);
                    }

                    }
                    break;
                case 6 :
                    // /home/fabien/workspaces/umlDesigner/com.sysord.mad.functionparser/src/com/sysord/mad/functionparser/grammar/function.g:43:5: bool
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_bool_in_expression206);
                    bool14=bool();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, bool14.getTree());

                    }
                    break;
                case 7 :
                    // /home/fabien/workspaces/umlDesigner/com.sysord.mad.functionparser/src/com/sysord/mad/functionparser/grammar/function.g:44:5: STRING_LITERAL
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    STRING_LITERAL15=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_expression212); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STRING_LITERAL15_tree = (CommonTree)adaptor.create(STRING_LITERAL15);
                    adaptor.addChild(root_0, STRING_LITERAL15_tree);
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "expression"

    public static class bool_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "bool"
    // /home/fabien/workspaces/umlDesigner/com.sysord.mad.functionparser/src/com/sysord/mad/functionparser/grammar/function.g:47:1: bool : ( TRUE | FALSE );
    public final functionParser.bool_return bool() throws RecognitionException {
        functionParser.bool_return retval = new functionParser.bool_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set16=null;

        CommonTree set16_tree=null;

        try {
            // /home/fabien/workspaces/umlDesigner/com.sysord.mad.functionparser/src/com/sysord/mad/functionparser/grammar/function.g:48:3: ( TRUE | FALSE )
            // /home/fabien/workspaces/umlDesigner/com.sysord.mad.functionparser/src/com/sysord/mad/functionparser/grammar/function.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            set16=(Token)input.LT(1);
            if ( (input.LA(1)>=TRUE && input.LA(1)<=FALSE) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set16));
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "bool"

    // $ANTLR start synpred1_function
    public final void synpred1_function_fragment() throws RecognitionException {   
        // /home/fabien/workspaces/umlDesigner/com.sysord.mad.functionparser/src/com/sysord/mad/functionparser/grammar/function.g:39:5: ( function )
        // /home/fabien/workspaces/umlDesigner/com.sysord.mad.functionparser/src/com/sysord/mad/functionparser/grammar/function.g:39:6: function
        {
        pushFollow(FOLLOW_function_in_synpred1_function177);
        function();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred1_function

    // Delegated rules

    public final boolean synpred1_function() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_function_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_expression_in_root109 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_function122 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_OPEN_PAREN_in_function125 = new BitSet(new long[]{0x0000000000003FA0L});
    public static final BitSet FOLLOW_parameters_in_function128 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_CLOSE_PAREN_in_function131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_parameters147 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_COMMA_in_parameters150 = new BitSet(new long[]{0x0000000000003F80L});
    public static final BitSet FOLLOW_expression_in_parameters153 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_ID_in_expression170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_in_expression182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VAR_in_expression188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGER_in_expression194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DECIMAL_in_expression200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bool_in_expression206 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_expression212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_bool0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_in_synpred1_function177 = new BitSet(new long[]{0x0000000000000002L});

}
