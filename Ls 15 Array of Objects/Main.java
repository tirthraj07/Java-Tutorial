class Student{
    int roll_no;
    String name;
    int marks;

    public void display(){
        System.out.println(name + " : " + roll_no +" : " + marks);
    }
}

public class Main{
    public static void main(String[] args) {
        Student arr[] = new Student[5];

        for(int i=0; i<arr.length; i++){
            arr[i] = new Student();
            arr[i].name = "Student " + (i+1);
            arr[i].roll_no = (i+1);
            arr[i].marks = (int)(Math.random()*100);
        }

        for(Student s: arr){
            s.display();
        }

    }
}