package fb;

import java.util.HashSet;

public class HappyNumber {
    public boolean isHappy(int n) {
        HashSet<Integer> seen = new HashSet<>();
        //int[] dp = new int[1000000];
        seen.add(n);
        while (n != 1) {
            n = getSumOfSquares(n);
            if (seen.contains(n)) {
                return false;
            }
            seen.add(n);
        }

        return n == 1;
    }

    private int getSumOfSquares(int n) {
        int unit = n%10;
        int rest = n/10;

        if (rest == 0) {
            return unit*unit;
        }
        //int restSquared = dp[rest] == 0?getSumOfSquares(rest, dp):dp[rest];
        //dp[rest] = restSquared;
        String s = "";

        return unit*unit + getSumOfSquares(rest);
    }
}
