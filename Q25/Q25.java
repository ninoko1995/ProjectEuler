import java.math.BigInteger;

public class Q25 {
    public static void main(String[] args) {
        final int LIMIT = 1000;

        BigInteger prev = new BigInteger("1");
        BigInteger now = new BigInteger("1");
        BigInteger next;

        int index = 2;

        while (now.toString().length() < LIMIT) {
            next = now.add(prev);
            prev = now;
            now = next;

            index ++;
        }

        System.out.println(index);
    }
}