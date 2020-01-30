#! /bin/sh

cd src

javac com/ipg/my/*.java
javac com/ipg/my/**/*.java

mkdir -p ../bin/com/ipg/my/{exception,file,util}

cp com/ipg/my/*.class ../bin/com/ipg/my
cp com/ipg/my/exception/*.class ../bin/com/ipg/my/exception
cp com/ipg/my/file/*.class ../bin/com/ipg/my/file
cp com/ipg/my/util/*.class ../bin/com/ipg/my/util

cd ../bin

jar cfe IpgTest.jar com.ipg.my.InputReader com/ipg/my/**/*.class com/ipg/my/*.class
