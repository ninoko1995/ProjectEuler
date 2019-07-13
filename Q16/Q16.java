import java.math.BigInteger;

public class Q16 {
	public static void main(String[] args) {
		final int NUM = 1000;
		BigInteger power = new BigInteger("1");
		int sum = 0;

		for (int i = 0; i < NUM; i++) {
			power = power.multiply(BigInteger.valueOf(2));
		}

		String digit = power.toString();
		int length = digit.length();
		for (int i = 0; i < length; i++) {
			sum += Integer.parseInt(digit.substring(i, i + 1));
		}
		
		System.out.println(sum);
	}
}