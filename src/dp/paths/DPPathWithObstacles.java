package dp.paths;

public class DPPathWithObstacles {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0) return 0;

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if (obstacleGrid[m-1][n-1] == 1) {
            return 0;
        }

        int[][] numPaths = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                numPaths[i][j] = getNumberOfPathsForCell(i, j, numPaths, obstacleGrid);
            }
        }
        return numPaths[m-1][n-1];
    }

    private int getNumberOfPathsForCell(int i, int j, int[][] numPaths, int[][] obstacleGrid) {
        if (i <= 0 && j <= 0) {
            return obstacleGrid[i][j] == 1 ? 0:1;
        } else {
            int totalNumPaths = 0;
            if (j > 0) {
                if (obstacleGrid[i][j-1] != 1) {
                    totalNumPaths += numPaths [i][j-1];
                }
            }
            if (i > 0) {
                if (obstacleGrid[i-1][j] != 1) {
                    totalNumPaths += numPaths [i-1][j];
                }
            }

            return totalNumPaths;
        }
    }}
