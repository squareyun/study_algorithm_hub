import java.util.*;

class Solution {
    
    static class Node {
        int x, y, cnt;
        
        public Node(int x, int y, int cnt) {
            super();
            this.x=x;
            this.y=y;
            this.cnt=cnt;
        }
    }
    
    public int solution(String[] maps) {
        int answer = -1;
        int N = maps.length;
        int M = maps[0].length();
        int startX = 0, startY = 0;
        
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (maps[i].charAt(j) == 'S') {
                    startX = i;
                    startY = j;
                    break;
                }
            }    
        }
        
        int[] dx = new int[] {0, 0, 1, -1};
        int[] dy = new int[] {1, -1, 0, 0};
        
        // L까지 최단거리
        boolean[][] v = new boolean[N][M];
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(startX, startY, 0));
        int distance1 = -1;
        int lx = 0, ly = 0;
        while (!q.isEmpty()) {
            Node cur = q.poll();
            
            if (maps[cur.x].charAt(cur.y) == 'L') {
                lx = cur.x;
                ly = cur.y;
                distance1 = cur.cnt;
                break;
            }
            
            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                
                if (nx < 0 || nx >= N || ny < 0 || ny >= M)
                    continue;
                
                if (v[nx][ny] || maps[nx].charAt(ny) == 'X') 
                    continue;
                
                v[nx][ny] = true;
                q.offer(new Node(nx, ny, cur.cnt + 1));
            }
        }
        
        // L까지 최단거리
        v = new boolean[N][M];
        q.clear();
        q.offer(new Node(lx, ly, 0));
        int distance2 = -1;
        
        while (!q.isEmpty()) {
            Node cur = q.poll();
            
            if (maps[cur.x].charAt(cur.y) == 'E') {
                distance2 = cur.cnt;
                break;
            }
            
            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                
                if (nx < 0 || nx >= N || ny < 0 || ny >= M)
                    continue;
                
                if (v[nx][ny] || maps[nx].charAt(ny) == 'X') 
                    continue;
                
                v[nx][ny] = true;
                q.offer(new Node(nx, ny, cur.cnt + 1));
            }
        }
        
        if (distance1 != -1 && distance2 != -1) {
            answer = distance1 + distance2;
        }
        
        return answer;
    }
}