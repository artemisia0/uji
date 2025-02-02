javac src/main/java/com/uji/preprocessedCode/*.java -d out
javac -cp out src/main/java/com/uji/tools/preprocessor/Main.java -d out
java -cp out com.uji.tools.preprocessor.Main code.uji

