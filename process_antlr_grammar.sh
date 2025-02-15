java -jar antlr-4.13.2-complete.jar ./src/main/antlr/ujiFile.g4 -package com.uji.antlr -visitor -no-listener -o antlr_output
mv antlr_output/src/main/antlr/* src/main/java/com/uji/antlr
rm -rf antlr_output

