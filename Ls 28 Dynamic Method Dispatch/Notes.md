# Difference in Method Dispatch in C++ and Java
  
## C++
Take a look at C++ Code:
```c++
#include <iostream>
using namespace std;
class A{
public:
    void show(){
        cout<<"In A Show"<<endl;
    }
};

class B: public A{
public:
    void show(){
        cout<<"In B show"<<endl;
    }
};

int main(){
    B obj;
    A &ref = obj;
    ref.show(); // Prints "In A Show"
    
    // or using pointers
    
    A* ptr = new B();
    ptr->show(); // Prints "In A Show"
}

```
In C++, the method invocation resolution is determined at compile time through static binding. 
Thus when you have a base class pointer or reference pointing to a derived class object and you call a member function that is overridden in the derived class, the decision about which function to call is made at compile time, based on the type of the pointer or reference.

```c++
A &ref = obj;
ref.show(); // Prints "In A Show"
```

Even though obj is an instance of class B, since the reference ref is of type A, the compiler resolves the function call ref.show() to the show() function of class A. 

> Dynamic Method Dispatch or Run Time Polymorphism is achieved using `virtual` keyword in C++

However, it requires explicit use of the virtual keyword for dynamic dispatch to occur.

Thus, if you use `virtual` keyword, the code will run as it will work in Java

```c++
#include <iostream>
using namespace std;
class A{
public:
    virtual void show(){
        cout<<"In A Show"<<endl;
    }
};

class B: public A{
public:
    void show(){
        cout<<"In B show"<<endl;
    }
};

int main(){
    B obj;
    A &ref = obj;
    ref.show(); // Prints "In B Show"
    
    // or using pointers
    
    A* ptr = new B();
    ptr->show(); // Prints "In B Show"
}

```

---

## Java

Lets take a look at Java Code

```java
class A{
    public void show(){
        System.out.println("In A Show");
    }
}

class B extends A{
    public void show(){
        System.out.println("In B Show");
    }
}

public class Main{
    public static void main(String[] args) {
        A ref = new B();
        ref.show(); // Prints "In B Show"
    }
}
```

In Java, method invocation resolution is performed at runtime through dynamic binding. This means that when a method is called using a reference variable, the JVM determines the actual class of the object at runtime and invokes the appropriate method implementation.

Thus, in Java, the decision about which method to call is made at runtime based on the type of the actual object, not the reference type.

Polymorphism in Java is inherent due to the language design. All non-static methods are virtual by default, and dynamic method dispatch is automatic. This simplifies the syntax and usage of polymorphism compared to C++