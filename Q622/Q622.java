import java.util.Random;

public class Q622 {
    public static void shuffle(int[] cards) {
        int num = cards.length;
        int[] copy = new int[num];        
        for (int i = 0; i < num / 2; i++) {
            copy[2 * i] = cards[i]; 
        }
        for (int i = num / 2; i < num; i++) {
            copy[2 * i - num + 1] = cards[i]; 
        }
        for (int i = 0; i < num; i++) {
            cards[i] = copy[i]; 
        }
        
    }

    public static boolean returnOrigin(int[] array) {
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

    public static long allShuffleMethod(int SHUFFLES, int LIMIT) {
        // final int INTERVAL = 10000;
        final int INTERVAL = LIMIT;

        long sum = 0;
        int i = 2;
        int noReturnNum = 0;
        int times = 0;


        // while (times <= SHUFFLES) {
        // while (noReturnNum <= INTERVAL) {
        while (i <= LIMIT) {
            // カードをセット
            int[] cards = new int[i];
            for (int t = 0; t < i; t++) {
                cards[t] = t;
            }

            times = 0;
            boolean returned = false;
            
            // 元に戻るまでシャッフルする
            while (!returned) {
                shuffle(cards);
                times++;
                
                // もし元の配列に戻っていたら、そこで終了
                if (returned = returnOrigin(cards)) {
                    // ちょうど60shuffle目だった場合のみ、記録
                    if (times == SHUFFLES) {
                        sum += i;
                        System.out.println("i = "+i+" :times = "+times);
                        noReturnNum = 0;
                    }
                    break;
                }

                // 60シャッフルを超えたら、破棄。
                if (times > SHUFFLES) {
                    times = 0;
                    noReturnNum ++;
                    break;
                }
            }
            i += 2;
        }
        System.out.println(sum);
        return sum;
    }

    public static long checkLeastCommonMultipleMethod(int SHUFFLES, int LIMIT) {
        long sum = 0;
        int i = 2;
        int[] primeFactors = {2,2,3,5};

        loop:while(i < LIMIT) {
            i += 2;
            
            boolean[] primeExistance = new boolean[primeFactors.length];

            // int[] next = new int[i];
            // int[] shuffleNum = new int[i];

            // // set next card num;
            // for (int t = 0; t < i / 2; t++) {
            //     next[t] = 2 * t; 
            // }
            // for (int t = i / 2; t < i; t++) {
            //     next[t] = 2 * t - i + 1;
            // }


            // // get the number of shuffle for each card.
            // for (int t = 0; t < i; t++) {
            //     int nextNum = t;
            //     while (shuffleNum[t] < SHUFFLES) {
            //         nextNum = next[nextNum];
            //         shuffleNum[t]++;
            //         if (nextNum == t) {
            //             // check L.C.M
            //             for (int k = 0; k < primeFactors.length; k++) {
            //                if (shuffleNum[t] % primeFactors[k] == 0) {
            //                     shuffleNum[t] /= primeFactors[k];
            //                     primeExistance[k] = true; 
            //                 }
            //             }
            //             if (shuffleNum[t] != 1) {
            //                 continue loop;
            //             }

            //             break;
            //         }
            //     }
            // }



            // get the number of shuffle for each card.
            boolean[] shuffled = new boolean[i];
            for (int t = 1; t < i - 1; t++) {
                if (!shuffled[t]) {
                    shuffled[t] = true;
                    int nextNum = t;
                    int shuffleNum = 0;
                    while (nextNum != t || shuffleNum == 0) {
                        if (nextNum < i /2) {
                            nextNum = nextNum * 2;
                        } else {
                            nextNum = 2 * nextNum - i + 1;
                        }
                        shuffled[nextNum] = true;
                        shuffleNum++;

                        if (shuffleNum > SHUFFLE) {
                            continue loop;   
                        }

                        if (nextNum == t) {
                            // check L.C.M
                            for (int k = 0; k < primeFactors.length; k++) {
                               if (shuffleNum % primeFactors[k] == 0) {
                                    shuffleNum /= primeFactors[k];
                                    primeExistance[k] = true; 
                                }
                            }
                            if (shuffleNum != 1) {
                                continue loop;
                            }
                            break;
                        }
                    }
                }
            }

            // check whether all prime factors are here or not
            for (int k = 0; k < primeExistance.length; k++) {
                if (!primeExistance[k]) {
                    continue loop;
                }
            }
            System.out.println("i = "+i);
            sum += i;                        
        }
        System.out.println(sum);
        return sum;
    }

    public static void main(String[] args) {
        final int SHUFFLES = 60;
        final int LIMIT = 100000000;

        // 開始時間をミリ秒で取得
        long ts1 = System.currentTimeMillis();
        // 処理実行
        long ans1 = checkLeastCommonMultipleMethod(SHUFFLES, LIMIT);
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
        long ans2 = allShuffleMethod(SHUFFLES, LIMIT);
        // 終了時間をミリ秒で取得
        long te2 = System.currentTimeMillis();
        // 処理時間 ミリ秒
        long tmsec2 = te2 - ts2;
        // 処理時間 秒
        double tsec2 = (double) tmsec2 / 1000.0;
        System.out.println("処理時間 : " + tmsec2 + "ミリ秒   " + tsec2 + "秒");


        if (ans1 != ans2) System.out.println("something wrong with either program");      
    }
}