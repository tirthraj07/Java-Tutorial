// https://www.geeksforgeeks.org/data-types-in-java/?ref=lbp
// Primitive Data-types in Java
public class Main {
    public static void main(String args[]){
        byte by = 127;
        System.out.println(by);
        //Size: 1 byte (8 bits)

        int num = 10;
        System.out.println(num);
        //Size: 4 bytes ( 32 bits )

        boolean bool = true;
        System.out.println(bool);
        //Size: 1 bit (Virtual machine dependent)

        char ch = 'A';
        System.out.println(ch);
        //Size: 2 bytes
        //Java supports UNICODE instead of ASCII so has more support for different characters

        float f = 234.1345f;
        System.out.println(f);;
        //Size: 4 bytes (32 bits)

        double d = 234.1345766585789969;
        System.out.println(d);
        //Size: 8 bytes or 64 bits.
        //By default Java supports double
    }
}
