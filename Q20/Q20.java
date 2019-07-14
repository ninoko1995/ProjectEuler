import java.math.BigInteger;

public class Q20 {
    public static String factorial(int n) {
        BigInteger num = new BigInteger("1");
        for (int i = n; i > 1; i--) {
            num = num.multiply(BigInteger.valueOf(i));
        }
        return num.toString();
    }

    public static void main(String[] args) {
        final int NUM = 100;
        String fact = factorial(NUM);
        int digitSum = 0;
        for (int i = 0; i < fact.length(); i++) {
            digitSum += Integer.parseInt(fact.substring(i, i + 1));
        }

        System.out.println(digitSum);
    }
}