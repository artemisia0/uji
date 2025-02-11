rm -rf .java_out
javac -cp /home/boss/.m2/repository/org/antlr/antlr4/4.13.2/antlr4-4.13.2-complete.jar $(find src/main/java/com/uji/ -type f -name "*.java") -d .java_out -Xlint -Xdiags:verbose

