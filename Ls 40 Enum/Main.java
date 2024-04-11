enum Status{
    Running, Failed, Pending, Success;  
}

class Main{
    public static void main(String[] args) {
        Status e = Status.Running;
        System.out.println(e+" : "+e.ordinal());     
        
        Status[] arr = Status.values();

        System.out.println(arr[3]);

        for(Status i: arr){
            System.out.println(i+" : "+i.ordinal());
        }
    }
}