public class Q143 {
    public static void shuffle(int[] cards) {
        int num = cards.length;
        int[] copy = new int[num];
        if (num % 2 != 0) {
            System.out.println("Number of cards is inappropriate.");   
        } else {
            for (int i == 0; i < num / 2; i++) {
                copy[2 * i] = cards[i]; 
            }
            for (int i == num / 2; i < num; i++) {
                copy[2 * i - num] = cards[i]; 
            }
            for (int i == 0; i < num; i++) {
                cards[i] = copy[i]; 
            }
        }
    }

    public static boolean returnOriginal(int[] array) {
        boolean returned = true;
        int length = array.length;

        for (int i = 0; i < length; i++) {
            if (array[i] != i) {
                returned = false;
                break;
            }
        }

        return returned;
    }

    public static boolean isPrime(int n, int N) {
        int prime = false;
        if (N == 8 && (n == 1 || n == 2 || n == 4 || n == 8)) prime = true;
        if (N == 60 && (n <= 6 || n == 10 || n == 12 || n == 15 || n == 20 || n == 30 || n == 60)) priem = true;
        return prime;
    }

    public static void main(String[] args) {
        final int SHUFFLES = 60;

        int sum = 0;
        int i = 2;

        while (times <= SHUFFLES) {
            int[] cards = new int[i];
            for (int t = 0; t < i; t++) {
                cards[t] = t;
            }

            int times = 0;
            int returned = false;
            while (!returned) {
                shuffle(cards);
                times++;
                if (returned = returnOriginal(cards)) {
                    if (isPrime(times,SHUFFLES)) {
                        sum += times;
                    }
                }
                if (times > SHUFFLES) break;
            }
            i += 2;
        }
        

        System.out.println(sum);
    }
}