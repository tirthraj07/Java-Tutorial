import tools.AdvCalc;

/*
Note that, if you want to import all the files inside the package, you can simply use '*' 
For example: import tools.*;
Note: This will only add all the FILES not the folders, i.e it won't add packages contained within the tools
for that, we need to import all from the nested package
For example: import package.nestedPackage.*;
*/

/*
Java compiler imports java.lang package internally by default. 
It provides the fundamental classes that are necessary to design a basic Java program.
The System class in Java is present in java.lang.System used in System.out.println();
*/

class Main{
    public static void main(String[] args) {
        AdvCalc calc = new AdvCalc();
        System.out.println(calc.add(10,20));
        System.out.println(calc.mul(20,30));
    }
}