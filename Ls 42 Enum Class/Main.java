// import java.lang.Enum -> This is the Enum Class 

enum Laptops{
    Macbook(2000), XPS(2200), Surface, ThinkPad(1500);
    
    private int price;
    private Laptops(){
        this.price = 0;
    }
    private Laptops(int price){
        this.price = price;
    }
    public void setPrice(int price){
        this.price = price;
    }
    public int getPrice(){
        return this.price;
    }
}

class Main{
    public static void main(String[] args){
        System.out.println(Laptops.class.getSuperclass());
        for(Laptops l: Laptops.values()){
            System.out.println(l + " : " + l.getPrice());
        }
    }
}