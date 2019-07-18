import java.math.*;

public class Q632 {
    
    public static int numOfSquareDivisors(BigInteger n) {
        int count = 0;
        BigInteger temp = n;
        
        for (BigInteger i = BigInteger.valueOf(2L);i.compareTo(n) < 0;i = i.add(BigInteger.valueOf(1L))) {
            int times = 0;
            
            if (temp.compareTo(BigInteger.valueOf(1)) == 0)
                break; 

            while (temp.remainder(i).compareTo(BigInteger.valueOf(0)) == 0) {
                temp = temp.divide(i);
                times ++;
            }

            if (times >= 2) {
                count ++;
            }
        }
        return count;
    }    


    public static int getLimit (BigInteger n) {
        int i = 0;
        while (BigInteger.valueOf(3).pow(i).compareTo(n) < 0) {
            i ++;
        }
        return i;
    }


    public static void main(String[] args) {
        final BigInteger N = BigInteger.valueOf(10);
        final BigInteger MOD = BigInteger.valueOf(1000000007);
        BigInteger product = BigInteger.valueOf(0);
        int[] counter = new int[getLimit(N)];

        for (BigInteger i = BigInteger.valueOf(1);i.compareTo(N) <= 0;i = i.add(BigInteger.valueOf(1))) {
            counter[numOfSquareDivisors(i)] ++;
        }

        for (int i = 0;i < getLimit(N);i ++) {
            if (counter[i] != 0) {
                counter[i] = 
            }
        }
    }
}



