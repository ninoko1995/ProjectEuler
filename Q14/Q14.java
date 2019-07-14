public class Q14 {
    public static void main(String[] args) {
        final int LIMIT = 1000000;

        // 最大値記録用
        int maxChain = 0;
        int maxChainNum = 0;

        // LIMIT以下のすべての数値のチェーンを数え、最大値記録。
        for (int i = 2; i <= LIMIT; i++) {
            int times = 0;
            long number = i;

            // チェーン数える部分
            while (number >= 1) {
                if (number % 2 == 0) {
                    number /= 2;
                } else {
                    number = number * 3 + 1;
                }
                times++;

                if (number == 1) {
                    break;
                }

            }

            // 記録部分
            if (times + 1 > maxChain) {
                maxChain = times + 1;
                maxChainNum = i;
            }
        }
        System.out.println(maxChainNum);
    }
}