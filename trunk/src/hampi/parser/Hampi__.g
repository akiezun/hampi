lexer grammar Hampi;

@header { 
     package hampi.parser; 
   }

T__66 : '..' ;

// $ANTLR src "src/hampi/parser/Hampi.g" 113
KW_VAR : 'var' ;
// $ANTLR src "src/hampi/parser/Hampi.g" 114
KW_CONCAT : 'concat';
// $ANTLR src "src/hampi/parser/Hampi.g" 115
KW_CFG : 'cfg' ;
// $ANTLR src "src/hampi/parser/Hampi.g" 116
KW_VAL : 'val' ;
// $ANTLR src "src/hampi/parser/Hampi.g" 117
KW_REG : 'reg' ;
// $ANTLR src "src/hampi/parser/Hampi.g" 118
KW_QUERY: 'query';
// $ANTLR src "src/hampi/parser/Hampi.g" 119
KW_FIX : 'fix' ;
// $ANTLR src "src/hampi/parser/Hampi.g" 120
KW_ASSERT : 'assert' ;
// $ANTLR src "src/hampi/parser/Hampi.g" 121
KW_CONTAINS : 'contains' ;
// $ANTLR src "src/hampi/parser/Hampi.g" 122
KW_IN : 'in' ;
// $ANTLR src "src/hampi/parser/Hampi.g" 123
KW_STAR : 'star' ;
// $ANTLR src "src/hampi/parser/Hampi.g" 124
KW_OR : 'or' ;
// $ANTLR src "src/hampi/parser/Hampi.g" 125
KW_NOT : 'not' ;

// Punctuation
// $ANTLR src "src/hampi/parser/Hampi.g" 128
LPAREN : '(';
// $ANTLR src "src/hampi/parser/Hampi.g" 129
RPAREN : ')';
// $ANTLR src "src/hampi/parser/Hampi.g" 130
LSQUARE : '[';
// $ANTLR src "src/hampi/parser/Hampi.g" 131
RSQUARE : ']';
// $ANTLR src "src/hampi/parser/Hampi.g" 132
COMMA : ',';	
// $ANTLR src "src/hampi/parser/Hampi.g" 133
EQUALS : '=';
// $ANTLR src "src/hampi/parser/Hampi.g" 134
ASSIGN : ':=';
// $ANTLR src "src/hampi/parser/Hampi.g" 135
SEMI : ';';
// $ANTLR src "src/hampi/parser/Hampi.g" 136
COLON : ':';
// $ANTLR src "src/hampi/parser/Hampi.g" 137
STAR: '*'; 
// $ANTLR src "src/hampi/parser/Hampi.g" 138
PLUS: '+'; 
// $ANTLR src "src/hampi/parser/Hampi.g" 139
BAR: '|'; 
// $ANTLR src "src/hampi/parser/Hampi.g" 140
MINUS : '-';
// $ANTLR src "src/hampi/parser/Hampi.g" 141
QUESTION: '?'; 

// $ANTLR src "src/hampi/parser/Hampi.g" 143
INT : ('0'..'9')+;

// $ANTLR src "src/hampi/parser/Hampi.g" 145
ID : ('a'..'z'|'A'..'Z'|'_'|'.'|'0'..'9')+ | '\`' ('a'..'z'|'A'..'Z'|'_'|'.'|'0'..'9')+ '\`'; 

// $ANTLR src "src/hampi/parser/Hampi.g" 147
STR_LIT : '\"' ( EscapeSequence | ~('\"'|'\\'))* '\"' ;

// $ANTLR src "src/hampi/parser/Hampi.g" 149
CHAR_SEQ : '\\' ('0'..'9')('0'..'9')('0'..'9') ; // PIETER

// $ANTLR src "src/hampi/parser/Hampi.g" 151
CHAR_LIT : '\'' ( EscapeSequence | ~('\"'|'\\')) '\''; 

// $ANTLR src "src/hampi/parser/Hampi.g" 153
fragment
EscapeSequence
    :   '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\')
    ;

// $ANTLR src "src/hampi/parser/Hampi.g" 158
NEWLINE
    :	'\r'? '\n' { skip(); }
    ;

// $ANTLR src "src/hampi/parser/Hampi.g" 162
WS  :   (' '|'\t')+ { skip(); }
    ;
   
// $ANTLR src "src/hampi/parser/Hampi.g" 165
COMMENT
    :   '/*' ( options {greedy=false;} : . )* '*/' {skip();}
    ;

// $ANTLR src "src/hampi/parser/Hampi.g" 169
LINE_COMMENT
    : '//'  ~('\n'|'\r')* '\r'? '\n' {skip();}
    ;
