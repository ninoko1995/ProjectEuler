public class Q3 {
  public static void main(String[] args) {
    final long NUM = 600851475143L;
    long num = NUM;
    
    int i = 2;
    int max_prime_factor = 1;

    while(num!=1&&i<NUM){
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