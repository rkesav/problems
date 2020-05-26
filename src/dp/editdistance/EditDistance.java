package dp.editdistance;

import java.util.List;

public class EditDistance {
    public int minDistance(String word1, String word2) {
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();

        int m = chars1.length;
        int n = chars2.length;
        int[][] dp = new int[m+1][n+1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {

                if(i == 0) {
                    dp[i][j] = j;
                } else if(j ==0) {
                    dp[i][j] = i;
                } else if(chars1[i-1] == chars2[j-1]) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = 1 + List.of(
                            dp[i-1][j-1],
                            dp[i-1][j],
                            dp[i][j-1])
                            .stream()
                            .min(Integer::compareTo)
                            .get();
                }
            }
        }
        return dp[m][n];
    }
}
