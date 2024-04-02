public class Main{
    public static void main(String args[]){
        
        // If else block
        
        int a = 10;
        int b = 20;
        int c = 30;

        System.out.println("Greatest Number is: ");
        if( a>b && a>c ){
            System.out.println(a);
        }
        else if(b>c){
            System.out.println(b);
        }
        else{
            System.out.println(c);
        }

        // Ternary Operator

        int n = 4;

        boolean result = n%2==0?true:false;
        System.out.println(result);

    }
}