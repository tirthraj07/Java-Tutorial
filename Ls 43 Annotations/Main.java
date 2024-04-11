/*
Annotations are used to provide supplemental information about a program. 

Annotations start with ‘@’.
Annotations do not change the action of a compiled program.
Annotations help to associate metadata (information) to the program elements i.e. instance variables, constructors, methods, classes, etc.
Annotations are not pure comments as they can change the way a program is treated by the compiler.

We will use most of the annotations in Frameworks -> Hibernate, Spring, etc

1. @Deprecated:
It is a marker annotation. It indicates that a declaration is obsolete and has been replaced by a newer form
@deprecated tag has higher priority than @Deprecated annotation when both are together used.

2. @Override
It is a marker annotation that can be used only on methods. 
A method annotated with @Override must override a method from a superclass. 
If it doesn’t, a compile-time error will result (see this for example). 
It is used to ensure that a superclass method is actually overridden, and not simply overloaded.

3. @SuppressWarnings 
It is used to inform the compiler to suppress specified compiler warnings. 
The warnings to suppress are specified by name, in string form. 
This type of annotation can be applied to any type of declaration.

Java groups warnings under two categories. 
They are deprecated and unchecked. 
Any unchecked warning is generated when a legacy code interfaces with a code that uses generics.

*/

@Deprecated(since = "1.0", forRemoval = true)
class A {
    public void show() {
        System.out.println("in show A");
    }
}
@SuppressWarnings("deprecation")
class B extends A {
    @Override
    public void show() {
        System.out.println("in B show");
    }
}

class Main {
    public static void main(String[] args) {
        B obj = new B();
        obj.show(); 
    }
}
