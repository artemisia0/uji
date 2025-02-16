grammar ujiFile;

//////////////////////////////////////// 		PARSER RULES
ujiFile
	: (eols? ujiMulBinding eols?)* EOF;

ujiMulBinding
	: ID COLON ujiMulRvalue;
ujiOneBinding
	: ID COLON ujiOneRvalue;

ujiMulRvalue
	: ujiMulDef # ujiMulRvalueMulDefOption
	| ujiMulCopy # ujiMulRvalueMulCopyOption
	| ujiMulBinding # ujiMulRvalueMulBindingOption
	| ujiOneRvalue # ujiMulRvalueOneRvalueOption ;
ujiOneRvalue
	: ujiOneDef # ujiOneRvalueOneDefOption
	| ujiOneCopy # ujiOneRvalueOneCopyOption
	| ujiOneBinding # ujiOneRvalueOneBindingOption ;

ujiPrimaryBase
	: (LEFT_T_BRACE rvalue=ujiOneRvalue RIGHT_T_BRACE) # ujiPrimaryBaseRvalueOption
	| literal=ujiLiteral # ujiPrimaryBaseLiteralOption
	| key=ID # ujiPrimaryBaseKeyOption ; 
ujiPrimary
	: (key=ID COLON)? ujiPrimaryBase (DOT attrs+=ID)* packed=THREE_DOTS?;

ujiMulDef
	: SLASH ujiDefParams indent ujiMulRvalue (eols ujiMulBinding)* unindent # ujiMulDefMulOption
	| ujiShortMulDef # ujiMulDefShortOption;
ujiShortMulDef
	: SLASH ujiDefParams SLASH ujiMulRvalue # ujiShortMulDefMulOption
	| ujiOneDef # ujiShortMulDefOneOption;
ujiOneDef
	: SLASH ujiDefParams SLASH ujiOneRvalue;

ujiDefParams
	: keys+=ID* (THREE_DOTS packedKey=ID)? (bindingKeys+=ID COLON bindingObjects+=ujiPrimary)*;

ujiMulCopy
	: ujiPrimary indent ujiMulRvalue (eols ujiMulRvalue)* unindent # ujiMulCopyMulOption
	| ujiOneCopy # ujiMulCopyOneOption;
ujiOneCopy
	: ujiPrimary+;

ujiLiteral: FMT_STRING | RAW_STRING | FLOAT | INT;

indent: eols? INDENT_CHAR eols?;
unindent: eols? UNINDENT_CHAR eols?;

eols: EOL+;
////////////////////////////////////////


//////////////////////////////////////// 		LEXER RULES
INT: [0-9]+;
RAW_STRING: '\'' ('\\\'' | ~'\'')*? '\'';
FMT_STRING: '"' ('\\"' | ~'"')*? '"';
FLOAT: [0-9]+ '.' [0-9]+;
EOL: '\r'? '\n';
ID: [a-zA-Z_][a-zA-Z_0-9]*;
WS: [ \t]+ -> skip;  // But keep newlines
COMMENT: ';' ~[\r\n]* -> skip;
COLON: ':';
LEFT_T_BRACE: '<';
RIGHT_T_BRACE: '>';
DOT: '.';
THREE_DOTS: '...';
SLASH: '/';
INDENT_CHAR: '{';
UNINDENT_CHAR: '}';
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

