public class Q21 {
    public static int sumOfDivisors(int num) {
        int sum = 0;
        for (int i = 1; i < num; i++) {
            if (num % i == 0)
                sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        final int LIMIT = 10000;
        int[] sumOfDivisors = new int[LIMIT + 1];
        int sum = 0;

        for (int a = 1; a < LIMIT; a++) {
            int da = sumOfDivisors(a);
            int db = sumOfDivisors(da);
            if (da <= LIMIT && sumOfDivisors[da] == 0) {
                if (a == db && a != da) {
                    sumOfDivisors[a] = da;
                    sumOfDivisors[da] = db;
                    sum += (da + db);

                } else {
                    sumOfDivisors[a] = -1;
                    sumOfDivisors[da] = -1;
                }
            }
        }

        System.out.println(sum);
    }
}