#!/usr/bin/env bash

echo "Generating input..."

# Create input.txt with 1005 blank lines
for i in {1..1005}; do
    echo "" >> input.txt
done

echo "Compiling..."

javac Simulation.java
if [ $? -ne 0 ]; then
    echo "Compilation failed."
    read -p "Press enter to exit..."
    exit 1
fi

echo "Running..."
java Simulation < input.txt

echo "Deleting..."
rm -f *.class input.txt

read -p "Press enter to exit..."
