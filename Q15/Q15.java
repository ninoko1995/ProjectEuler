import java.math.BigInteger;

public class Q15 {

    public static void combination(int n, int m) {
        BigInteger C = new BigInteger("1");

        for (int i = n - m + 1; i <= n; i ++){
            C = C.multiply(BigInteger.valueOf(i));  
        }
        for (int i = 2; i <= m; i ++){
            C = C.divide(BigInteger.valueOf(i));
        }
        System.out.println(C);
    }

    public static void main(String[] args) {
        final int LATTICE = 20;
        combination(2 * LATTICE, LATTICE);
    }
}