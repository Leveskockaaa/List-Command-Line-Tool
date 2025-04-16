# **List-Command-Line-Tool**

## **Usage**

This program allows you to display and sort files and directories based on command-line arguments. You can use the arguments below to control how files are displayed and sorted.

### **Show Arguments**

Use the following arguments to control which files or directories are shown.

- `-hidden`: Displays hidden files.
- `-dirs`: Displays only directories.

### **Sort Arguments**

These arguments allow you to sort the files based on different criteria.

- `-size`: Sorts the files by their size in ascending order. The files with smaller sizes will be listed first.
- `-date`: Sorts the files by their last modification date, with the most recently modified files listed first.

#### **Important Note**

- You can only use **one** sort argument at a time. If multiple sort arguments are provided (e.g., `-size` and `-date`), the program will throw an error and display a message stating that only one sort argument can be used at a time.

### **Example usages**

```bash
list - hidden -dirs -date
```

## **Installation**

### **Dependencies**

- JDK 21 or latest  
- Maven 3.6 or latest

### **Clone the repository**

Clone the repository with the following command:

```sh
git clone https://github.com/Leveskockaaa/List-Command-Line-Tool.git
```

### **Build the project with Maven**

Go to the root directory and run the following command:  

```sh
mvn compile
```

### **Compile the source code with javac**

Go to the root directory and run the following command:  

```sh
javac -d target/classes/ src/main/java/*.java
```

### **Run the code**

```sh
java -cp /path/to/root/directory/target/classes/ Main
```

### **Add to list of commands on Linux**

Edit your `.bashrc` file, and put the following lines somewhere in the file:  

```bash
function list() {
    java -cp /path/to/root/directory/target/classes Main "$@"
}
```
