# Java Tutorial Repo <a name="java-tutorial-repo"></a>

## By Tirthraj Mahajan

This repository contains all my Java tutorial files, ranging from basic to advanced concepts.

References: <a href="https://www.geeksforgeeks.org/"> Geeks For Geeks </a>

---

# Table of Contents

1. [Java Tutorial Repo](#java-tutorial-repo)
2. [Introduction to Java](#introduction-to-java)
3. [JVM Architecture](#jvm-architecture)
4. [Differences between JDK, JRE, and JVM](#differences-between-jdk-jre-and-jvm)
5. [Java Hello World Program](#java-hello-world-program)


---

## <a id="introduction-to-java"> Introduction to Java </a>

Java is a class-based, object-oriented programming language that is designed to have as few implementation dependencies as possible. It is intended to let application developers write once, and run anywhere (WORA), meaning that compiled Java code can run on all platforms that support Java without the need for recompilation. Java was first released in 1995 and is widely used for developing applications for desktop, web, and mobile devices. Java is known for its simplicity, robustness, and security features, making it a popular choice for enterprise-level applications.

![Java Logo](https://brandslogos.com/wp-content/uploads/images/large/java-logo-1.png)


JAVA was developed by James Gosling at Sun Microsystems Inc in the year 1995 and later acquired by Oracle Corporation. It is a simple programming language. Java makes writing, compiling, and debugging programming easy. It helps to create reusable code and modular programs. Java is a class-based, object-oriented programming language and is designed to have as few implementation dependencies as possible. A general-purpose programming language made for developers to write once run anywhere that is compiled Java code can run on all platforms that support Java. Java applications are compiled to byte code that can run on any Java Virtual Machine. The syntax of Java is similar to c/c++.  

---
## <a id="jvm-architecture">JVM Architecture</a>

JVM (Java Virtual Machine) acts as a run-time engine to execute Java applications. It is a part of JRE (Java Runtime Environment) and is responsible for invoking the main method present in a Java code.

Java applications adhere to the principle of WORA (Write Once Run Anywhere), meaning a programmer can develop Java code on one system and expect it to run on any other Java-enabled system without any adjustment. This is facilitated by JVM.

When we compile a `.java` file, `.class` files (containing bytecode) with the same class names present in the `.java` file are generated by the Java compiler. These `.class` files undergo various steps when we run them, collectively defining the entire JVM.

![JVM Architecture](https://media.geeksforgeeks.org/wp-content/uploads/jvm-3.jpg)

### Class Loader Subsystem

The Class Loader subsystem is responsible for three main activities: Loading, Linking, and Initialization.

#### Loading

The Class Loader reads the `.class` file, generates the corresponding binary data, and saves it in the method area. For each `.class` file, JVM stores information such as the fully qualified name of the loaded class and its immediate parent class, whether the `.class` file is related to a Class or Interface or Enum, modifier, variables, and method information, etc. After loading the `.class` file, JVM creates an object of type Class to represent this file in the heap memory.

#### Linking

Linking involves verification, preparation, and (optionally) resolution.

- **Verification:** It ensures the correctness of the `.class` file, checking whether it is properly formatted and generated by a valid compiler. If verification fails, we get a runtime exception `java.lang.VerifyError`.
- **Preparation:** JVM allocates memory for class static variables and initializes the memory to default values.
- **Resolution:** It replaces symbolic references from the type with direct references, searching into the method area to locate the referenced entity.

#### Initialization

In this phase, all static variables are assigned their values defined in the code and static blocks (if any). This is executed from top to bottom in a class and from parent to child in the class hierarchy.

In general, there are three class loaders:

- **Bootstrap class loader:** Every JVM implementation must have a bootstrap class loader, capable of loading trusted classes. It loads core Java API classes present in the `JAVA_HOME/jre/lib` directory.
- **Extension class loader:** It is a child of the bootstrap class loader and loads classes present in the extensions directories (`JAVA_HOME/jre/lib/ext`) or any other directory specified by the `java.ext.dirs` system property.
- **System/Application class loader:** It is a child of the extension class loader and is responsible for loading classes from the application classpath. It internally uses Environment Variable mapped to `java.class.path`.

---

## <a id="differences-between-jdk-jre-and-jvm">Differences between JDK, JRE, and JVM</a>

Java Development Kit (JDK) is a software development environment used for creating Java applications and applets. It includes the Java Runtime Environment (JRE), an interpreter/loader (Java), a compiler (javac), an archiver (jar), a documentation generator (Javadoc), and other tools necessary for Java development.

Java Runtime Environment (JRE) provides the minimum requirements for executing a Java application. It includes the Java Virtual Machine (JVM), core classes, and supporting files. JRE is utilized by end-users who only want to run Java programs and do not need to develop them.

Java Virtual Machine (JVM) is an essential component of both JDK and JRE. It is responsible for executing Java programs line by line, acting as an interpreter. Whatever Java program you run using JRE or JDK is processed by the JVM.

![JVM, JRE, JDK](https://media.geeksforgeeks.org/wp-content/uploads/20210218150010/JDK.png)

### Key Differences:

1. **JDK (Java Development Kit):**
   - Provides an environment for developing and executing Java programs.
   - Includes development tools (to develop Java programs) and JRE (to execute Java programs).

2. **JRE (Java Runtime Environment):**
   - Provides an environment for running Java programs (not for development).
   - Utilized by end-users who only need to execute Java applications.

3. **JVM (Java Virtual Machine):**
   - Responsible for executing Java programs.
   - Inbuilt in both JDK and JRE.
   - Acts as an interpreter, executing Java code line by line.

---

## <a id="java-hello-world-program">Java Hello World Program</a>

Implementing a Java application program involves the following steps:

### 1. Creating Programs in Java

```java
class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");
    }
}
```

### 2. Compiling the Program in Java  
To compile the program, we must run the Java compiler (javac), with the name of the source file on the command prompt as follows:
```powershell
javac Main.java
```

### 3. Running the Program in Java

```powershell
java Main
```

### Output
```
Hello World
```

---

Now you can start with checking out the lessons in the repository
