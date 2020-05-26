package fb;

import java.util.Arrays;

public class WordSearch {
    public boolean exist(char[][] board, String word) {


        int index = 0;
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean wordFound = dfsCheck(i, j, index, word, board, new int[board.length][board[0].length]);
                    if (wordFound == true) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfsCheck(int row, int col, int index, String word, char[][] board, int[][] visited) {


        if (row < 0 || row >= board.length || col < 0 || col >= board[row].length ) {
            return false;
        }
        if (visited[row][col] == 1) {
            return false;
        }

        if (index+1 == word.length()) {
            if (word.charAt(index) == board[row][col]) {
                return true;
            } else {
                return false;
            }
        } else {
            if (word.charAt(index) == board[row][col]) {
                visited[row][col] = 1;
                return dfsCheck(row+1, col, index+1, word, board, Arrays.copyOf(visited, visited.length))
                        || dfsCheck(row, col+1, index+1, word, board, Arrays.copyOf(visited, visited.length))
                        || dfsCheck(row, col-1, index+1, word, board, Arrays.copyOf(visited, visited.length))
                        || dfsCheck(row-1, col, index+1, word, board, Arrays.copyOf(visited, visited.length));

            } else {
                return false;
            }
        }
    }
}
