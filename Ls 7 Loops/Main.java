public class Main {

    public static void main(String[] args) {
        // While Loop
        int i = 1;
        while(i<=3){
            System.out.println("Hi "+ i);
            int j=1;
            while(j<=3){
                System.out.println("Hello "+ j);
                j++;
            }
            i++;
        }

        System.out.println("Bye " + i);

        // Do While Loop
        
        int j = 5;

        do{
            System.out.println("Hi "+ j);
        }while(j<=4);

        // For Loop

        for(int k=1; k<=3; k++){
            System.out.println("Hey "+ k);
        }

    }
    
}