public class Q17 {
    public static int countLatter(int num) {
        int latter = 0;
        int[] index = { 3, 3, 5, 4, 4, 3, 5, 5, 4, 3, 6, 6, 8, 8, 7, 7, 9, 8, 8 };
        int[] index2 = { 6, 6, 5, 5, 5, 7, 6, 6 };

        switch (Integer.toString(num).length()) {
        case 4:
            latter += 11;// one thousand
            break;
        case 3:
            latter += (index[(num - num % 100) / 100 - 1] + 7);// xx hundred ;
            num = num % 100;
            if (num == 0) {
                break;
            } else {
                latter += 3;
            }
        case 2:
            if (num < 20) {
                latter += index[num - 1];
                break;
            } else {
                latter += index2[(num - (num % 10)) / 10 - 2];
                num = num % 10;
            }
            if (num == 0)
                break;
        case 1:
            latter += index[num - 1];
            break;

        }
        return latter;
    }

    public static void main(String[] args) {
        final int LIMIT = 1000;
        int sum = 0;
        for (int i = 1; i <= LIMIT; i++) {
            sum += countLatter(i);
        }

        System.out.println(sum);
    }
}