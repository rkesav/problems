package dp.maxUncrossedLines;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MaxUncrossedLines {
    public int maxUncrossedLines(int[] A, int[] B) {
        int[][] dp = new int[A.length][B.length];
        int[] markedA = new int[A.length];
        int[] markedB = new int[B.length];

        for(int i = 0; i < A.length; i++) {
            for(int j =0; j < B.length; j++) {
                if (i == 0 && j == 0) {
                    if (A[i] == B[j]) {
                        dp[i][j] = 1;
                        markIndicesAsConnected(markedA, markedB, i, j);
                    } else {
                        dp[i][j] = 0;
                    }
                } else if (i == 0) {
                    if (markedA[i] == 1) {
                        dp[i][j] = 1;
                    } else if (A[i] == B[j]) {
                        dp[i][j] = 1;
                        markIndicesAsConnected(markedA, markedB, i, j);
                    } else {
                        dp[i][j] = 0;
                    }
                } else if (j == 0) {
                    if (markedB[j] == 1) {
                        dp[i][j] = 1;
                    } else if (A[i] == B[j]) {
                        dp[i][j] = 1;
                        markIndicesAsConnected(markedA, markedB, i, j);
                    } else {
                        dp[i][j] = 0;
                    }
                } else {
                    if (markedA[i] == 1 && markedB[j] == 1) {
                        if (A[i] == B[j]) {
                            dp[i][j] = List.of(1 + dp[i-1][j-1], dp[i][j-1], dp[i-1][j]).stream().max(Integer::compareTo).get();
                            markIndicesAsConnected(markedA, markedB, i, j);
                        } else {
                            dp[i][j] = List.of(dp[i][j-1], dp[i-1][j]).stream().max(Integer::compareTo).get();
                        }

                    } else if (markedA[i] == 1){
                        if (A[i] == B[j]) {
                            dp[i][j] = List.of(1 + dp[i-1][j-1], dp[i][j-1], 1 + dp[i-1][j]).stream().max(Integer::compareTo).get();
                            markIndicesAsConnected(markedA, markedB, i, j);
                        } else {
                            dp[i][j] = List.of(dp[i][j-1], dp[i-1][j]).stream().max(Integer::compareTo).get();
                        }


                    } else if (markedB[j] == 1){
                        if (A[i] == B[j]) {
                            dp[i][j] = List.of(1 + dp[i-1][j-1], 1 + dp[i][j-1], dp[i-1][j]).stream().max(Integer::compareTo).get();
                            markIndicesAsConnected(markedA, markedB, i, j);
                        } else {
                            dp[i][j] = List.of(dp[i][j-1], dp[i-1][j]).stream().max(Integer::compareTo).get();
                        }


                    } else {
                        if (A[i] == B[j]) {
                            dp[i][j] = List.of(1 + dp[i-1][j-1], 1 + dp[i][j-1], 1 + dp[i-1][j]).stream().max(Integer::compareTo).get();
                            markIndicesAsConnected(markedA, markedB, i, j);
                        } else {
                            dp[i][j] = List.of(dp[i][j-1], dp[i-1][j]).stream().max(Integer::compareTo).get();
                        }

                    }
                }
            }

        }
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> valuesWithNonZeroCount = map.values().stream().filter(x -> x != 0).collect(Collectors.toList());
        return dp[A.length - 1][B.length -1];
    }

    private void markIndicesAsConnected(int[] markedA, int[] markedB, int i, int j) {
        markedA[i] = 1;
        markedB[j] = 1;
    }
}
