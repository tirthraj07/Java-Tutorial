/*
Please note that Java does not support multiple inheritances with classes. 
In Java, we can achieve multiple inheritances only through Interfaces.
We will study interfaces later
*/

// Multi-level inheritance A -> B -> C

class GrandFather{
    public void veryOldFunction(){
        System.out.println("Very Old Function -> From the 1950's");
    }
}

class Father extends GrandFather{
    public void oldFunction(){
        System.out.println("Old Function -> From the 1970's");
    }
}

class Son extends Father{
    public void newFunction(){
        System.out.println("New Function -> From the early 2000's");
    }
}

// Hierarchical Inheritance : A -> B,C

class Shape{
    public void draw(){
        System.out.println("Drawing shape..");
    }
}

class Rectangle extends Shape{
    public void coordinates(int a, int b, int c, int d){
        System.out.printf("Coordinates of Rectangle : %d %d %d %d%n", a,b,c,d);
    }
}

class Triangle extends Shape{
    public void coordinates(int a, int b, int c){
        System.out.printf("Coordinates of Triangle : %d %d %d%n", a,b,c);
    }
}


class Main{
    public static void main(String[] args) {
        // Multi-level inheritance : A -> B -> C
        Son s = new Son();
        s.newFunction();        // His own attribute
        s.oldFunction();        // Inherited from Father
        s.veryOldFunction();    // Inherited from Grand Father
    
        // Hierarchical Inheritance
        Rectangle r = new Rectangle();
        r.draw();
        r.coordinates(0, 1, 2, 3);
        
        Triangle t = new Triangle();
        t.draw();
        t.coordinates(4, 5, 6);
    
    }
}