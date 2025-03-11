import java.util.Scanner;


public class Rational {
    private int numerator;
    private int denominator;
    private double rational;

    Rational(int num, int denom) {
        
        if (denom != 0){
            this.numerator = num;
            this.denominator = denom;
            rational = (double) this.numerator / this.denominator;
        } 
        else {
            throw new RuntimeException("Cannot have zero denominator");
        }
    
    }

    public Rational add(Rational newRational){
        int new_denom = newRational.getDenominator();
        int new_num = newRational.getNumerator();
        int added_denom = new_denom * this.denominator;
        int added_num = (this.numerator * new_denom) + (new_num * this.denominator);
        Rational second_rational = new Rational(added_num,added_denom);
        Rational return_rational = second_rational.simplify();
        return return_rational;
    }

    public int getNumerator(){
        return this.numerator;
    }

    public int getDenominator(){
        return this.denominator;
    }

    public Rational sub(Rational newRational){
        int new_denom = newRational.getDenominator();
        int new_num = newRational.getNumerator();
        int added_denom = new_denom * this.denominator;
        int added_num = (this.numerator * new_denom) - (new_num * this.denominator);
        Rational second_rational = new Rational(added_num,added_denom);
        Rational return_rational = second_rational.simplify();
        return return_rational;
    }

    public Rational mul(Rational newRational){
        int new_denom = newRational.getDenominator();
        int new_num = newRational.getNumerator();
        Rational second_rational = new Rational(this.numerator * new_num,this.denominator * new_denom);
        Rational return_rational = second_rational.simplify();
        return return_rational;
    }

    public Rational div(Rational newRational){
        int new_denom = newRational.getDenominator();
        int new_num = newRational.getNumerator();
        Rational second_rational = new Rational(this.numerator * new_denom,this.denominator * new_num);
        Rational return_rational = second_rational.simplify();
        return return_rational;
    }

    public boolean equals(Rational newRational){
        boolean equals_state = false; 
        int new_denom = newRational.getDenominator();
        int new_num = newRational.getNumerator();
        double total_val1 = (double) this.numerator / this.denominator;
        double total_val2 = (double) new_num / new_denom;

        if (total_val1 == total_val2){
            equals_state = true;
        }
        else {
            equals_state = false;
        }

        return equals_state;

    }
    
    public boolean isLessThan(Rational newRational){
        boolean less_than_state = false; 
        int new_denom = newRational.getDenominator();
        int new_num = newRational.getNumerator();
        double total_val1 = this.rational;
        double total_val2 = new_num / new_denom;

        if (total_val1 < total_val2){
            less_than_state = true;
        }

        return less_than_state;
    }

    public Rational simplify(){

        //base cases 
        //1) if the fraction is zero, it should simplify to 0/1 as the new object 
        int a = Math.max(Math.abs(this.numerator),Math.abs(this.denominator));
        int b = Math.min(Math.abs(this.numerator),Math.abs(this.denominator));
        int mod;

        while (b > 0){
            mod = a % b;
            a = b;
            b = mod;
        }

        int gcd = a;

        int new_num = this.numerator / gcd;
        int new_denom = this.denominator / gcd;

        //if (rational >= 0){
            //new_num = Math.abs(new_num);
            //new_denom = Math.abs(new_denom);
        //}
        //else {
            //new_num = Math.abs(new_num) * -1;
            //new_denom = Math.abs(new_denom);
        //}
        if (new_denom < 0) {
            new_num = -new_num;
            new_denom = -new_denom;
        }
        
        if (new_num < 0 && new_denom < 0) {
            new_num = Math.abs(new_num);
            new_denom = Math.abs(new_denom);
        }

        Rational second_rational = new Rational(new_num,new_denom);
        return second_rational;



    }
    
    public String toString(){
        String rational_string = null;
        if (this.denominator != 1){
            rational_string = String.format("%s/%s",this.numerator,this.denominator);
        }
        else {
            rational_string = String.format("%s",this.numerator);
        }
        return rational_string;
    }

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        String prompt = "Please enter two rational numbers separated by a space e.g. \"5/7 9/6\"";
        System.out.println(prompt);
        String rationals = scanner.nextLine();
        System.out.println();
        System.out.println(rationals);
        System.out.println();

        String[] split_rationals = rationals.split(" ");
        String rational1 = split_rationals[0];
        String rational2 = split_rationals[1];
        String[] num_denom1 = rational1.split("/");
        String[] num_denom2 = rational2.split("/");
        int rational1_num = Integer.parseInt(num_denom1[0]);
        int rational1_denom = Integer.parseInt(num_denom1[1]);
        int rational2_num = Integer.parseInt(num_denom2[0]);
        int rational2_denom = Integer.parseInt(num_denom2[1]);

        Rational object1 = new Rational(rational1_num,rational1_denom);
        Rational object2 = new Rational(rational2_num,rational2_denom);

        String object1_string = object1.toString();
        String object2_string = object2.toString();

        Rational add_obj = object1.add(object2);
        String added_string = add_obj.toString();
        System.out.println(String.format("%s + %s = %s",object1_string,object2_string,added_string));

        Rational sub_obj = object1.sub(object2);
        String sub_string = sub_obj.toString();
        System.out.println(String.format("%s - %s = %s",object1_string,object2_string,sub_string));

        Rational mul_obj = object1.mul(object2);
        String mul_string = mul_obj.toString();
        System.out.println(String.format("%s * %s = %s",object1_string,object2_string,mul_string));

        Rational div_obj = object1.div(object2);
        String div_string = div_obj.toString();
        System.out.println(String.format("%s / %s = %s",object1_string,object2_string,div_string));

        boolean equality = object1.equals(object2);
        System.out.println(String.format("( %s == %s ) = %s",object1_string,object2_string,equality));

        boolean greater = object1.isLessThan(object2);
        System.out.println(String.format("( %s < %s ) = %s",object1_string,object2_string,greater));

        Rational simplified1 = object1.simplify();
        String simplified1_string = simplified1.toString();
        System.out.println(String.format("%s simplified is %s",object1_string,simplified1_string));

        Rational simplified2 = object2.simplify();
        String simplified2_string = simplified2.toString();
        System.out.println(String.format("%s simplified is %s",object2_string,simplified2_string));


        scanner.close();


    }





}
