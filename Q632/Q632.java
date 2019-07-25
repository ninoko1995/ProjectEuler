import java.math.*;

public class Q632 {
    // 引数以下の素数の配列を返す
    public static int[] getPrimesList(int limit) {
        boolean[] searchList = new boolean[limit + 1];
        for (int i = 0;i <= limit;i ++) {
            searchList[i] = true;
        }
        searchList[0] = false;
        searchList[1] = false;
        int notPrimeNum = 1;


        // sift the list
        for (int i = 2; i <= Math.floor(Math.sqrt(limit)); i++) {
            if (searchList[i]) {
                for (int t = 2; t <= Math.floor(limit / i); t++) {
                    if (searchList[t * i]) {
                        searchList[t * i] = false;
                        notPrimeNum ++;
                    }
                }
            }
        }

        // get primes list
        int[] primes = new int[limit - notPrimeNum];
        int primeNum = 0;
        for (int i = 2;i <= limit;i ++) {
            if (searchList[i]) {
                primes[primeNum] = i;
                primeNum ++;
            }
        }
        if (notPrimeNum + primeNum != limit)
            System.out.println("something went wrong....");

        System.out.println("num of prime numbers is "+primes.length);
        System.out.println("max prime numbers is "+primes[primeNum-1]);
        return primes;
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

    // 渡された値を超える最小の値を格納する配列のindexを返す
    public static int getIndexOfFirstOverNum(double n, int[] list) {
        int index = 0;
        int length = list.length;
        for (int i = 0;i < length;i ++) {
            if ((double)list[i] >= n) {
                index = i;
                break;
            }
        }
        System.out.println("index = "+index);
        return index;
    }

    //  素数の数がintの範囲を超え始めたら、どうしようかなぁって考えないといけない。
    public static void main(String[] args) {
        // intの型の限界を超えた場合を考える。
        // 超えた場合は、二次元配列として、探索する。
        // final long N = 1000000L;
        final long N = 10000000000000000L;
        // final long MOD = 1000000007L;

        // 平方素因数の数を格納。関数で返された値に、平方素因数が0個の場合も加えて、各場合を記録可能としている。
        long[] numbersList = new long[getSquarePrimeNum(N) + 1];
        //  素数リスト
        int[] primeList = getPrimesList(Math.max((int)(N / 4),(int)(Math.sqrt(N))));
        int length = primeList.length;
        // 各素数の累乗の指数
        int[] exponentList = new int[length];
        // 繰り上がり桁
        int operationNum = 0;
        // 最大の平方素因数
        int indexOfMaxSquarePrime = getIndexOfFirstOverNum(Math.sqrt(N),primeList);
        if (N == 10) indexOfMaxSquarePrime = 4;
        // System.out.println("indexOfMaxSquarePrime = "+indexOfMaxSquarePrime);

        // カウント部分
        while (operationNum < length) {
            exponentList[operationNum] ++;

            long value = 1L;
            int squarePrimeNum = 0;
            // 計算省略のための判定装置。
            boolean over = false;
            
            // 数値を取得
            for (int i = length - 1;i >= 0;i --) {
                if (i >= indexOfMaxSquarePrime && exponentList[i] >= 2) {
                    over = true;
                    break;
                }
                if (exponentList[i] >= 2) squarePrimeNum ++;
            // }
            // 平方素因数が存在しない場合、この回をスキップ
            // if (squarePrimeNum == 0) continue;
            // 生成される数値を取得
            // for (int i = 0;i < length;i ++) {
                if (exponentList[i] == 0) continue;
                value *= (long)Math.pow(primeList[i],exponentList[i]);
                if (value > N || value < 0) {
                    over = true;
                    break;
                }
            }

            // 数値が限界を超えている場合、繰り上がりを実行。超えていない場合、平方素数をカウント
            if (over) {
                exponentList[operationNum] = 0;
                operationNum ++;
            } else {
                numbersList[squarePrimeNum] ++;
                operationNum = 0;
            }

            
            // System.out.println(value);
        }

        // 表示部分
        numbersList[0] = N;
        for (int i = numbersList.length - 1;i >= 0; i --) {
            if(i != 0) numbersList[0] -= numbersList[i];
            System.out.println(numbersList[i]);
        }
    }
}



