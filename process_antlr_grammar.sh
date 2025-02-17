java -jar antlr-4.13.2-complete.jar ./src/main/antlr/ujiFile.g4 -package com.uji.antlr -visitor -no-listener -o antlr_output
rm -f src/main/java/com/uji/antlr/*
mv antlr_output/src/main/antlr/* src/main/java/com/uji/antlr
rm -rf antlr_output

