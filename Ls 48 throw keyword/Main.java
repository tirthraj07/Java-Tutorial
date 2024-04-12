class Main{
    public static void main(String[] args){

        int i = 10;
        int j = 0;
        try{
            if(j==0) {
                throw new ArithmeticException("You are trying to divide by zero");
            }
            i = i/j;
        }
        catch(ArithmeticException e){
            System.out.println(e.getMessage());
        }
        catch(Exception e){
            e.printStackTrace();
        }

        System.out.println("Thanks for using :)");

    }
}