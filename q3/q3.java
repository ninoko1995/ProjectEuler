public class q3 {
  public static void main(String[] args) {
    long num = 600851475143L;
    int i = 2;
    int max_prime_factor = 1;

    while(num!=1){
        if(num%i==0){
            max_prime_factor = i;
            num /= i;
        }else{
            i++;
        }
    }
    System.out.println(max_prime_factor);
  }
}