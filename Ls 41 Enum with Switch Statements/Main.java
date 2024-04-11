enum Status{
    Running, Failed, Pending, Success;
}


class Main{
    public static void main(String[] args){
        Status s = Status.Pending;

        // With Switch Statements:
        switch(s){
            case Running:
                System.out.println("Running State... ");
                break;
            case Failed:
                System.out.println("Error: Something went wrong!");
                break;
            case Pending:
                System.out.println("Please Wait.. ");
                break;
            case Success:
                System.out.println("Success! All Done.");
                break;
            default:
                System.out.println("Invalid State");
        }   

        // Using if Statements

        if(s==Status.Success) System.out.println("Running State... ");
        else if(s==Status.Failed) System.out.println("Error: Something went wrong!");
        else if(s==Status.Pending) System.out.println("Please Wait.. ");
        else if(s==Status.Success) System.out.println("Success! All Done.");
        else System.out.println("Invalid State");
    }
}