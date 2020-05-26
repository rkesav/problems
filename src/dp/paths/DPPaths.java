package dp.paths;

public class DPPaths {
    public int uniquePaths(int m, int n) {
        int[][] numPaths = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                numPaths[i][j] = getNumberOfPathsForCell(i, j, numPaths);
            }
        }
        return numPaths[m-1][n-1];
    }

    private int getNumberOfPathsForCell(int i, int j, int[][] numPaths) {
        if (i <= 0 && j <= 0) {
            return 1;
        } else if (i <= 0) {
            return numPaths[i][j-1];
        } else if (j <= 0) {
            return numPaths[i-1][j];
        } else {
            return numPaths[i-1][j] + numPaths [i][j-1];
        }
    }
}
