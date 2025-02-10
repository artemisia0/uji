./preproc.sh > .tmp/parser_input
antlr4-parse ujiFile.g4 ujiFile -gui < .tmp/parser_input

