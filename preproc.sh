javac src/main/java/com/uji/preprocessedCode/*.java -d .java_out
javac -cp .java_out src/main/java/com/uji/tools/preprocessor/Main.java -d .java_out
java -cp .java_out com.uji.tools.preprocessor.Main code.uji

