// $ANTLR 3.2 Sep 23, 2009 12:02:23 /home/fabien/workspaces/modelingKepler/mad/MAD/com.sysord.mad.functionparser/src/com/sysord/mad/functionparser/grammar/function.g 2015-03-13 10:22:53
 
  package com.sysord.mad.functionparser.grammar;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class functionLexer extends Lexer {
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
    public static final int ID=9;
    public static final int COMMENT=18;
    public static final int FALSE=8;
    public static final int EOF=-1;
    public static final int TRUE=7;

    // delegates
    // delegators

    public functionLexer() {;} 
    public functionLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public functionLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "/home/fabien/workspaces/modelingKepler/mad/MAD/com.sysord.mad.functionparser/src/com/sysord/mad/functionparser/grammar/function.g"; }

    // $ANTLR start "OPEN_PAREN"
    public final void mOPEN_PAREN() throws RecognitionException {
        try {
            int _type = OPEN_PAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/fabien/workspaces/modelingKepler/mad/MAD/com.sysord.mad.functionparser/src/com/sysord/mad/functionparser/grammar/function.g:11:12: ( '(' )
            // /home/fabien/workspaces/modelingKepler/mad/MAD/com.sysord.mad.functionparser/src/com/sysord/mad/functionparser/grammar/function.g:11:14: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OPEN_PAREN"

    // $ANTLR start "CLOSE_PAREN"
    public final void mCLOSE_PAREN() throws RecognitionException {
        try {
            int _type = CLOSE_PAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/fabien/workspaces/modelingKepler/mad/MAD/com.sysord.mad.functionparser/src/com/sysord/mad/functionparser/grammar/function.g:12:13: ( ')' )
            // /home/fabien/workspaces/modelingKepler/mad/MAD/com.sysord.mad.functionparser/src/com/sysord/mad/functionparser/grammar/function.g:12:15: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CLOSE_PAREN"

    // $ANTLR start "COMMA"
    public final void mCOMMA() throws RecognitionException {
        try {
            int _type = COMMA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/fabien/workspaces/modelingKepler/mad/MAD/com.sysord.mad.functionparser/src/com/sysord/mad/functionparser/grammar/function.g:13:7: ( ',' )
            // /home/fabien/workspaces/modelingKepler/mad/MAD/com.sysord.mad.functionparser/src/com/sysord/mad/functionparser/grammar/function.g:13:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COMMA"

    // $ANTLR start "TRUE"
    public final void mTRUE() throws RecognitionException {
        try {
            int _type = TRUE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/fabien/workspaces/modelingKepler/mad/MAD/com.sysord.mad.functionparser/src/com/sysord/mad/functionparser/grammar/function.g:14:6: ( 'true' )
            // /home/fabien/workspaces/modelingKepler/mad/MAD/com.sysord.mad.functionparser/src/com/sysord/mad/functionparser/grammar/function.g:14:8: 'true'
            {
            match("true"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "TRUE"

    // $ANTLR start "FALSE"
    public final void mFALSE() throws RecognitionException {
        try {
            int _type = FALSE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/fabien/workspaces/modelingKepler/mad/MAD/com.sysord.mad.functionparser/src/com/sysord/mad/functionparser/grammar/function.g:15:7: ( 'false' )
            // /home/fabien/workspaces/modelingKepler/mad/MAD/com.sysord.mad.functionparser/src/com/sysord/mad/functionparser/grammar/function.g:15:9: 'false'
            {
            match("false"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FALSE"

    // $ANTLR start "STRING_LITERAL"
    public final void mSTRING_LITERAL() throws RecognitionException {
        try {
            int _type = STRING_LITERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            int c;

            // /home/fabien/workspaces/modelingKepler/mad/MAD/com.sysord.mad.functionparser/src/com/sysord/mad/functionparser/grammar/function.g:58:3: ( '\\'' ( '\\'' '\\'' | c=~ ( '\\'' ) )* '\\'' )
            // /home/fabien/workspaces/modelingKepler/mad/MAD/com.sysord.mad.functionparser/src/com/sysord/mad/functionparser/grammar/function.g:58:5: '\\'' ( '\\'' '\\'' | c=~ ( '\\'' ) )* '\\''
            {
            match('\''); 
             StringBuilder b = new StringBuilder(); 
            // /home/fabien/workspaces/modelingKepler/mad/MAD/com.sysord.mad.functionparser/src/com/sysord/mad/functionparser/grammar/function.g:60:5: ( '\\'' '\\'' | c=~ ( '\\'' ) )*
            loop1:
            do {
                int alt1=3;
                int LA1_0 = input.LA(1);

                if ( (LA1_0=='\'') ) {
                    int LA1_1 = input.LA(2);

                    if ( (LA1_1=='\'') ) {
                        alt1=1;
                    }


                }
                else if ( ((LA1_0>='\u0000' && LA1_0<='&')||(LA1_0>='(' && LA1_0<='\uFFFF')) ) {
                    alt1=2;
                }


                switch (alt1) {
            	case 1 :
            	    // /home/fabien/workspaces/modelingKepler/mad/MAD/com.sysord.mad.functionparser/src/com/sysord/mad/functionparser/grammar/function.g:60:7: '\\'' '\\''
            	    {
            	    match('\''); 
            	    match('\''); 
            	     b.appendCodePoint('\'');

            	    }
            	    break;
            	case 2 :
            	    // /home/fabien/workspaces/modelingKepler/mad/MAD/com.sysord.mad.functionparser/src/com/sysord/mad/functionparser/grammar/function.g:62:7: c=~ ( '\\'' )
            	    {
            	    c= input.LA(1);
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}

            	     b.appendCodePoint(c);

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            match('\''); 
             setText(b.toString()); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "STRING_LITERAL"

    // $ANTLR start "LETTER"
    public final void mLETTER() throws RecognitionException {
        try {
            // /home/fabien/workspaces/modelingKepler/mad/MAD/com.sysord.mad.functionparser/src/com/sysord/mad/functionparser/grammar/function.g:68:17: ( ( 'a' .. 'z' | 'A' .. 'Z' ) )
            // /home/fabien/workspaces/modelingKepler/mad/MAD/com.sysord.mad.functionparser/src/com/sysord/mad/functionparser/grammar/function.g:68:19: ( 'a' .. 'z' | 'A' .. 'Z' )
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "LETTER"

    // $ANTLR start "DIGIT"
    public final void mDIGIT() throws RecognitionException {
        try {
            // /home/fabien/workspaces/modelingKepler/mad/MAD/com.sysord.mad.functionparser/src/com/sysord/mad/functionparser/grammar/function.g:69:16: ( '0' .. '9' )
            // /home/fabien/workspaces/modelingKepler/mad/MAD/com.sysord.mad.functionparser/src/com/sysord/mad/functionparser/grammar/function.g:69:18: '0' .. '9'
            {
            matchRange('0','9'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "DIGIT"

    // $ANTLR start "UNDERSCORE"
    public final void mUNDERSCORE() throws RecognitionException {
        try {
            // /home/fabien/workspaces/modelingKepler/mad/MAD/com.sysord.mad.functionparser/src/com/sysord/mad/functionparser/grammar/function.g:70:21: ( '_' )
            // /home/fabien/workspaces/modelingKepler/mad/MAD/com.sysord.mad.functionparser/src/com/sysord/mad/functionparser/grammar/function.g:70:23: '_'
            {
            match('_'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "UNDERSCORE"

    // $ANTLR start "INTEGER"
    public final void mINTEGER() throws RecognitionException {
        try {
            int _type = INTEGER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/fabien/workspaces/modelingKepler/mad/MAD/com.sysord.mad.functionparser/src/com/sysord/mad/functionparser/grammar/function.g:71:9: ( ( '-' )? ( DIGIT )+ )
            // /home/fabien/workspaces/modelingKepler/mad/MAD/com.sysord.mad.functionparser/src/com/sysord/mad/functionparser/grammar/function.g:71:11: ( '-' )? ( DIGIT )+
            {
            // /home/fabien/workspaces/modelingKepler/mad/MAD/com.sysord.mad.functionparser/src/com/sysord/mad/functionparser/grammar/function.g:71:11: ( '-' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='-') ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // /home/fabien/workspaces/modelingKepler/mad/MAD/com.sysord.mad.functionparser/src/com/sysord/mad/functionparser/grammar/function.g:71:12: '-'
                    {
                    match('-'); 

                    }
                    break;

            }

            // /home/fabien/workspaces/modelingKepler/mad/MAD/com.sysord.mad.functionparser/src/com/sysord/mad/functionparser/grammar/function.g:71:18: ( DIGIT )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='0' && LA3_0<='9')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /home/fabien/workspaces/modelingKepler/mad/MAD/com.sysord.mad.functionparser/src/com/sysord/mad/functionparser/grammar/function.g:71:18: DIGIT
            	    {
            	    mDIGIT(); 

            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INTEGER"

    // $ANTLR start "DECIMAL"
    public final void mDECIMAL() throws RecognitionException {
        try {
            int _type = DECIMAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/fabien/workspaces/modelingKepler/mad/MAD/com.sysord.mad.functionparser/src/com/sysord/mad/functionparser/grammar/function.g:72:9: ( ( '-' )? ( DIGIT )+ '.' ( DIGIT )+ )
            // /home/fabien/workspaces/modelingKepler/mad/MAD/com.sysord.mad.functionparser/src/com/sysord/mad/functionparser/grammar/function.g:72:11: ( '-' )? ( DIGIT )+ '.' ( DIGIT )+
            {
            // /home/fabien/workspaces/modelingKepler/mad/MAD/com.sysord.mad.functionparser/src/com/sysord/mad/functionparser/grammar/function.g:72:11: ( '-' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='-') ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // /home/fabien/workspaces/modelingKepler/mad/MAD/com.sysord.mad.functionparser/src/com/sysord/mad/functionparser/grammar/function.g:72:12: '-'
                    {
                    match('-'); 

                    }
                    break;

            }

            // /home/fabien/workspaces/modelingKepler/mad/MAD/com.sysord.mad.functionparser/src/com/sysord/mad/functionparser/grammar/function.g:72:18: ( DIGIT )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>='0' && LA5_0<='9')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // /home/fabien/workspaces/modelingKepler/mad/MAD/com.sysord.mad.functionparser/src/com/sysord/mad/functionparser/grammar/function.g:72:18: DIGIT
            	    {
            	    mDIGIT(); 

            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);

            match('.'); 
            // /home/fabien/workspaces/modelingKepler/mad/MAD/com.sysord.mad.functionparser/src/com/sysord/mad/functionparser/grammar/function.g:72:29: ( DIGIT )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>='0' && LA6_0<='9')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // /home/fabien/workspaces/modelingKepler/mad/MAD/com.sysord.mad.functionparser/src/com/sysord/mad/functionparser/grammar/function.g:72:29: DIGIT
            	    {
            	    mDIGIT(); 

            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DECIMAL"

    // $ANTLR start "ID"
    public final void mID() throws RecognitionException {
        try {
            int _type = ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/fabien/workspaces/modelingKepler/mad/MAD/com.sysord.mad.functionparser/src/com/sysord/mad/functionparser/grammar/function.g:73:4: ( ( LETTER | UNDERSCORE ) ( LETTER | DIGIT | UNDERSCORE )* )
            // /home/fabien/workspaces/modelingKepler/mad/MAD/com.sysord.mad.functionparser/src/com/sysord/mad/functionparser/grammar/function.g:73:6: ( LETTER | UNDERSCORE ) ( LETTER | DIGIT | UNDERSCORE )*
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // /home/fabien/workspaces/modelingKepler/mad/MAD/com.sysord.mad.functionparser/src/com/sysord/mad/functionparser/grammar/function.g:73:28: ( LETTER | DIGIT | UNDERSCORE )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>='0' && LA7_0<='9')||(LA7_0>='A' && LA7_0<='Z')||LA7_0=='_'||(LA7_0>='a' && LA7_0<='z')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // /home/fabien/workspaces/modelingKepler/mad/MAD/com.sysord.mad.functionparser/src/com/sysord/mad/functionparser/grammar/function.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ID"

    // $ANTLR start "VAR"
    public final void mVAR() throws RecognitionException {
        try {
            int _type = VAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/fabien/workspaces/modelingKepler/mad/MAD/com.sysord.mad.functionparser/src/com/sysord/mad/functionparser/grammar/function.g:74:5: ( '$' ID )
            // /home/fabien/workspaces/modelingKepler/mad/MAD/com.sysord.mad.functionparser/src/com/sysord/mad/functionparser/grammar/function.g:74:7: '$' ID
            {
            match('$'); 
            mID(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "VAR"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/fabien/workspaces/modelingKepler/mad/MAD/com.sysord.mad.functionparser/src/com/sysord/mad/functionparser/grammar/function.g:75:4: ( ( ' ' | '\\t' | '\\n' | '\\r' | '\\f' )+ )
            // /home/fabien/workspaces/modelingKepler/mad/MAD/com.sysord.mad.functionparser/src/com/sysord/mad/functionparser/grammar/function.g:75:6: ( ' ' | '\\t' | '\\n' | '\\r' | '\\f' )+
            {
            // /home/fabien/workspaces/modelingKepler/mad/MAD/com.sysord.mad.functionparser/src/com/sysord/mad/functionparser/grammar/function.g:75:6: ( ' ' | '\\t' | '\\n' | '\\r' | '\\f' )+
            int cnt8=0;
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='\t' && LA8_0<='\n')||(LA8_0>='\f' && LA8_0<='\r')||LA8_0==' ') ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // /home/fabien/workspaces/modelingKepler/mad/MAD/com.sysord.mad.functionparser/src/com/sysord/mad/functionparser/grammar/function.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||(input.LA(1)>='\f' && input.LA(1)<='\r')||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt8 >= 1 ) break loop8;
                        EarlyExitException eee =
                            new EarlyExitException(8, input);
                        throw eee;
                }
                cnt8++;
            } while (true);

            _channel = HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WS"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/fabien/workspaces/modelingKepler/mad/MAD/com.sysord.mad.functionparser/src/com/sysord/mad/functionparser/grammar/function.g:76:9: ( '//' ( . )* ( '\\n' | '\\r' ) )
            // /home/fabien/workspaces/modelingKepler/mad/MAD/com.sysord.mad.functionparser/src/com/sysord/mad/functionparser/grammar/function.g:76:11: '//' ( . )* ( '\\n' | '\\r' )
            {
            match("//"); 

            // /home/fabien/workspaces/modelingKepler/mad/MAD/com.sysord.mad.functionparser/src/com/sysord/mad/functionparser/grammar/function.g:76:16: ( . )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0=='\n'||LA9_0=='\r') ) {
                    alt9=2;
                }
                else if ( ((LA9_0>='\u0000' && LA9_0<='\t')||(LA9_0>='\u000B' && LA9_0<='\f')||(LA9_0>='\u000E' && LA9_0<='\uFFFF')) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // /home/fabien/workspaces/modelingKepler/mad/MAD/com.sysord.mad.functionparser/src/com/sysord/mad/functionparser/grammar/function.g:76:16: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            if ( input.LA(1)=='\n'||input.LA(1)=='\r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            _channel = HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COMMENT"

    public void mTokens() throws RecognitionException {
        // /home/fabien/workspaces/modelingKepler/mad/MAD/com.sysord.mad.functionparser/src/com/sysord/mad/functionparser/grammar/function.g:1:8: ( OPEN_PAREN | CLOSE_PAREN | COMMA | TRUE | FALSE | STRING_LITERAL | INTEGER | DECIMAL | ID | VAR | WS | COMMENT )
        int alt10=12;
        alt10 = dfa10.predict(input);
        switch (alt10) {
            case 1 :
                // /home/fabien/workspaces/modelingKepler/mad/MAD/com.sysord.mad.functionparser/src/com/sysord/mad/functionparser/grammar/function.g:1:10: OPEN_PAREN
                {
                mOPEN_PAREN(); 

                }
                break;
            case 2 :
                // /home/fabien/workspaces/modelingKepler/mad/MAD/com.sysord.mad.functionparser/src/com/sysord/mad/functionparser/grammar/function.g:1:21: CLOSE_PAREN
                {
                mCLOSE_PAREN(); 

                }
                break;
            case 3 :
                // /home/fabien/workspaces/modelingKepler/mad/MAD/com.sysord.mad.functionparser/src/com/sysord/mad/functionparser/grammar/function.g:1:33: COMMA
                {
                mCOMMA(); 

                }
                break;
            case 4 :
                // /home/fabien/workspaces/modelingKepler/mad/MAD/com.sysord.mad.functionparser/src/com/sysord/mad/functionparser/grammar/function.g:1:39: TRUE
                {
                mTRUE(); 

                }
                break;
            case 5 :
                // /home/fabien/workspaces/modelingKepler/mad/MAD/com.sysord.mad.functionparser/src/com/sysord/mad/functionparser/grammar/function.g:1:44: FALSE
                {
                mFALSE(); 

                }
                break;
            case 6 :
                // /home/fabien/workspaces/modelingKepler/mad/MAD/com.sysord.mad.functionparser/src/com/sysord/mad/functionparser/grammar/function.g:1:50: STRING_LITERAL
                {
                mSTRING_LITERAL(); 

                }
                break;
            case 7 :
                // /home/fabien/workspaces/modelingKepler/mad/MAD/com.sysord.mad.functionparser/src/com/sysord/mad/functionparser/grammar/function.g:1:65: INTEGER
                {
                mINTEGER(); 

                }
                break;
            case 8 :
                // /home/fabien/workspaces/modelingKepler/mad/MAD/com.sysord.mad.functionparser/src/com/sysord/mad/functionparser/grammar/function.g:1:73: DECIMAL
                {
                mDECIMAL(); 

                }
                break;
            case 9 :
                // /home/fabien/workspaces/modelingKepler/mad/MAD/com.sysord.mad.functionparser/src/com/sysord/mad/functionparser/grammar/function.g:1:81: ID
                {
                mID(); 

                }
                break;
            case 10 :
                // /home/fabien/workspaces/modelingKepler/mad/MAD/com.sysord.mad.functionparser/src/com/sysord/mad/functionparser/grammar/function.g:1:84: VAR
                {
                mVAR(); 

                }
                break;
            case 11 :
                // /home/fabien/workspaces/modelingKepler/mad/MAD/com.sysord.mad.functionparser/src/com/sysord/mad/functionparser/grammar/function.g:1:88: WS
                {
                mWS(); 

                }
                break;
            case 12 :
                // /home/fabien/workspaces/modelingKepler/mad/MAD/com.sysord.mad.functionparser/src/com/sysord/mad/functionparser/grammar/function.g:1:91: COMMENT
                {
                mCOMMENT(); 

                }
                break;

        }

    }


    protected DFA10 dfa10 = new DFA10(this);
    static final String DFA10_eotS =
        "\4\uffff\2\11\2\uffff\1\17\4\uffff\2\11\2\uffff\2\11\1\25\1\11\1"+
        "\uffff\1\27\1\uffff";
    static final String DFA10_eofS =
        "\30\uffff";
    static final String DFA10_minS =
        "\1\11\3\uffff\1\162\1\141\1\uffff\1\60\1\56\4\uffff\1\165\1\154"+
        "\2\uffff\1\145\1\163\1\60\1\145\1\uffff\1\60\1\uffff";
    static final String DFA10_maxS =
        "\1\172\3\uffff\1\162\1\141\1\uffff\2\71\4\uffff\1\165\1\154\2\uffff"+
        "\1\145\1\163\1\172\1\145\1\uffff\1\172\1\uffff";
    static final String DFA10_acceptS =
        "\1\uffff\1\1\1\2\1\3\2\uffff\1\6\2\uffff\1\11\1\12\1\13\1\14\2\uffff"+
        "\1\7\1\10\4\uffff\1\4\1\uffff\1\5";
    static final String DFA10_specialS =
        "\30\uffff}>";
    static final String[] DFA10_transitionS = {
            "\2\13\1\uffff\2\13\22\uffff\1\13\3\uffff\1\12\2\uffff\1\6\1"+
            "\1\1\2\2\uffff\1\3\1\7\1\uffff\1\14\12\10\7\uffff\32\11\4\uffff"+
            "\1\11\1\uffff\5\11\1\5\15\11\1\4\6\11",
            "",
            "",
            "",
            "\1\15",
            "\1\16",
            "",
            "\12\10",
            "\1\20\1\uffff\12\10",
            "",
            "",
            "",
            "",
            "\1\21",
            "\1\22",
            "",
            "",
            "\1\23",
            "\1\24",
            "\12\11\7\uffff\32\11\4\uffff\1\11\1\uffff\32\11",
            "\1\26",
            "",
            "\12\11\7\uffff\32\11\4\uffff\1\11\1\uffff\32\11",
            ""
    };

    static final short[] DFA10_eot = DFA.unpackEncodedString(DFA10_eotS);
    static final short[] DFA10_eof = DFA.unpackEncodedString(DFA10_eofS);
    static final char[] DFA10_min = DFA.unpackEncodedStringToUnsignedChars(DFA10_minS);
    static final char[] DFA10_max = DFA.unpackEncodedStringToUnsignedChars(DFA10_maxS);
    static final short[] DFA10_accept = DFA.unpackEncodedString(DFA10_acceptS);
    static final short[] DFA10_special = DFA.unpackEncodedString(DFA10_specialS);
    static final short[][] DFA10_transition;

    static {
        int numStates = DFA10_transitionS.length;
        DFA10_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA10_transition[i] = DFA.unpackEncodedString(DFA10_transitionS[i]);
        }
    }

    class DFA10 extends DFA {

        public DFA10(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 10;
            this.eot = DFA10_eot;
            this.eof = DFA10_eof;
            this.min = DFA10_min;
            this.max = DFA10_max;
            this.accept = DFA10_accept;
            this.special = DFA10_special;
            this.transition = DFA10_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( OPEN_PAREN | CLOSE_PAREN | COMMA | TRUE | FALSE | STRING_LITERAL | INTEGER | DECIMAL | ID | VAR | WS | COMMENT );";
        }
    }
 

}