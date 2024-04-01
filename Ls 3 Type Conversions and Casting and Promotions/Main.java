//https://www.geeksforgeeks.org/typecasting-in-java/
// https://www.geeksforgeeks.org/automatic-type-promotion-in-overloading-in-java/
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

        // Now if you try to convert the Integer into byte but it contains value greater than range, it will do modulus by dividing via the range of byte (256)
        Integer = 257;
        Byte = (byte)Integer;
        System.out.println(Byte);

        // Type promotion
        // The name Type Promotion specifies that a small size datatype can be promoted to a large size datatype. i.e., an Integer data type can be promoted to long, float, double, etc.

        byte b1 = 10;
        byte b2 = 30;
        int it = b1*b2;
        // Technically b1*b2=300 is going beyond the range of byte. Thus java automatically promotes the value to higher datatype so that it can be stored
        System.out.println(it); 
        //This is important to remember is Automatic Type Promotion is only possible from small size datatype to higher size datatype but not from higher size to smaller size. i.e., integer to character is not possible.

    }
}