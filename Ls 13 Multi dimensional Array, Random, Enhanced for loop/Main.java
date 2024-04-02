public class Main{
    public static void main(String[] args) {
        // Implicit Initialization of Multi Dimensional Array
        int arr[][] = {
            {1,2,3},
            {4,5,6},
            {7,8,9}
        };

        // Normal For Loop
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println("--------------");

        // Enhanced For Loop
        for(int a[]: arr){
            for(int b: a){
                System.out.print(b+" ");
            }
            System.out.println();
        }

        System.out.println("--------------");


        // Explicit Initialization

        // Math.random() -> Generates a random value between 0 and 1
        int array[][] = new int[4][3];
        for(int i=0; i<array.length; i++){
            for(int j=0; j<array[0].length; j++){
                array[i][j] = (int)(Math.random()*10);
            }
        }
        for(int i=0; i<array.length; i++){
            for(int j=0; j<array[0].length; j++){
                System.out.print(array[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("--------------");

        
    }
}