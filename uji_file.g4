grammar uji_file;

//////////////////////////////////////// 		PARSER RULES
uji_file
	: (eols? uji_mul_binding eols?)* EOF;

uji_mul_binding
	: ID ':' uji_mul_rvalue;
uji_one_binding
	: ID ':' uji_one_rvalue;

uji_mul_rvalue
	: uji_mul_def
	| uji_mul_copy
	| uji_mul_binding
	| uji_one_rvalue;
uji_one_rvalue
	: uji_one_def
	| uji_one_copy
	| uji_one_binding;

uji_primary
	: (ID ':')? (('<' uji_one_rvalue '>') | uji_literal | ID) ('.' ID)* '...'?;

uji_mul_def
	: ('/' uji_def_params indent uji_mul_rvalue (eols uji_mul_binding)* unindent)
	| uji_short_mul_def;
uji_short_mul_def
	: ('/' uji_def_params '/' uji_mul_rvalue)
	| uji_one_def;
uji_one_def
	: '/' uji_def_params '/' uji_one_rvalue;

uji_def_params
	: ID* ('...' ID)? (ID ':' uji_primary)*;

uji_mul_copy
	: (uji_primary indent uji_mul_rvalue (eols uji_mul_rvalue)* unindent)
	| uji_one_copy;
uji_one_copy
	: uji_primary+;

uji_literal: STRING | FLOAT | INT;

indent: eols? '{' eols?;
unindent: eols? '}' eols?;

eols: EOL+;
////////////////////////////////////////


//////////////////////////////////////// 		LEXER RULES
INT: [0-9]+;
STRING: '\'' ~[']*? '\'';
FLOAT: [0-9]+ '.' [0-9]+;
EOL: '\r'? '\n';
ID: [a-zA-Z_][a-zA-Z_0-9]*;
WS: [ \t]+ -> skip;  // But keep newlines
COMMENT: ';' ~[\r\n]* -> skip;
/////////////////////////////////////////


///////////////////////////////////////// 	 NOTES
// Notes on rule naming.
// All rules have prefix `uji`.
// Multiline rules have prefix `mul`.
// Oneline   rules have prefix `one`.
// Some rules are multiline or oneline only (def is mul only for example).
// Every oneline rule is multiline rule also but not vice versa.
// `rvalue` is any value that can be on right side of ':' or that
// can be passed to an object copy as an argument.

