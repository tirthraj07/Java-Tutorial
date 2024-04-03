class Mobile{
    String company, name;
    int price;
    static String type;

    public void show(){
        System.out.println("Company: "+company+" Name: "+name+" Price: "+price+" Type : "+type);
    }
}


public class Main {
    public static void main(String[] args) {
        Mobile.type = "Smart Phones";
        
        Mobile m1 = new Mobile();
        m1.company = "Apple";
        m1.name = "Iphone 15";
        m1.price = 1500;

        Mobile m2 = new Mobile();
        m2.company = "Samsung";
        m2.name = "S21";
        m2.price = 1700;

        m1.show();
        m2.show();

        Mobile.type = "Phones";

        m1.show();
        m2.show();

    }    
}
