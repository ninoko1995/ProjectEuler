public class Q10 {
    public static int getHalf(int num) {
        int half;
        if (num % 2 == 0) {
            half = num / 2;
        } else {
            half = (num - 1) / 2;
        }
        return half;
    }

    public static boolean checkPrime(int num) {
        boolean result = true;
        for (int i = 3; i < getHalf(num); i += 2) {
            if (num % i == 0) {
                result = false;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        final int LIMIT = 2000000;
        long sum = 0L;

        // for(int i=3;i<LIMIT;i+=2){
        // if(checkPrime(i)){
        // sum+=i;
        // }
        // }

        // set list to search
        boolean[] searchList = new boolean[LIMIT + 1];
        for (int i = 0; i < LIMIT + 1; i++) {
            searchList[i] = true;
        }
        searchList[0] = false;
        searchList[1] = false;

        // sift the list
        for (int i = 2; i < (int) (Math.sqrt(LIMIT)); i++) {
            if (searchList[i]) {
                for (int t = 2; t < (int) (LIMIT / i) + 1; t++) {
                    searchList[t * i] = false;
                }
            }
        }

        // sum up the primes
        for (int i = 0; i <= LIMIT; i++) {
            if (searchList[i])
                sum += i;
        }

        System.out.println(sum);
    }

}