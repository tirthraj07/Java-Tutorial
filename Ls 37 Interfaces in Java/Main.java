/*
An Interface in Java programming language is defined as an abstract type used to specify the behavior of a class. 
An interface in Java is a blueprint of a behavior. 
A Java interface contains static constants and abstract methods.
The interface in Java is a mechanism to achieve abstraction.
interface :
    - declare constant fields
    - declare methods that abstract 
    - by default.   

To declare an interface, use the interface keyword. 
It is used to provide total abstraction. 
That means all the methods in an interface are declared with an empty body and are public and all fields are public, static, and final by default. 
A class that implements an interface must implement all the methods declared in the interface. 
To implement the interface, use the implements keyword.

Any class can extend only 1 class, but can any class implement an infinite number of interfaces.
It is also used to achieve loose coupling.
Interfaces are used to implement abstraction. 

Note:
class - class -> extends
class - interface -> implements
interface - interface -> extends

*/



interface PublicationInterface{
    /*
        *   All the methods in the interfaces are abstract.
        *   You cannot define them in the interface 
    */
    String getTitle();
    void setTitle(String title);
    double getPrice();
    void setPrice(float price);
    String getType();
}

interface BookInterface extends PublicationInterface{
    String type = "Book";
    /*
        *   The variables declared are final and static
        *   Thus you cannot change them once they are initialized
        *   They have to be initialized during the declaration itself
        *   If you have the same variable in the child interface as in the base interface, you will get an ambiguity error
        *   Thus we have mentioned the type variable in the Child and not the parent interface 
    */
    void setPageCount(int pages);
    int getPageCount();
}

interface TapeInterface extends PublicationInterface{
    String type = "Tape";
    void setPlayingTime(float time);
    float getPlayingTime();
}

abstract class Publication extends Object implements PublicationInterface{
    protected String title;
    protected double price;

    public abstract String toString();

    public void setTitle(String title){
        this.title = title;
    }

    public String getTitle(){
        return title;
    }

    public double getPrice(){
        return price;
    }

    public void setPrice(float price){
        this.price = price;
    }

    public abstract String getType();
}

// NOTE: extends should go before implements:

class Book extends Publication implements BookInterface{
    private int pageCount;
    public Book(){}
    public Book(String title, float price, int pageCount){
        this.title = title;
        this.price = price;
        this.pageCount = pageCount;
    }
    public void setPageCount(int pageCount){
        this.pageCount = pageCount;
    }
    public int getPageCount(){
        return pageCount;
    }
    public String toString(){
        return ("Title : "+this.title+" Price : "+this.price+" Type : "+type+ " Page Count: "+this.pageCount);
    }
    public String getType(){
        return type;
    }
}

class Tape extends Publication implements TapeInterface{
    private float playingTime;
    public Tape(){}
    public Tape(String title, float price, float playingTime){
        this.title = title;
        this.price = price;
        this.playingTime = playingTime;
    }

    public void setPlayingTime(float playingTime){
        this.playingTime = playingTime;
    }
    public float getPlayingTime(){
        return playingTime;
    }
    public String toString(){
        return ("Title : "+this.title+" Price : "+this.price+" Type : "+type+ " Playing Time: "+this.playingTime+" minutes");
    }
    public String getType(){
        return type;
    }
    
}

class Main{
    public static void main(String[] args) {
        Publication p1 = new Book();
        p1.setPrice(100);
        p1.setTitle("Spider Man Homecoming");
        Book bookRef = (Book) p1;
        bookRef.setPageCount(1000);
        System.out.println(p1);

        Publication p2 = new Tape();
        p2.setPrice(100);
        p2.setTitle("Classics of Kishore Kumar");
        Tape tapeRef = (Tape) p2;
        tapeRef.setPlayingTime(200);
        System.out.println(p2);


        // Lets try and create an Array of Books and Tapes in a single array of Publication

        Publication[] arr = new Publication[]{
            new Book("Harry Potter Half blood Prince", 20, 100),
            new Book("The diary of Wimpy Kid", 50, 150),
            new Tape("The best of Arjit Singh",10,200),
            new Tape("Classics of Mohammad Rafi", 20, 300),
            new Book("Rich dad, poor dad",100,1000),
            new Book("Atomic Habits", 70, 100)
        };

        for(Publication ref: arr){
            System.out.println(ref);
        }


    }
}