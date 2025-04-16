# List-Command-Line-Tool

## Clone the repository

Clone the repository with the following command:  
```sh
git clone https://github.com/Leveskockaaa/List-Command-Line-Tool.git
```

## Dependencies

- JDK 21 or latest  
- Maven 3.6 or latest

## Build the project with Maven

Go to the root directory and run the following command:  
```sh
mvn compile
```

## Compile the source code with javac

Go to the root directory and run the following command:  
```sh
javac -d target/classes/ src/main/java/*.java
```

## Run the code

```sh
java -cp /path/to/root/directory/target/classes/ Main
```

## Add to list of commands on Linux

Edit your `.bashrc` file, and put the following lines somewhere in the file:  
```bash
function list() {
    java -cp /path/to/root/directory/target/classes Main
}
```

