grammar function;

options {
  language = Java;
  output = AST;
  ASTLabelType = CommonTree;
}

tokens {
  OPEN_PAREN = '(';
  CLOSE_PAREN = ')';
  COMMA = ',';
  TRUE = 'true';
  FALSE = 'false';
}

@header {
  package com.sysord.mad.functionparser.grammar;
}

@lexer::header { 
  package com.sysord.mad.functionparser.grammar;
}

root
  : expression
  ;

function
  : ID^ OPEN_PAREN! parameters? CLOSE_PAREN!
  ;
  
parameters
  : expression (COMMA! expression)*
  ;
  
expression
  : ID
  | (function) => function
  | VAR
  | INTEGER
  | DECIMAL
  | bool
  | STRING_LITERAL
  ;

bool
  : TRUE
  | FALSE
  ;
  
/************************************************************************************************
*                                       LEXER
************************************************************************************************/

// Multi line String literal
STRING_LITERAL
  : '\''
    { StringBuilder b = new StringBuilder(); }
    ( '\'' '\''       { b.appendCodePoint('\'');}
//    | c=~('\''|'\r'|'\n')  { b.appendCodePoint(c);}
    | c=~('\'')  { b.appendCodePoint(c);}
    )*
    '\''
    { setText(b.toString()); }
  ;
  
fragment LETTER : ('a'..'z' | 'A'..'Z') ;
fragment DIGIT : '0'..'9';
fragment UNDERSCORE : '_';
INTEGER : ('-')? DIGIT+ ;
DECIMAL : ('-')? DIGIT+ '.' DIGIT+;
ID : (LETTER | UNDERSCORE) (LETTER | DIGIT | UNDERSCORE)*;
VAR : '$' ID;
WS : (' ' | '\t' | '\n' | '\r' | '\f')+ {$channel = HIDDEN;};
COMMENT : '//' .* ('\n'|'\r') {$channel = HIDDEN;};
