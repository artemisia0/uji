grammar Expr;		

file: term_list '\n'*;
term_list: '{' term? (',' ' ' term)* ','? '}';
term: INT | term_list;
INT: [0-9]+;

