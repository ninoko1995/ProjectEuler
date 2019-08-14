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
    public static int getMiniNumOfArray(int[] array) {
        int length = array.length;
        int mini = array[0];
        for (int i = 1; i < length; i++) {
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
        list[n] = getSumOfDivisors(n);

        // すでに出た値に戻ったら、計算終了して記録
        boolean finish = false;
        for (int i = 0; i < routes.length; i++) {
            if (routes[i] == list[n]) {
                finish = true;
                break;
            }
        }

        if (finish) {
            result[0] = routes.length;
            result[1] = getMiniNumOfArray(routes);
        } else {
            if (list[n] < list.length && list[list[n]] == 0) {
            // 計算結果が最大値以下かつ次の値が未計算だった場合は、約数の総和を計算してチェーン継続
                result = countChain(list[n], list, addNumToArray(routes,list[n]));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        final int LIMIT = 1000000;
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
    }
}
