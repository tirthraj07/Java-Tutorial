class Human{
    private String name;
    private int age;

    public void Human(){
        System.out.println("Human is Created");
    }

    public int getAge(){
        return age;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setAge(int age){
        this.age = age;
    }


}


public class Main {
    public static void main(String[] args) {
        Human h = new Human();
        h.setAge(19);
        h.setName("Tirthraj");
        System.out.println(h.getName()+" : "+h.getAge());
    }
}
