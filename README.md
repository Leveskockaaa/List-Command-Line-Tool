# List-Command-Line-Tool

## Clone the repository

Clone the repository with the following command:
git clone https://github.com/Leveskockaaa/List-Command-Line-Tool.git

## Dependencies

JDK 21 or latest
Maven 3.6 or latest

## Build the project with Maven

Go to the root directory and run the following command:
mvn compile

## Compile the source code with javac

Go to the root directory and run the following command:
javac -d target/classes/ src/main/java/*.java

## Run the code

java -cp /path/to/root/directory/target/classes/ Main

## Add to list of commands on linux

Edit your .bashrc file, put the following lines somewhere in the file:
function list() {
    java -cp /path/to/root/directory/target/classes Main
}
