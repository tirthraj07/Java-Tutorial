//https://www.geeksforgeeks.org/typecasting-in-java/

public class Main{
    public static void main(String[] args) {
        //Implicit Conversion can take place if a lower data type is converted into a higher type
        // For eg: byte --> int
        byte Byte = 127;
        int Integer = Byte;
        System.out.println(Integer); // This will work

        /*
        Integer = 256;
        Byte = Integer; 
        // This will not work
        // error: incompatible types: possible lossy conversion from int to byte
        */

        // But what is the integer is in the range of byte and we want to convert it

        // We can do an explicit conversion -> Casting
        // Syntax : <datatype> variableName = (<datatype>) value;
        Integer = 12;
        Byte = (byte)Integer;
        System.out.println(Byte);
        // This will work

        // Now if you try to convert the Integer into byte but it contains value greater than range, it will do modulus
        Integer = 257;
        Byte = (byte)Integer;
        System.out.println(Byte);

    }
}