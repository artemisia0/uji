rm -rf src/main/java/com/uji/antlr_output/
mkdir src/main/java/com/uji/antlr_output/
antlr4 -o src/main/java/com/uji/antlr_output/ ujiFile.g4 -no-listener -visitor -package com.uji.antlr_output

