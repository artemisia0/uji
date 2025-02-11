# ./generate_java_code.sh
./preproc.sh > .tmp/preprocessed_code.uji
./compile_java.sh
./run_java.sh .tmp/preprocessed_code.uji

