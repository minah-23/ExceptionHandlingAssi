@echo off

REM Compile the Java file
javac -d . *.java

REM Normal case
echo Testing normal case...
java Assig6 test.arxml
echo ----------------------------------------------------------------------------------
REM Not valid Autosar file case
echo Testing not valid Autosar file case...
java Assig6 wrongExtension.txt
echo ----------------------------------------------------------------------------------
REM Empty file case
echo Testing empty file case...
java Assig6 empty.arxml
echo ----------------------------------------------------------------------------------

REM Clean up compiled Java files
del assi6\*.class

pause