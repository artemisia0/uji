grammar uji_file;

uji_file: uji_binding*;
uji_binding: ID? ':' uji_rvalue;
uji_rvalue: uji_def | uji_copy | uji_literal;
uji_def: '/' ID* INDENT uji_copy (EOL uji_binding)* UNINDENT;
uji_copy: ID INDENT (uji_rvalue | uji_binding) (EOL uji_rvalue | uji_binding)* UNINDENT
		| '<' ID (uji_rvalue | uji_binding)+ '>'
		| ID (uji_rvalue | uji_binding)*;
uji_literal: STRING | FLOAT | INT;

INT: [0-9]+;
STRING: '\'' ~[']*? '\'';
FLOAT: [0-9]+ '.' [0-9]+;
INDENT: (WS | EOL)* '{' (WS | EOL)*;
UNINDENT: (WS | EOL)* '}' (WS | EOL)*;
EOL: '\n' | '\r\n';
ID: [a-zA-Z_][a-zA-Z_0-9]*;
WS: [ \t\r]+ -> skip;  // But keep newlines
COMMENT: ';' .*? EOL -> skip;

