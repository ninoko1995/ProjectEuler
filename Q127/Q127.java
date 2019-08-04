import java.util.Arrays;

public class Q127 {
    // ユークリッドの互除法による最大公約数の導出
    public static int gcd(int x, int y) {
        if (x < 0 || y < 0)
            throw new IllegalArgumentException("Negative number");
        while (y != 0) {
            int z = x % y;
            x = y;
            y = z;
        }
        return x;
    }

    public static long fasterAlgorithm(int LIMIT) {
        // Modification of the sieve of Eratosthenes
        int[] rads = new int[LIMIT];
        Arrays.fill(rads, 1, rads.length, 1);
        for (int i = 2; i < rads.length; i++) {
            if (rads[i] == 1) {
                for (int j = i; j < rads.length; j += i)
                    rads[j] *= i;
            }
        }

        long sum = 0;
        for (int c = 2; c < LIMIT; c++) {
            if (rads[c] == c)
                continue;
            for (int a = 1, end = (c - 1) / 2; a <= end; a++) {
                int b = c - a;
                assert a < b;
                if ((long) rads[a] * rads[b] * rads[c] < c && gcd(a, b) == 1) {
                    sum += c;
                    // System.out.println(b + " " + c);
                }
            }
        }
        System.out.println(sum);
        return sum;
    }

    // 互いに素かつ素因数の積がcの値を超えない、という場合のみtrueを返す
    public static boolean checkAbcHit(int a, int b, int c) {
        int productOfPrimes = 1;
        int limit = c;
        boolean abcHit = true;
        int primeNum = 0;

        for (int i = 2; i <= limit; i++) {
            // System.out.println("i="+i);
            // System.out.println("primeNum="+primeNum);

            primeNum = 0;
            // System.out.println("primeNum="+primeNum);
            if (a % i == 0)
                primeNum++;
            if (b % i == 0)
                primeNum++;
            if (c % i == 0)
                primeNum++;
            // System.out.println("primeNum="+primeNum);

            // iがどの約数でもない場合はいらない
            if (primeNum == 0)
                continue;

            // 二つ以上の数の共通因数になっている場合は、互いに素ではない
            if (primeNum >= 2) {
                abcHit = false;
                break;
            }

            // abcの約数の積がcを超えた場合、捨てる
            if (primeNum == 1) {
                productOfPrimes *= i;
                // System.out.println("productOfPrimes="+productOfPrimes);
                if (productOfPrimes >= limit) {
                    abcHit = false;
                    break;
                }
            }

            while (a % i == 0)
                a /= i;
            while (b % i == 0)
                b /= i;
            while (c % i == 0)
                c /= i;
            if (a == 1 && b == 1 && c == 1)
                break;
            // System.out.println(a+" "+b+" "+c);
        }

        if (a != 1 || b != 1 || c != 1)
            abcHit = false;

        return abcHit;
    }

    public static long allReaserchAlgorithm(int LIMIT) {
        long sigma = 0;
        for (int c = 3; c < LIMIT; c++) {

            if (c % 10000 == 0)
                System.out.println(c);

            for (int b = (int) (c / 2) + 1; b < c; b++) {
                if (checkAbcHit(c - b, b, c)) {
                    sigma += c;
                    // System.out.println(b + " " + c);
                }
            }
        }
        System.out.println(sigma);
        return sigma;
    }

    public static void main(String[] args) {
        final int LIMIT = 120000;

        // 開始時間をミリ秒で取得
        long ts1 = System.currentTimeMillis();
        // 処理実行
        long ans1 = fasterAlgorithm(LIMIT);
        // 終了時間をミリ秒で取得
        long te1 = System.currentTimeMillis();
        // 処理時間 ミリ秒
        long tmsec1 = te1 - ts1;
        // 処理時間 秒
        double tsec1 = (double) tmsec1 / 1000.0;
        System.out.println("処理時間 : " + tmsec1 + "ミリ秒   " + tsec1 + "秒");

        // 開始時間をミリ秒で取得
        long ts2 = System.currentTimeMillis();
        // 処理実行
        long ans2 = allReaserchAlgorithm(LIMIT);
        // 終了時間をミリ秒で取得
        long te2 = System.currentTimeMillis();
        // 処理時間 ミリ秒
        long tmsec2 = te2 - ts2;
        // 処理時間 秒
        double tsec2 = (double) tmsec2 / 1000.0;
        System.out.println("処理時間 : " + tmsec2 + "ミリ秒   " + tsec2 + "秒");

        if (ans1 != ans2)
            System.out.println("wrong method");
    }
}