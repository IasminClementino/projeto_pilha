@echo off
rmdir /S /Q bin
mkdir bin
javac -d bin -sourcepath src src\interfaces\repositories\*.java src\interfaces\services\*.java src\exceptions\*.java src\models\*.java src\repositories\*.java src\services\*.java src\utils\*.java src\facades\*.java src\Main.java
echo Done.
