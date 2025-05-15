import java.util.*;

class Solution {
    
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    
    public int solution(int[][] maps) {
        
        int n = maps.length;
        int m = maps[0].length;
        
        Queue<Pos> q = new ArrayDeque<>();
        boolean[][] v = new boolean[n][m];
        
        q.offer(new Pos(0, 0, 1));
        v[0][0] = true;
        
        while (!q.isEmpty()) {
            Pos cur = q.poll();
            
            for (int d=0; d<4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                
                if (nx == n - 1 && ny == m - 1)
                    return cur.cnt + 1;
                
                if (nx < 0 || nx >= n || ny < 0 || ny >= m)
                    continue;
                if (v[nx][ny])
                    continue;
                if (maps[nx][ny] == 0)
                    continue;
                
                v[nx][ny] = true;
                q.offer(new Pos(nx, ny, cur.cnt + 1));
            }
        }
        
        return -1;
    }
    
    static class Pos {
        int x, y, cnt;
        
        public Pos(int x, int y, int cnt) {
            this.x=x;
            this.y=y;
            this.cnt=cnt;
        }
    }
}