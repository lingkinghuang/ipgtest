cd src

javac com\ipg\my\*.java
javac com\ipg\my\**\*.java

cd..

mkdir bin
mkdir bin\com\ipg\my 
mkdir bin\com\ipg\my\exception 
mkdir bin\com\ipg\my\file
mkdir bin\com\ipg\my\util

move src\com\ipg\my\*.class bin\com\ipg\my
move src\com\ipg\my\exception\*.class bin\com\ipg\my\exception
move src\com\ipg\my\file\*.class bin\com\ipg\my\file
move src\com\ipg\my\util\*.class bin\com\ipg\my\util

cd bin

jar cfe IpgTest.jar com.ipg.my.InputReader com\ipg\my\**\*.class com\ipg\my\*.class

# This .bat file is untested on Windows - apologies, I do not have the environment for this. 