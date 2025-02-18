import java.util.Scanner;

public class Sieve{

    private int n;
    private boolean[] prime_mask;

    public Sieve(){

    }

    public void setNumber(int number){
        n = number;
    }

    public void set_sequence(int number){
        prime_mask = createSequence(number);
    }
    
    public boolean[] createSequence(int length){
        boolean[] primes = new boolean[length+1];
        primes[0] = true;
        primes[1] = true;
        return primes;
    }

    public void crossOutHigherMultiples(boolean[] sequence, int number){

        for(int i = number * 2; i < sequence.length; i += number) {
            sequence[i] = true;
        }
        prime_mask = sequence;
    }

    public String printRegularSequence(){
        String return_string = "";
        String number_string = null;
        int i;
        for(i=2;i <= n; i++){
            number_string = Integer.toString(i);
            if(return_string == ""){
                return_string = return_string + number_string;
            } else{
                return_string = return_string + ", " + number_string;
            }
        }
        return return_string;
    }

    public String sequenceToString(boolean[] sequence){
        String number_sequence = "";
        String append_val = null;
        int i;
        for(i = 2; i <= n;i++){
            if(sequence[i] == true){
                append_val = String.format("[%d]",i);
            }
            if(sequence[i] == false){
                append_val = Integer.toString(i);
            }
            if(number_sequence == ""){
                number_sequence = number_sequence + append_val;
            } else {
                number_sequence = number_sequence + ", " + append_val;
            }
        }
        return number_sequence;
    }

    public String nonCrossedOutSubseqToString(boolean[] sequence){
        String prime_sequence = "";
        String append_val = null;
        int i;
        for(i=2; i <= n;i++){
            if(sequence[i] == false){
                append_val = Integer.toString(i);
                if(prime_sequence == ""){
                    prime_sequence = prime_sequence + append_val;
                } else {
                    prime_sequence = prime_sequence + ", " + append_val;
                }
            }
        }
        return prime_sequence;
    } 

    public void findPrimes(){
        double stopping_val = Math.pow(n,.5);
        int i;
        for(i=2;i<=n && i <= stopping_val;i++){
            if(prime_mask[i] == false){
                crossOutHigherMultiples(prime_mask,i);
                System.out.println(sequenceToString(prime_mask));
            }
        }
        System.out.println(nonCrossedOutSubseqToString(prime_mask));

    }


    public static void main(String[] args){
        
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter int >= 2 : ");
        int input_val = scanner.nextInt();
        System.out.println(input_val);
        if (input_val < 2){
            System.out.println("Please enter number >= 2: ");
            scanner.close();
            return;
        }
        
        Sieve test_sieve = new Sieve();
        test_sieve.setNumber(input_val);
        test_sieve.set_sequence(input_val);
        String original_string = test_sieve.printRegularSequence();
        System.out.println(original_string);
        test_sieve.findPrimes();
        scanner.close();

    }





}