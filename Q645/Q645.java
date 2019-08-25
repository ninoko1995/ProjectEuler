import java.math.BigInteger;

public class Q645 {
    public static void initializeArray(int[] array) {
        for (int element : array){
            element = 0;
        }
    }

    public static boolean checkSandwichedOrNot(int i) {
        return holidays[(i + 1) % DAYS] == 1 && holidays[(i - 1 + DAYS) % DAYS] == 1;
    }

    public static int countHolidays() {
        int num = 0;
        for(int i = 0; i < DAYS; i++) 
            if (holidays[i] != 0) 
                num++;
        return num;
    }


    public static void reverseNormalDayToHoliday() {
        int num = 0;
        for(int i = 0; i < DAYS; i++) {
            if (holidays[i] == 0 && checkSandwichedOrNot(i)) {
                holidays[i] = 2;
                num++;
                // System.out.println("reverse");
                // printDays();
            }
        }
    }


    public static void reverseHolidayToNormalDay() {
        for (int i = 0; i < DAYS; i++) {
            if (holidays[i] == 2) {
                if(!checkSandwichedOrNot(i)) {
                    holidays[i] = 0;
                    //printDays();
                }
            }
        }
    }

    public static void printDays() {
        for (int i = 0; i < DAYS; i++) {
            switch(holidays[i]) {
                case 0:
                    System.out.print("○");
                    break;
                case 1:
                    System.out.print("●");
                    break;
                case 2:
                    System.out.print("◉");
                    break;
            }
        }
        System.out.println();
    }

    public static void printFraction(BigInteger num, BigInteger deno) {
        System.out.println(num + "/" + deno);
    }

    public static void setEmperor(int emperorNum, BigInteger denominator, BigInteger[] fraction) {
        // 全走査
        int t = 0;
        while(t < DAYS) {
            if(holidays[t] != 0) {
                t++;
                continue;
            }

            // birth new emperor
            int normalDay = DAYS - countHolidays();
            denominator = denominator.multiply(BigInteger.valueOf(normalDay));
            holidays[t] = 1;
            emperorNum += 1;
            // printDays();
            reverseNormalDayToHoliday();
            
            
            // 終了時の処理(期待値の合算)
            if (countHolidays() == DAYS) {
                BigInteger numerator = BigInteger.valueOf(emperorNum);
                // printFraction(numerator,denominator);
                if (fraction[1].remainder(denominator).intValue() == 0) {
                    fraction[0] = fraction[0].add(numerator.multiply(fraction[1].divide(denominator)));
                } else {
                    if (denominator.remainder(fraction[1]).intValue() == 0) {
                        fraction[0] = fraction[0].multiply(denominator.divide(fraction[1])).add(numerator);
                        fraction[1] = denominator;
                    } else {
                        fraction[0] = fraction[0].multiply(denominator).add(numerator.multiply(fraction[1]));
                        fraction[1] = fraction[1].multiply(denominator);
                    }
                }
                // printFraction(fraction[0],fraction[1]);
                // System.out.println("--------------------------------------------------");
            
            // まだ終了していない場合は、次の皇帝が生まれる
            } else {
                setEmperor(emperorNum, denominator, fraction);
            }

            // この手順で生まれた皇帝およびそれに伴う新規祝日は、元に戻す
            denominator = denominator.divide(BigInteger.valueOf(normalDay));
            holidays[t] = 0;
            emperorNum -= 1;
            reverseHolidayToNormalDay();
            
            // 皇帝の誕生日を次に進める。
            t++;
        }
    }

    static final int DAYS = 5;    
    static int[] holidays = new int[DAYS];// 0:normal day, 1:emperor's bierhday, 2:other holiday  

    public static void main(String[] args) {
        // initialize
        initializeArray(holidays);

        BigInteger[] expectedEmperorNum = new BigInteger[2];
        expectedEmperorNum[0] = BigInteger.valueOf(0);
        expectedEmperorNum[1] = BigInteger.valueOf(1);


        // calculate
        setEmperor(0,BigInteger.valueOf(1),expectedEmperorNum);


        // print result
        printFraction(expectedEmperorNum[0],expectedEmperorNum[1]);
        System.out.println("結果：" + (expectedEmperorNum[0].divide(expectedEmperorNum[1])));
         
  }
}
