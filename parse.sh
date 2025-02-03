./preproc.sh > .tmp/parser_input
antlr4-parse uji_file.g4 uji_file -gui < .tmp/parser_input

