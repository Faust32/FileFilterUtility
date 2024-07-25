# FileFilterUtility

Java course test assignment for "ЦФТ ШИФТ". The utility takes certain parameters and several files as input, then filters their contents into 3 files.

## Requirements

- Java 11 or higher
  
- Maven (4.0.0)

  
## Usage

Here is the example of using utility:

```
java -jar fileFilter.jar [options] <input-file1> <input-file2> ...
```

### Options

'-o <path>': Specify output directory (default: current directory)

'-p <prefix>': Set prefix for output files (default: no prefix)

'-a': Append to existing files instead of overwriting

'-s': Generate short statistics

'-f': Generate full statistics


### Output Files

'<prefix>integers.txt': Contains sorted integer values

'<prefix>floats.txt': Contains sorted floating-point values

'<prefix>strings.txt': Contains sorted string values


## Statistics

Statistics are displayed in the console after processing.

### Short Statistics (-s)

Displays the count of elements for each data type.

### Full Statistics (-f)

Integers and Floats: Count, minimum, maximum, sum, and average

Strings: Count, shortest length, and longest length


## Building the Project

- Clone the repository in a desired directory:
```
git clone https://github.com/Faust32/FileFilterUtility.git
```
- Navigate to its directory

- Build a package using Maven:
```
mvn clean package
```

The compiled JAR will be available in the target directory.
