// 역발상.. 반대로 생각하자!

class Solution {
    
    static int n, m;
    
    public void solve(char[][] board) {
        
        n = board.length;
        m = board[0].length;
        
        
        // 가장 자리의 O를 V로 표시해두기
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (i == 0 || i == n-1 || j == 0 || j == m-1) {
                    if (board[i][j] == 'O') dfs(i, j, board);
                }
            }
        }
        
        // V는 변동하면 안되므로 원상복구
        // 그 외에는 둘러 쌓여있으므로 flip!
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == 'V') board[i][j] = 'O';
            }
        }
    }
    
    private static void dfs(int i, int j, char[][] board) {
        if (i < 0 || i >= n || j < 0 || j >= m || board[i][j] != 'O') return;
        
        board[i][j] = 'V';
        
        dfs(i+1, j, board);
        dfs(i-1, j, board);
        dfs(i, j+1, board);
        dfs(i, j-1, board);
    }
}