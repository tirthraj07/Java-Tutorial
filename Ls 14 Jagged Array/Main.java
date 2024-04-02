public class Main{
    public static void main(String[] args) {
        int jaggedArray[][] = new int[][]{
            {1,2,3,4,5},
            {1,2,3,4},
            {1,2,3},
            {1,2},
            {1}
        };

        for(int i=0; i<jaggedArray.length; i++){
            for(int j=0; j<jaggedArray[i].length; j++){
                System.out.print(jaggedArray[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println("-----------");

        for(int a[]: jaggedArray){
            for(int b: a){
                System.out.print(b+" ");
            }
            System.out.println();
        }

    }
}