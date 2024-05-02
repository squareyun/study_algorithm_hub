// https://leetcode.com/problems/word-search/

class Solution {

    static int n, m;
    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, 1, 0, -1 };

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;

        if (m * n < word.length())
            return false;

        char startWord = word.charAt(0);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == startWord) {
                    boolean[][] v = new boolean[m][n];
                    v[i][j] = true;
                    if (dfs(i, j, board, word.substring(1, word.length()), v))
                        return true;
                }
            }
        }

        return false;
    }

    static boolean dfs(int i, int j, char[][] board, String word, boolean[][] v) {
        // System.out.println(i + " " + j + " " + word);
        if (word.isEmpty())
            return true;

        int nx, ny;
        char targetWord = word.charAt(0);
        for (int d = 0; d < 4; d++) {
            nx = i + dx[d];
            ny = j + dy[d];

            if (nx < 0 || nx >= m || ny < 0 || ny >= n)
                continue;
            if (v[nx][ny])
                continue;

            if (board[nx][ny] == targetWord) {
                v[nx][ny] = true;
                if (dfs(nx, ny, board, word.substring(1, word.length()), v))
                    return true;
                v[nx][ny] = false;
            }
        }

        return false;
    }
}