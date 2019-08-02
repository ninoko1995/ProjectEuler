public class Q127 {
    // check the numbers in the array are coprimes or not 
    public static boolean checkAbcHit(int a, int b, int c) {
        int productOfPrimes = 1;
        int limit = (int)(c / 2);

        boolean abcHit = true;
        int primeNum;

        for (int i = limit; i >= 2; i--) {
            primeNum = 0;
            if (a % i == 0) {
                while (a % i == 0) a = a / i;
                primeNum++;
            }
            if (b % i == 0) {
                while (b % i == 0) b = b / i;
                primeNum++;
            }
            if (c % i == 0) {
                while (c % i == 0) c = c / i;
                primeNum++;
            }
            

            if (primeNum >= 2) {
                abcHit = false;
                break;
            }

            if (primeNum == 1) {
                productOfPrimes *= i;
                if (productOfPrimes >= c) {
                    abcHit = false;
                    break;
                }
            }
        }
        return abcHit;
    }

    // get the product of primes of integer number, n
    public static long getProductOfPrimes(long n) {
        if (n < 0)System.out.println("n < 0. Something went wrong.");

        long product = 1;
        boolean alreadyDone = false;
        int i = 2;
        while (n != 1) {
            if (n % i == 0) {
                n /= i;
                if (!alreadyDone) product *= i;
                alreadyDone = true;
            } else {
                i++;
                alreadyDone = false;
            }
        }
        return product;
    }


    public static void main(String[] args) {
        final int LIMIT = 120000;
        int sigma = 0;

        for (int c = 3; c < LIMIT; c++) {

            if (c % 10000 == 0) System.out.println(c);
            
            int interval = 1;
            if (c % 2 == 0) interval = 2;
            for (int b = (int)(c / 2) + 1; b < c ; b += interval) {
                int a = c - b;
                if (a >= b) {
                    System.out.println("a >= b. It's wrong");
                    continue;
                }
                if (checkAbcHit(a,b,c)) {
                    sigma += c;
                }
            }
        }	    	
        
        
        System.out.println(sigma);
    }
}