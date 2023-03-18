import java.util.*;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        final int INF = Integer.MAX_VALUE;
        ArrayList<int[]>[] list = new ArrayList[n+1];
        int[][] dist = new int[3][n+1];
        
        for (int i=0; i<=n; i++) {
            list[i] = new ArrayList<>();
        }
        
        for (int[] e : fares) {
            list[e[0]].add(new int[]{e[1], e[2]});
            list[e[1]].add(new int[]{e[0], e[2]});
        }
        
        // S에서 다른 노드로의 최단 경로 계산
        Arrays.fill(dist[0], INF);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
        pq.offer(new int[]{s, 0});
        dist[0][s] = 0;
        
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            
            if (cur[1] > dist[0][cur[0]])
                continue;
            
            for (int[] next : list[cur[0]]) {
                if (dist[0][next[0]] > dist[0][cur[0]] + next[1]) {
                    dist[0][next[0]] = dist[0][cur[0]] + next[1];
                    pq.offer(new int[]{next[0], next[1]});
                }
            }
        }
        
        // A에서 다른 노드로의 최단 경로 계산
        Arrays.fill(dist[1], INF);
        
        pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
        pq.offer(new int[]{a, 0});
        dist[1][a] = 0;
        
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            
            if (cur[1] > dist[1][cur[0]])
                continue;
            
            for (int[] next : list[cur[0]]) {
                if (dist[1][next[0]] > dist[1][cur[0]] + next[1]) {
                    dist[1][next[0]] = dist[1][cur[0]] + next[1];
                    pq.offer(new int[]{next[0], next[1]});
                }
            }
        }
        
        // B에서 다른 노드로의 최단 경로 계산
        Arrays.fill(dist[2], INF);
        
        pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
        pq.offer(new int[]{b, 0});
        dist[2][b] = 0;
        
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            
            if (cur[1] > dist[2][cur[0]])
                continue;
            
            for (int[] next : list[cur[0]]) {
                if (dist[2][next[0]] > dist[2][cur[0]] + next[1]) {
                    dist[2][next[0]] = dist[2][cur[0]] + next[1];
                    pq.offer(new int[]{next[0], next[1]});
                }
            }
        }
        
        int answer = dist[0][a] + dist[0][b];
        for (int i=1; i<=n; i++) {
            if (dist[0][i] == INF || dist[1][i] == INF || dist[2][i] == INF) continue;
            
            answer = Math.min(answer, dist[0][i] + dist[1][i] + dist[2][i]);
        }
        
        return answer;
    }
}