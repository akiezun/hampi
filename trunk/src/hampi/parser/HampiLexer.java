// $ANTLR 3.1b1 src/hampi/parser/Hampi.g 2009-12-11 22:09:50
 
     package hampi.parser; 
   

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class HampiLexer extends Lexer {
    public static final int CFGSTAR=8;
    public static final int FIX=10;
    public static final int STAR=39;
    public static final int LSQUARE=41;
    public static final int T__65=65;
    public static final int KW_VAL=53;
    public static final int CONST=19;
    public static final int CFGPROD=4;
    public static final int CONTAINS=11;
    public static final int EQUALS=59;
    public static final int ID=31;
    public static final int CFG=16;
    public static final int EOF=-1;
    public static final int LPAREN=36;
    public static final int KW_VAR=30;
    public static final int VALS=28;
    public static final int CHAR_SEQ=45;
    public static final int RPAREN=37;
    public static final int IN=12;
    public static final int CFGOPTION=7;
    public static final int COMMA=49;
    public static final int CFGPRODELEMSET=27;
    public static final int CFGCHARRANGE=25;
    public static final int KW_IN=55;
    public static final int VAL=18;
    public static final int PLUS=40;
    public static final int VAR=15;
    public static final int COMMENT=63;
    public static final int NOTCONTAINS=24;
    public static final int KW_FIX=48;
    public static final int KW_REG=47;
    public static final int LINE_COMMENT=64;
    public static final int CONCAT=14;
    public static final int KW_ASSERT=54;
    public static final int STR_LIT=46;
    public static final int KW_QUERY=58;
    public static final int RANGE=20;
    public static final int INT=33;
    public static final int CHAR_LIT=42;
    public static final int RSQUARE=44;
    public static final int MINUS=43;
    public static final int REG=17;
    public static final int SEMI=29;
    public static final int ASSERT=13;
    public static final int CFGCHARSEQRANGE=26;
    public static final int CFGPLUS=9;
    public static final int COLON=32;
    public static final int WS=62;
    public static final int QUESTION=38;
    public static final int KW_CONCAT=52;
    public static final int NEWLINE=61;
    public static final int KW_OR=51;
    public static final int KW_CONTAINS=56;
    public static final int OR=22;
    public static final int CHARSEQRANGE=21;
    public static final int ASSIGN=5;
    public static final int PROGRAM=6;
    public static final int KW_STAR=50;
    public static final int EscapeSequence=60;
    public static final int BAR=35;
    public static final int KW_CFG=34;
    public static final int KW_NOT=57;
    public static final int NOTIN=23;

    // delegates
    // delegators

    public HampiLexer() {;} 
    public HampiLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public HampiLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "src/hampi/parser/Hampi.g"; }

    // $ANTLR start T__65
    public final void mT__65() throws RecognitionException {
        try {
            int _type = T__65;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/hampi/parser/Hampi.g:7:7: ( '..' )
            // src/hampi/parser/Hampi.g:7:9: '..'
            {
            match(".."); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__65

    // $ANTLR start KW_VAR
    public final void mKW_VAR() throws RecognitionException {
        try {
            int _type = KW_VAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/hampi/parser/Hampi.g:111:8: ( 'var' )
            // src/hampi/parser/Hampi.g:111:10: 'var'
            {
            match("var"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end KW_VAR

    // $ANTLR start KW_CONCAT
    public final void mKW_CONCAT() throws RecognitionException {
        try {
            int _type = KW_CONCAT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/hampi/parser/Hampi.g:112:11: ( 'concat' )
            // src/hampi/parser/Hampi.g:112:13: 'concat'
            {
            match("concat"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end KW_CONCAT

    // $ANTLR start KW_CFG
    public final void mKW_CFG() throws RecognitionException {
        try {
            int _type = KW_CFG;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/hampi/parser/Hampi.g:113:8: ( 'cfg' )
            // src/hampi/parser/Hampi.g:113:10: 'cfg'
            {
            match("cfg"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end KW_CFG

    // $ANTLR start KW_VAL
    public final void mKW_VAL() throws RecognitionException {
        try {
            int _type = KW_VAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/hampi/parser/Hampi.g:114:8: ( 'val' )
            // src/hampi/parser/Hampi.g:114:10: 'val'
            {
            match("val"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end KW_VAL

    // $ANTLR start KW_REG
    public final void mKW_REG() throws RecognitionException {
        try {
            int _type = KW_REG;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/hampi/parser/Hampi.g:115:8: ( 'reg' )
            // src/hampi/parser/Hampi.g:115:10: 'reg'
            {
            match("reg"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end KW_REG

    // $ANTLR start KW_QUERY
    public final void mKW_QUERY() throws RecognitionException {
        try {
            int _type = KW_QUERY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/hampi/parser/Hampi.g:116:9: ( 'query' )
            // src/hampi/parser/Hampi.g:116:11: 'query'
            {
            match("query"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end KW_QUERY

    // $ANTLR start KW_FIX
    public final void mKW_FIX() throws RecognitionException {
        try {
            int _type = KW_FIX;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/hampi/parser/Hampi.g:117:8: ( 'fix' )
            // src/hampi/parser/Hampi.g:117:10: 'fix'
            {
            match("fix"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end KW_FIX

    // $ANTLR start KW_ASSERT
    public final void mKW_ASSERT() throws RecognitionException {
        try {
            int _type = KW_ASSERT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/hampi/parser/Hampi.g:118:11: ( 'assert' )
            // src/hampi/parser/Hampi.g:118:13: 'assert'
            {
            match("assert"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end KW_ASSERT

    // $ANTLR start KW_CONTAINS
    public final void mKW_CONTAINS() throws RecognitionException {
        try {
            int _type = KW_CONTAINS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/hampi/parser/Hampi.g:119:13: ( 'contains' )
            // src/hampi/parser/Hampi.g:119:15: 'contains'
            {
            match("contains"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end KW_CONTAINS

    // $ANTLR start KW_IN
    public final void mKW_IN() throws RecognitionException {
        try {
            int _type = KW_IN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/hampi/parser/Hampi.g:120:7: ( 'in' )
            // src/hampi/parser/Hampi.g:120:9: 'in'
            {
            match("in"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end KW_IN

    // $ANTLR start KW_STAR
    public final void mKW_STAR() throws RecognitionException {
        try {
            int _type = KW_STAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/hampi/parser/Hampi.g:121:9: ( 'star' )
            // src/hampi/parser/Hampi.g:121:11: 'star'
            {
            match("star"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end KW_STAR

    // $ANTLR start KW_OR
    public final void mKW_OR() throws RecognitionException {
        try {
            int _type = KW_OR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/hampi/parser/Hampi.g:122:7: ( 'or' )
            // src/hampi/parser/Hampi.g:122:9: 'or'
            {
            match("or"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end KW_OR

    // $ANTLR start KW_NOT
    public final void mKW_NOT() throws RecognitionException {
        try {
            int _type = KW_NOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/hampi/parser/Hampi.g:123:8: ( 'not' )
            // src/hampi/parser/Hampi.g:123:10: 'not'
            {
            match("not"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end KW_NOT

    // $ANTLR start LPAREN
    public final void mLPAREN() throws RecognitionException {
        try {
            int _type = LPAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/hampi/parser/Hampi.g:126:8: ( '(' )
            // src/hampi/parser/Hampi.g:126:10: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end LPAREN

    // $ANTLR start RPAREN
    public final void mRPAREN() throws RecognitionException {
        try {
            int _type = RPAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/hampi/parser/Hampi.g:127:8: ( ')' )
            // src/hampi/parser/Hampi.g:127:10: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end RPAREN

    // $ANTLR start LSQUARE
    public final void mLSQUARE() throws RecognitionException {
        try {
            int _type = LSQUARE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/hampi/parser/Hampi.g:128:9: ( '[' )
            // src/hampi/parser/Hampi.g:128:11: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end LSQUARE

    // $ANTLR start RSQUARE
    public final void mRSQUARE() throws RecognitionException {
        try {
            int _type = RSQUARE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/hampi/parser/Hampi.g:129:9: ( ']' )
            // src/hampi/parser/Hampi.g:129:11: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end RSQUARE

    // $ANTLR start COMMA
    public final void mCOMMA() throws RecognitionException {
        try {
            int _type = COMMA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/hampi/parser/Hampi.g:130:7: ( ',' )
            // src/hampi/parser/Hampi.g:130:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end COMMA

    // $ANTLR start EQUALS
    public final void mEQUALS() throws RecognitionException {
        try {
            int _type = EQUALS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/hampi/parser/Hampi.g:131:8: ( '=' )
            // src/hampi/parser/Hampi.g:131:10: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end EQUALS

    // $ANTLR start ASSIGN
    public final void mASSIGN() throws RecognitionException {
        try {
            int _type = ASSIGN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/hampi/parser/Hampi.g:132:8: ( ':=' )
            // src/hampi/parser/Hampi.g:132:10: ':='
            {
            match(":="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end ASSIGN

    // $ANTLR start SEMI
    public final void mSEMI() throws RecognitionException {
        try {
            int _type = SEMI;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/hampi/parser/Hampi.g:133:6: ( ';' )
            // src/hampi/parser/Hampi.g:133:8: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end SEMI

    // $ANTLR start COLON
    public final void mCOLON() throws RecognitionException {
        try {
            int _type = COLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/hampi/parser/Hampi.g:134:7: ( ':' )
            // src/hampi/parser/Hampi.g:134:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end COLON

    // $ANTLR start STAR
    public final void mSTAR() throws RecognitionException {
        try {
            int _type = STAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/hampi/parser/Hampi.g:135:5: ( '*' )
            // src/hampi/parser/Hampi.g:135:7: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end STAR

    // $ANTLR start PLUS
    public final void mPLUS() throws RecognitionException {
        try {
            int _type = PLUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/hampi/parser/Hampi.g:136:5: ( '+' )
            // src/hampi/parser/Hampi.g:136:7: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end PLUS

    // $ANTLR start BAR
    public final void mBAR() throws RecognitionException {
        try {
            int _type = BAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/hampi/parser/Hampi.g:137:4: ( '|' )
            // src/hampi/parser/Hampi.g:137:6: '|'
            {
            match('|'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end BAR

    // $ANTLR start MINUS
    public final void mMINUS() throws RecognitionException {
        try {
            int _type = MINUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/hampi/parser/Hampi.g:138:7: ( '-' )
            // src/hampi/parser/Hampi.g:138:9: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end MINUS

    // $ANTLR start QUESTION
    public final void mQUESTION() throws RecognitionException {
        try {
            int _type = QUESTION;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/hampi/parser/Hampi.g:139:9: ( '?' )
            // src/hampi/parser/Hampi.g:139:11: '?'
            {
            match('?'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end QUESTION

    // $ANTLR start INT
    public final void mINT() throws RecognitionException {
        try {
            int _type = INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/hampi/parser/Hampi.g:141:5: ( ( '0' .. '9' )+ )
            // src/hampi/parser/Hampi.g:141:7: ( '0' .. '9' )+
            {
            // src/hampi/parser/Hampi.g:141:7: ( '0' .. '9' )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='0' && LA1_0<='9')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // src/hampi/parser/Hampi.g:141:8: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end INT

    // $ANTLR start ID
    public final void mID() throws RecognitionException {
        try {
            int _type = ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/hampi/parser/Hampi.g:143:4: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '.' | '0' .. '9' )+ | '\\`' ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '.' | '0' .. '9' )+ '\\`' )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='.'||(LA4_0>='0' && LA4_0<='9')||(LA4_0>='A' && LA4_0<='Z')||LA4_0=='_'||(LA4_0>='a' && LA4_0<='z')) ) {
                alt4=1;
            }
            else if ( (LA4_0=='`') ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // src/hampi/parser/Hampi.g:143:6: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '.' | '0' .. '9' )+
                    {
                    // src/hampi/parser/Hampi.g:143:6: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '.' | '0' .. '9' )+
                    int cnt2=0;
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( (LA2_0=='.'||(LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||LA2_0=='_'||(LA2_0>='a' && LA2_0<='z')) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // src/hampi/parser/Hampi.g:
                    	    {
                    	    if ( input.LA(1)=='.'||(input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt2 >= 1 ) break loop2;
                                EarlyExitException eee =
                                    new EarlyExitException(2, input);
                                throw eee;
                        }
                        cnt2++;
                    } while (true);


                    }
                    break;
                case 2 :
                    // src/hampi/parser/Hampi.g:143:46: '\\`' ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '.' | '0' .. '9' )+ '\\`'
                    {
                    match('`'); 
                    // src/hampi/parser/Hampi.g:143:51: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '.' | '0' .. '9' )+
                    int cnt3=0;
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0=='.'||(LA3_0>='0' && LA3_0<='9')||(LA3_0>='A' && LA3_0<='Z')||LA3_0=='_'||(LA3_0>='a' && LA3_0<='z')) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // src/hampi/parser/Hampi.g:
                    	    {
                    	    if ( input.LA(1)=='.'||(input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


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

                    match('`'); 

                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end ID

    // $ANTLR start STR_LIT
    public final void mSTR_LIT() throws RecognitionException {
        try {
            int _type = STR_LIT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/hampi/parser/Hampi.g:145:9: ( '\\\"' ( EscapeSequence | ~ ( '\\\"' | '\\\\' ) )* '\\\"' )
            // src/hampi/parser/Hampi.g:145:11: '\\\"' ( EscapeSequence | ~ ( '\\\"' | '\\\\' ) )* '\\\"'
            {
            match('\"'); 
            // src/hampi/parser/Hampi.g:145:16: ( EscapeSequence | ~ ( '\\\"' | '\\\\' ) )*
            loop5:
            do {
                int alt5=3;
                int LA5_0 = input.LA(1);

                if ( (LA5_0=='\\') ) {
                    alt5=1;
                }
                else if ( ((LA5_0>='\u0000' && LA5_0<='!')||(LA5_0>='#' && LA5_0<='[')||(LA5_0>=']' && LA5_0<='\uFFFE')) ) {
                    alt5=2;
                }


                switch (alt5) {
            	case 1 :
            	    // src/hampi/parser/Hampi.g:145:18: EscapeSequence
            	    {
            	    mEscapeSequence(); 

            	    }
            	    break;
            	case 2 :
            	    // src/hampi/parser/Hampi.g:145:35: ~ ( '\\\"' | '\\\\' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFE') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            match('\"'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end STR_LIT

    // $ANTLR start CHAR_SEQ
    public final void mCHAR_SEQ() throws RecognitionException {
        try {
            int _type = CHAR_SEQ;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/hampi/parser/Hampi.g:147:10: ( '\\\\' ( '0' .. '9' ) ( '0' .. '9' ) ( '0' .. '9' ) )
            // src/hampi/parser/Hampi.g:147:12: '\\\\' ( '0' .. '9' ) ( '0' .. '9' ) ( '0' .. '9' )
            {
            match('\\'); 
            // src/hampi/parser/Hampi.g:147:17: ( '0' .. '9' )
            // src/hampi/parser/Hampi.g:147:18: '0' .. '9'
            {
            matchRange('0','9'); 

            }

            // src/hampi/parser/Hampi.g:147:27: ( '0' .. '9' )
            // src/hampi/parser/Hampi.g:147:28: '0' .. '9'
            {
            matchRange('0','9'); 

            }

            // src/hampi/parser/Hampi.g:147:37: ( '0' .. '9' )
            // src/hampi/parser/Hampi.g:147:38: '0' .. '9'
            {
            matchRange('0','9'); 

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end CHAR_SEQ

    // $ANTLR start CHAR_LIT
    public final void mCHAR_LIT() throws RecognitionException {
        try {
            int _type = CHAR_LIT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/hampi/parser/Hampi.g:149:10: ( '\\'' ( EscapeSequence | ~ ( '\\\"' | '\\\\' ) ) '\\'' )
            // src/hampi/parser/Hampi.g:149:12: '\\'' ( EscapeSequence | ~ ( '\\\"' | '\\\\' ) ) '\\''
            {
            match('\''); 
            // src/hampi/parser/Hampi.g:149:17: ( EscapeSequence | ~ ( '\\\"' | '\\\\' ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0=='\\') ) {
                alt6=1;
            }
            else if ( ((LA6_0>='\u0000' && LA6_0<='!')||(LA6_0>='#' && LA6_0<='[')||(LA6_0>=']' && LA6_0<='\uFFFE')) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // src/hampi/parser/Hampi.g:149:19: EscapeSequence
                    {
                    mEscapeSequence(); 

                    }
                    break;
                case 2 :
                    // src/hampi/parser/Hampi.g:149:36: ~ ( '\\\"' | '\\\\' )
                    {
                    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFE') ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;

            }

            match('\''); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end CHAR_LIT

    // $ANTLR start EscapeSequence
    public final void mEscapeSequence() throws RecognitionException {
        try {
            // src/hampi/parser/Hampi.g:153:5: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) )
            // src/hampi/parser/Hampi.g:153:9: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' )
            {
            match('\\'); 
            if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||input.LA(1)=='t' ) {
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
    // $ANTLR end EscapeSequence

    // $ANTLR start NEWLINE
    public final void mNEWLINE() throws RecognitionException {
        try {
            int _type = NEWLINE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/hampi/parser/Hampi.g:157:5: ( ( '\\r' )? '\\n' )
            // src/hampi/parser/Hampi.g:157:7: ( '\\r' )? '\\n'
            {
            // src/hampi/parser/Hampi.g:157:7: ( '\\r' )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0=='\r') ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // src/hampi/parser/Hampi.g:157:7: '\\r'
                    {
                    match('\r'); 

                    }
                    break;

            }

            match('\n'); 
             skip(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end NEWLINE

    // $ANTLR start WS
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/hampi/parser/Hampi.g:160:5: ( ( ' ' | '\\t' )+ )
            // src/hampi/parser/Hampi.g:160:9: ( ' ' | '\\t' )+
            {
            // src/hampi/parser/Hampi.g:160:9: ( ' ' | '\\t' )+
            int cnt8=0;
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0=='\t'||LA8_0==' ') ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // src/hampi/parser/Hampi.g:
            	    {
            	    if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
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

             skip(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end WS

    // $ANTLR start COMMENT
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/hampi/parser/Hampi.g:164:5: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // src/hampi/parser/Hampi.g:164:9: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // src/hampi/parser/Hampi.g:164:14: ( options {greedy=false; } : . )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0=='*') ) {
                    int LA9_1 = input.LA(2);

                    if ( (LA9_1=='/') ) {
                        alt9=2;
                    }
                    else if ( ((LA9_1>='\u0000' && LA9_1<='.')||(LA9_1>='0' && LA9_1<='\uFFFE')) ) {
                        alt9=1;
                    }


                }
                else if ( ((LA9_0>='\u0000' && LA9_0<=')')||(LA9_0>='+' && LA9_0<='\uFFFE')) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // src/hampi/parser/Hampi.g:164:42: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            match("*/"); 

            skip();

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end COMMENT

    // $ANTLR start LINE_COMMENT
    public final void mLINE_COMMENT() throws RecognitionException {
        try {
            int _type = LINE_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/hampi/parser/Hampi.g:168:5: ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' )
            // src/hampi/parser/Hampi.g:168:7: '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
            {
            match("//"); 

            // src/hampi/parser/Hampi.g:168:13: (~ ( '\\n' | '\\r' ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>='\u0000' && LA10_0<='\t')||(LA10_0>='\u000B' && LA10_0<='\f')||(LA10_0>='\u000E' && LA10_0<='\uFFFE')) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // src/hampi/parser/Hampi.g:168:13: ~ ( '\\n' | '\\r' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFE') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            // src/hampi/parser/Hampi.g:168:27: ( '\\r' )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0=='\r') ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // src/hampi/parser/Hampi.g:168:27: '\\r'
                    {
                    match('\r'); 

                    }
                    break;

            }

            match('\n'); 
            skip();

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end LINE_COMMENT

    public void mTokens() throws RecognitionException {
        // src/hampi/parser/Hampi.g:1:8: ( T__65 | KW_VAR | KW_CONCAT | KW_CFG | KW_VAL | KW_REG | KW_QUERY | KW_FIX | KW_ASSERT | KW_CONTAINS | KW_IN | KW_STAR | KW_OR | KW_NOT | LPAREN | RPAREN | LSQUARE | RSQUARE | COMMA | EQUALS | ASSIGN | SEMI | COLON | STAR | PLUS | BAR | MINUS | QUESTION | INT | ID | STR_LIT | CHAR_SEQ | CHAR_LIT | NEWLINE | WS | COMMENT | LINE_COMMENT )
        int alt12=37;
        alt12 = dfa12.predict(input);
        switch (alt12) {
            case 1 :
                // src/hampi/parser/Hampi.g:1:10: T__65
                {
                mT__65(); 

                }
                break;
            case 2 :
                // src/hampi/parser/Hampi.g:1:16: KW_VAR
                {
                mKW_VAR(); 

                }
                break;
            case 3 :
                // src/hampi/parser/Hampi.g:1:23: KW_CONCAT
                {
                mKW_CONCAT(); 

                }
                break;
            case 4 :
                // src/hampi/parser/Hampi.g:1:33: KW_CFG
                {
                mKW_CFG(); 

                }
                break;
            case 5 :
                // src/hampi/parser/Hampi.g:1:40: KW_VAL
                {
                mKW_VAL(); 

                }
                break;
            case 6 :
                // src/hampi/parser/Hampi.g:1:47: KW_REG
                {
                mKW_REG(); 

                }
                break;
            case 7 :
                // src/hampi/parser/Hampi.g:1:54: KW_QUERY
                {
                mKW_QUERY(); 

                }
                break;
            case 8 :
                // src/hampi/parser/Hampi.g:1:63: KW_FIX
                {
                mKW_FIX(); 

                }
                break;
            case 9 :
                // src/hampi/parser/Hampi.g:1:70: KW_ASSERT
                {
                mKW_ASSERT(); 

                }
                break;
            case 10 :
                // src/hampi/parser/Hampi.g:1:80: KW_CONTAINS
                {
                mKW_CONTAINS(); 

                }
                break;
            case 11 :
                // src/hampi/parser/Hampi.g:1:92: KW_IN
                {
                mKW_IN(); 

                }
                break;
            case 12 :
                // src/hampi/parser/Hampi.g:1:98: KW_STAR
                {
                mKW_STAR(); 

                }
                break;
            case 13 :
                // src/hampi/parser/Hampi.g:1:106: KW_OR
                {
                mKW_OR(); 

                }
                break;
            case 14 :
                // src/hampi/parser/Hampi.g:1:112: KW_NOT
                {
                mKW_NOT(); 

                }
                break;
            case 15 :
                // src/hampi/parser/Hampi.g:1:119: LPAREN
                {
                mLPAREN(); 

                }
                break;
            case 16 :
                // src/hampi/parser/Hampi.g:1:126: RPAREN
                {
                mRPAREN(); 

                }
                break;
            case 17 :
                // src/hampi/parser/Hampi.g:1:133: LSQUARE
                {
                mLSQUARE(); 

                }
                break;
            case 18 :
                // src/hampi/parser/Hampi.g:1:141: RSQUARE
                {
                mRSQUARE(); 

                }
                break;
            case 19 :
                // src/hampi/parser/Hampi.g:1:149: COMMA
                {
                mCOMMA(); 

                }
                break;
            case 20 :
                // src/hampi/parser/Hampi.g:1:155: EQUALS
                {
                mEQUALS(); 

                }
                break;
            case 21 :
                // src/hampi/parser/Hampi.g:1:162: ASSIGN
                {
                mASSIGN(); 

                }
                break;
            case 22 :
                // src/hampi/parser/Hampi.g:1:169: SEMI
                {
                mSEMI(); 

                }
                break;
            case 23 :
                // src/hampi/parser/Hampi.g:1:174: COLON
                {
                mCOLON(); 

                }
                break;
            case 24 :
                // src/hampi/parser/Hampi.g:1:180: STAR
                {
                mSTAR(); 

                }
                break;
            case 25 :
                // src/hampi/parser/Hampi.g:1:185: PLUS
                {
                mPLUS(); 

                }
                break;
            case 26 :
                // src/hampi/parser/Hampi.g:1:190: BAR
                {
                mBAR(); 

                }
                break;
            case 27 :
                // src/hampi/parser/Hampi.g:1:194: MINUS
                {
                mMINUS(); 

                }
                break;
            case 28 :
                // src/hampi/parser/Hampi.g:1:200: QUESTION
                {
                mQUESTION(); 

                }
                break;
            case 29 :
                // src/hampi/parser/Hampi.g:1:209: INT
                {
                mINT(); 

                }
                break;
            case 30 :
                // src/hampi/parser/Hampi.g:1:213: ID
                {
                mID(); 

                }
                break;
            case 31 :
                // src/hampi/parser/Hampi.g:1:216: STR_LIT
                {
                mSTR_LIT(); 

                }
                break;
            case 32 :
                // src/hampi/parser/Hampi.g:1:224: CHAR_SEQ
                {
                mCHAR_SEQ(); 

                }
                break;
            case 33 :
                // src/hampi/parser/Hampi.g:1:233: CHAR_LIT
                {
                mCHAR_LIT(); 

                }
                break;
            case 34 :
                // src/hampi/parser/Hampi.g:1:242: NEWLINE
                {
                mNEWLINE(); 

                }
                break;
            case 35 :
                // src/hampi/parser/Hampi.g:1:250: WS
                {
                mWS(); 

                }
                break;
            case 36 :
                // src/hampi/parser/Hampi.g:1:253: COMMENT
                {
                mCOMMENT(); 

                }
                break;
            case 37 :
                // src/hampi/parser/Hampi.g:1:261: LINE_COMMENT
                {
                mLINE_COMMENT(); 

                }
                break;

        }

    }


    protected DFA12 dfa12 = new DFA12(this);
    static final String DFA12_eotS =
        "\1\uffff\13\32\6\uffff\1\56\6\uffff\1\57\7\uffff\1\62\7\32\1\73"+
        "\1\32\1\75\1\32\6\uffff\1\77\1\100\1\32\1\103\1\104\1\32\1\106\1"+
        "\32\1\uffff\1\32\1\uffff\1\111\2\uffff\2\32\2\uffff\1\32\1\uffff"+
        "\1\32\1\116\1\uffff\2\32\1\121\1\32\1\uffff\1\123\1\32\1\uffff\1"+
        "\125\1\uffff\1\32\1\uffff\1\127\1\uffff";
    static final String DFA12_eofS =
        "\130\uffff";
    static final String DFA12_minS =
        "\1\11\1\56\1\141\1\146\1\145\1\165\1\151\1\163\1\156\1\164\1\162"+
        "\1\157\6\uffff\1\75\6\uffff\1\56\6\uffff\1\52\1\56\1\154\1\156\2"+
        "\147\1\145\1\170\1\163\1\56\1\141\1\56\1\164\6\uffff\2\56\1\143"+
        "\2\56\1\162\1\56\1\145\1\uffff\1\162\1\uffff\1\56\2\uffff\2\141"+
        "\2\uffff\1\171\1\uffff\1\162\1\56\1\uffff\1\164\1\151\1\56\1\164"+
        "\1\uffff\1\56\1\156\1\uffff\1\56\1\uffff\1\163\1\uffff\1\56\1\uffff";
    static final String DFA12_maxS =
        "\1\174\1\56\1\141\1\157\1\145\1\165\1\151\1\163\1\156\1\164\1\162"+
        "\1\157\6\uffff\1\75\6\uffff\1\172\6\uffff\1\57\1\172\1\162\1\156"+
        "\2\147\1\145\1\170\1\163\1\172\1\141\1\172\1\164\6\uffff\2\172\1"+
        "\164\2\172\1\162\1\172\1\145\1\uffff\1\162\1\uffff\1\172\2\uffff"+
        "\2\141\2\uffff\1\171\1\uffff\1\162\1\172\1\uffff\1\164\1\151\1\172"+
        "\1\164\1\uffff\1\172\1\156\1\uffff\1\172\1\uffff\1\163\1\uffff\1"+
        "\172\1\uffff";
    static final String DFA12_acceptS =
        "\14\uffff\1\17\1\20\1\21\1\22\1\23\1\24\1\uffff\1\26\1\30\1\31\1"+
        "\32\1\33\1\34\1\uffff\1\36\1\37\1\40\1\41\1\42\1\43\15\uffff\1\25"+
        "\1\27\1\35\1\44\1\45\1\1\10\uffff\1\13\1\uffff\1\15\1\uffff\1\2"+
        "\1\5\2\uffff\1\4\1\6\1\uffff\1\10\2\uffff\1\16\4\uffff\1\14\2\uffff"+
        "\1\7\1\uffff\1\3\1\uffff\1\11\1\uffff\1\12";
    static final String DFA12_specialS =
        "\130\uffff}>";
    static final String[] DFA12_transitionS = {
            "\1\37\1\36\2\uffff\1\36\22\uffff\1\37\1\uffff\1\33\4\uffff\1"+
            "\35\1\14\1\15\1\24\1\25\1\20\1\27\1\1\1\40\12\31\1\22\1\23\1"+
            "\uffff\1\21\1\uffff\1\30\1\uffff\32\32\1\16\1\34\1\17\1\uffff"+
            "\2\32\1\7\1\32\1\3\2\32\1\6\2\32\1\10\4\32\1\13\1\12\1\32\1"+
            "\5\1\4\1\11\2\32\1\2\4\32\1\uffff\1\26",
            "\1\41",
            "\1\42",
            "\1\44\10\uffff\1\43",
            "\1\45",
            "\1\46",
            "\1\47",
            "\1\50",
            "\1\51",
            "\1\52",
            "\1\53",
            "\1\54",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\55",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\32\1\uffff\12\31\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\60\4\uffff\1\61",
            "\1\32\1\uffff\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "\1\64\5\uffff\1\63",
            "\1\65",
            "\1\66",
            "\1\67",
            "\1\70",
            "\1\71",
            "\1\72",
            "\1\32\1\uffff\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "\1\74",
            "\1\32\1\uffff\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "\1\76",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\32\1\uffff\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "\1\32\1\uffff\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "\1\101\20\uffff\1\102",
            "\1\32\1\uffff\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "\1\32\1\uffff\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "\1\105",
            "\1\32\1\uffff\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "\1\107",
            "",
            "\1\110",
            "",
            "\1\32\1\uffff\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "",
            "",
            "\1\112",
            "\1\113",
            "",
            "",
            "\1\114",
            "",
            "\1\115",
            "\1\32\1\uffff\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "",
            "\1\117",
            "\1\120",
            "\1\32\1\uffff\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "\1\122",
            "",
            "\1\32\1\uffff\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "\1\124",
            "",
            "\1\32\1\uffff\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "",
            "\1\126",
            "",
            "\1\32\1\uffff\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            ""
    };

    static final short[] DFA12_eot = DFA.unpackEncodedString(DFA12_eotS);
    static final short[] DFA12_eof = DFA.unpackEncodedString(DFA12_eofS);
    static final char[] DFA12_min = DFA.unpackEncodedStringToUnsignedChars(DFA12_minS);
    static final char[] DFA12_max = DFA.unpackEncodedStringToUnsignedChars(DFA12_maxS);
    static final short[] DFA12_accept = DFA.unpackEncodedString(DFA12_acceptS);
    static final short[] DFA12_special = DFA.unpackEncodedString(DFA12_specialS);
    static final short[][] DFA12_transition;

    static {
        int numStates = DFA12_transitionS.length;
        DFA12_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA12_transition[i] = DFA.unpackEncodedString(DFA12_transitionS[i]);
        }
    }

    class DFA12 extends DFA {

        public DFA12(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 12;
            this.eot = DFA12_eot;
            this.eof = DFA12_eof;
            this.min = DFA12_min;
            this.max = DFA12_max;
            this.accept = DFA12_accept;
            this.special = DFA12_special;
            this.transition = DFA12_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__65 | KW_VAR | KW_CONCAT | KW_CFG | KW_VAL | KW_REG | KW_QUERY | KW_FIX | KW_ASSERT | KW_CONTAINS | KW_IN | KW_STAR | KW_OR | KW_NOT | LPAREN | RPAREN | LSQUARE | RSQUARE | COMMA | EQUALS | ASSIGN | SEMI | COLON | STAR | PLUS | BAR | MINUS | QUESTION | INT | ID | STR_LIT | CHAR_SEQ | CHAR_LIT | NEWLINE | WS | COMMENT | LINE_COMMENT );";
        }
    }
 

}