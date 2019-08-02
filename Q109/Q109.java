public class Q109 {
    public static void main(String[] args) {
        final int LIMIT = 100;
        int count = 0; // 一旦全部カウント
        int threeCount = 0; // 3回投げるもの
        int threeSameCount = 0; // 3回投げるもののうち、最初と2回目の特典が同じものの数
        int exactCount = 0; // 最終的な正しいカウント

        // doubleで終わる
        for (int i = 1; i <= 25; i++) {
            if (21 <= i && i <= 24) continue;
            int sum = i * 2;

            // single, double, triple. 0はそこで終わりを意味する
            for (int t = 0; t <= 3; t++) {
                if (t == 0) {
                    count++;
                    continue;
                }
                for (int h = 1; h <= 25; h++) {
                    if (21 <= h && h <= 24) continue;
                    if (t == 3 && h == 25) continue;
                    if (sum + t * h >= LIMIT) continue;

                    // single, double, triple. 0はそこで終わりを意味する
                    for (int w = 0; w <= 3; w++) {
                        if (w == 0) {
                            count++;
                            continue;
                        }
                        for (int p = 1; p <= 25; p++) {
                            if (21 <= p && p <= 24) continue;
                            if (w == 3 && p == 25) continue;
                            if (sum + t * h + w * p >= LIMIT) continue;
                            if (t == w && h == p)
                                threeSameCount++;

                            threeCount++;
                            count++;
                        }
                    }
                }
            }
        }
        exactCount = count - threeCount + (threeCount - threeSameCount) / 2 + threeSameCount;
        System.out.println(exactCount);
    }
}