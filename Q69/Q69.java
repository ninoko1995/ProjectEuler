public class Q69 {
    public static double getTotient(int n) {
        double totient = 1.0;
        int temp = n;
        for (int i = 2;i <= n;i ++) {
            boolean factor = false;
            if (temp == 1)
                break; 

            while (temp % i == 0) {
                temp /= i;
                factor = true;
            }

            if (factor) {
                totient *= i;
                totient /= (i - 1);   
            }
        }

        return totient;
    }


  public static void main(String[] args) {
    final int LIMIT = 1000000;
    double max = 0;
    int maxIndex = 0;

    for(int i = 0; i < LIMIT;i ++){
        double totient = getTotient(i);
        if(max < totient) {
            max = totient;
            maxIndex = i;
        }
        if(i % 10000 == 0) System.out.println(i);
        
    }

    System.out.println(maxIndex);
  }
}