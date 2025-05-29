@echo off
echo Generating input...

REM Create input.txt with 1005 blank lines
(
    for /L %%i in (1,1,1005) do echo.
) > input.txt

echo Compiling...

javac Simulation.java
if %errorlevel% neq 0 (
    echo Compilation failed.
    pause
    exit /b
)

echo Running...
java Simulation < input.txt

echo Deleting..
del *class
del input.txt

pause