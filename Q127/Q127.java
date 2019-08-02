public class Q127 {
    // 互いに素かつ素因数の積がcの値を超えない、という場合のみtrueを返す
    public static boolean checkAbcHit(int a, int b, int c) {
        int productOfPrimes = 1;
        int limit = c / 2;

        boolean abcHit = true;
        int primeNum;

        for (int i = 2; i <= limit; i++) {
            primeNum = 0;
            if (a % i == 0) primeNum++;
            if (b % i == 0) primeNum++;
            if (c % i == 0) primeNum++;

            // iがどの約数でもない場合はいらない
            if (primeNum == 0) continue;

            // 二つ以上の数の共通因数になっている場合は、互いに素ではない
            if (primeNum >= 2) {
                abcHit = false;
                break;
            }

            // abcの約数の積がcを超えた場合、捨てる
            if (primeNum == 1) {
                productOfPrimes *= i;
                if (productOfPrimes >= c) {
                    abcHit = false;
                    break;
                }
            }

            while (a % i == 0) a /= i;
            while (b % i == 0) b /= i;
            while (c % i == 0) c /= i;
            if (a == 1 && b == 1 && c == 1) break;
        }

        if (a != 1 || b != 1 || c != 1) abcHit = false;

        return abcHit;
    }


    public static void main(String[] args) {
        final int LIMIT = 1000;
        int sigma = 0;

        for (int c = 3; c < LIMIT; c++) {

            if (c % 10000 == 0) System.out.println(c);
            
            int interval = 1;
            if (c % 2 == 0) interval = 2;
            for (int b = (int)(c / 2) + 1; b < c ; b += interval) {
                if (checkAbcHit(c - b, b, c)) {
                    sigma += c;
                    System.out.println(b + " " + c);
                }
            }
        }	    	
        
        
        System.out.println(sigma);
    }
}