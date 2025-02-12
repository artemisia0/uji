grammar ujiFile;

//////////////////////////////////////// 		PARSER RULES
ujiFile
	: (eols? ujiMulBinding eols?)* EOF;

ujiMulBinding
	: ID ':' ujiMulRvalue;
ujiOneBinding
	: ID ':' ujiOneRvalue;

ujiMulRvalue
	: ujiMulDef
	| ujiMulCopy
	| ujiMulBinding
	| ujiOneRvalue;
ujiOneRvalue
	: ujiOneDef # ujiOneRvalueOneDefOption
	| ujiOneCopy # ujiOneRvalueOneCopyOption
	| ujiOneBinding # ujiOneRvalueOneBindingOption ;

ujiPrimary
	: (key=ID ':')? (('<' primaryRvalue=ujiOneRvalue '>') | primaryLiteral=ujiLiteral | primaryKey=ID) ('.' attrs+=ID)* packed='...'?;

ujiMulDef
	: '/' ujiDefParams indent ujiMulRvalue (eols ujiMulBinding)* unindent # ujiMulDefMulOption
	| ujiShortMulDef # ujiMulDefShortOption;
ujiShortMulDef
	: '/' ujiDefParams '/' ujiMulRvalue # ujiShortMulDefMulOption
	| ujiOneDef # ujiShortMulDefOneOption;
ujiOneDef
	: '/' ujiDefParams '/' ujiOneRvalue;

ujiDefParams
	: keys+=ID* ('...' packedKey=ID)? (bindingKeys+=ID ':' bindingObjects+=ujiPrimary)*;

ujiMulCopy
	: ujiPrimary indent ujiMulRvalue (eols ujiMulRvalue)* unindent # ujiMulCopyMulOption
	| ujiOneCopy # ujiMulCopyOneOption;
ujiOneCopy
	: ujiPrimary+;

ujiLiteral: FMT_STRING | RAW_STRING | FLOAT | INT;

indent: eols? '{' eols?;
unindent: eols? '}' eols?;

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

