import java.math.*;

public class Q632 {
    
    public static int numOfSquareDivisors(long n) {
        int count = 0;
        long temp = n;
        
        for (long i = 2;i < n;i ++) {
            int times = 0;
            
            if (temp == 1)
                break; 

            while (temp % i == 0) {
                temp /= i;
                times ++;
            }

            if (times >= 2) {
                count ++;
            }
        }
        return count;
    }    

    // 何個までの平方素因数が存在しうるかを返す
    public static int getSquarePrimeNum(long n) {
        int i = 0;
        int num = 0;
        while (BigInteger.valueOf(2).pow(i).compareTo(BigInteger.valueOf(n)) < 0) {
            i ++;
        }

        if (i % 2 == 0) {
            num = i / 2;
        } else {
            num = (i - 1) / 2;
        }
        System.out.println("num of square prime numbers = "+num);
        return num;
    }

    public static void main(String[] args) {
        final long N = 1000000L;
        // final long N = 10000000000000000L;
        final long MOD = 1000000007;
        long product = 0;
        int length = getSquarePrimeNum(N);
        int[] counter = new int[length];

        for (long i = 1;i <= N;i += 2) {
            counter[numOfSquareDivisors(i)] ++;
            if(i % 10000 == 0) System.out.println(i);
        }

        for (int i = 0;i < length;i ++) {
            System.out.print(counter[i]+"   ");
        }
        System.out.println();
    }
}



