class Complex{
    private int real;
    private int img;

    public Complex(int real, int img){
        this.real = real;
        this.img = img;
    }

    public String toString(){
        if(real==0&&img==0) return "0";
        if(real==0) return (img+"i");
        if(img > 0){
            return(real + " + " + img + "i" );
        }
        else if(img < 0){
            return(real + " - " + (Math.abs(img)) + "i" );
        }
        else{
            return String.valueOf(real);
        }
    }

    public boolean equals(Complex c){
        return this.real==c.real&&this.img==c.img;
    }

}

class Main{
    public static void main(String[] args) {
        Complex c1 = new Complex(30,-10);
        System.out.println(c1);
        
        // System.out.println() -> automatically calls the toString() method which is defined in the object class when we print and object
        // To have a custom output, we must override it in our class
        
        Complex c2 = new Complex(30,-10);
        System.out.println(c2);

        System.out.println(c1==c2);
        System.out.println(c1.equals(c2));

    }
}