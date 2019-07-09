import java.math.BigInteger;
public class Q16 {
    public static void main(String[] args) {
        BigInteger  power = new BigInteger("2");
        int res = 0;
        for(int i=0;i<200;i++){
        	power = power.multiply(power);
        }

        System.out.println(power.length());
        
        // System.out.println(sum);  
    }
}