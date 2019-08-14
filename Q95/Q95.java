import java.util.LinkedList;
import java.util.Iterator;

public class Q95 {
    // 配列の最後に数字を一つ追加する
    public static int[] addNumToArray(int[] array, int n) {
        int length = array.length;
        int[] array2 = new int[length + 1];
        for (int i = 0; i < length; i++) {
            array2[i] = array[i];
        }
        array2[length] = n;
        return array2;
    }

    // 配列の最小値を取得する
    public static int getMiniNumOfArray(int n, int[] array) {
        int length = array.length;
        int mini = array[n];
        for (int i = n; i < length; i++) {
            if (mini > array[i])
                mini = array[i];
        }
        return mini;
    }

    // 約数の総和を求める
    public static int getSumOfDivisors(int n) {
        int temp = n;
        int sum = 1;

        int i = 2;
        int times = 0;
        
        while (temp != 1 || times != 0) {
            if (temp % i == 0) {
                times++;
                temp /= i;
            } else {
                if (times != 0) {
                    int fact = 0;
                    for (int t = 0; t <= times; t++) {
                        fact += (int) Math.pow(i, t);
                    }
                    sum *= fact;
                }
                i++;
                times = 0;
            }
        }
        return (sum - n);
    }


    public static int[] countChain(int n, int[] list, int[] routes) {
        int[] result = {0, 0};//{チェーンの長さ、最小値}
        int length = routes.length;
        list[n] = getSumOfDivisors(n);

        // すでに出た値に戻ったら、計算終了して記録
        for (int i = 0; i < length; i++) {
            if (routes[i] == list[n]) {
                result[0] = length - 1 - i;;
                result[1] = getMiniNumOfArray(i, routes);
                break;
            }
        }

        if (result[0] == 0 && list[n] < list.length && list[list[n]] == 0) {
            // 計算結果が最大値以下かつ次の値が未計算だった場合は、約数の総和を計算してチェーン継続
            result = countChain(list[n], list, addNumToArray(routes,list[n]));
        }
        return result;
    }

    public static int getMiniNumOfList(int n, LinkedList<Integer> routes) {
        int miniNum = routes.get(n);
        int i = 0;
        for (int value : routes) {
            if (i > n && miniNum > value)
                miniNum = value;
            i++;
        }
        return miniNum;
    }


    public static int[] countChain1(int n, int[] list, LinkedList<Integer> routes) {
        int[] result = {0, 0};//{チェーンの長さ、最小値}
        list[n] = getSumOfDivisors(n);

        // すでに出た値に戻ったら、計算終了して記録
        int getIndex = routes.lastIndexOf(list[n]);
        routes.addLast(list[n]);
        if (getIndex != -1) {
            result[0] = routes.lastIndexOf(list[n]) - getIndex;
            result[1] = getMiniNumOfList(getIndex,routes);
        } else {
            // 計算結果が最大値以下かつ次の値が未計算だった場合は、約数の総和を計算してチェーン継続
            if (list[n] < list.length && list[list[n]] == 0) {
                result = countChain1(list[n], list, routes);
            }
        }
        return result;
    }


    public static int useArrayMethod(int LIMIT) {
        // 約数の総和記録用配列
        int[] sumOfDivisors = new int[LIMIT + 1];
        // 初期化
        sumOfDivisors[0] = 1;
        sumOfDivisors[1] = 1;
        sumOfDivisors[2] = 1;
        sumOfDivisors[3] = 1;


        // 最大値記録用
        int longestChain = 0;
        int miniNumOfLongestChain = LIMIT;

        // LIMIT以下のすべての数の約数の和を数え、最大チェーンを取得
        for (int i = LIMIT; i > 3; i--) {

            // 進捗観察用 
            if (i % 10000 == 0)
                System.out.println(i);
            
            
            // あるところの約数の総和を求め、その約数の総和の約数の総和が求められていない場合、求める。その場合、次の数字を連鎖的に計算して約数総和記録用配列に数字を埋めていく。。
            if (sumOfDivisors[i] == 0) {
                int[] result = countChain(i, sumOfDivisors, new int[]{i});
                if (result[0] != 0) {
                    if (longestChain < result[0]) {
                        longestChain = result[0];
                        miniNumOfLongestChain = result[1];
                        System.out.println(i+" "+longestChain+" "+miniNumOfLongestChain);
                    }
                }
            }
        }
        System.out.println(miniNumOfLongestChain);
        return miniNumOfLongestChain;
    }


    public static int useInterfaceMethod(int LIMIT) {
        // 約数の総和記録用配列
        int[] sumOfDivisors = new int[LIMIT + 1];
        // 初期化
        sumOfDivisors[0] = 1;
        sumOfDivisors[1] = 1;
        sumOfDivisors[2] = 1;
        sumOfDivisors[3] = 1;


        // 最大値記録用
        int longestChain = 0;
        int miniNumOfLongestChain = LIMIT;

        // LIMIT以下のすべての数に対し、それぞれ約数の和を数え、最大チェーンを取得
        for (int i = LIMIT; i > 3; i--) {

            // 進捗観察用 
            if (i % 10000 == 0)
                System.out.println(i);
            
            
            // あるところの約数の総和を求め、その約数の総和の約数の総和が求められていない場合、求める。その場合、次の数字を連鎖的に計算して約数総和記録用配列に数字を埋めていく。。
            if (sumOfDivisors[i] == 0) {
                LinkedList<Integer> list = new LinkedList<Integer>();
                list.addLast(i);
                int[] result = countChain1(i, sumOfDivisors, list);
                if (result[0] != 0) {
                    if (longestChain < result[0]) {
                        longestChain = result[0];
                        miniNumOfLongestChain = result[1];
                        System.out.println(i+" "+longestChain+" "+miniNumOfLongestChain);
                    }
                }
            }
        }
        System.out.println(miniNumOfLongestChain);
        return miniNumOfLongestChain;
    }

    public static void main(String[] args) {
        final int LIMIT = 1000000;

        // 開始時間をミリ秒で取得
        long ts1 = System.currentTimeMillis();
        // 処理実行
        int ans1 = useInterfaceMethod(LIMIT);
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
        int ans2 = useArrayMethod(LIMIT);
        // 終了時間をミリ秒で取得
        long te2 = System.currentTimeMillis();
        // 処理時間 ミリ秒
        long tmsec2 = te2 - ts2;
        // 処理時間 秒
        double tsec2 = (double) tmsec2 / 1000.0;
        System.out.println("処理時間 : " + tmsec2 + "ミリ秒   " + tsec2 + "秒");

        if (ans2 - ans1 != 0) {
            System.out.println("Answers are different. Somthing wrong happened.");
        } else {
            System.out.println("Answer is " + ans1);
            System.out.println("処理時間 : " + tmsec1 + "ミリ秒   " + tsec1 + "秒");
            System.out.println("処理時間 : " + tmsec2 + "ミリ秒   " + tsec2 + "秒");
        }
    }
}
