import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] v = new boolean[n];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int i=0; i<n; i++) {
            if (v[i]) continue;
            
            answer++;
            pq.offer(i);
            v[i] = true;
            while (!pq.isEmpty()) {
                int cur = pq.poll();
                
                for (int j=0; j<n; j++) {
                    if (j == cur) continue;
                    if (v[j]) continue;
                    
                    if (computers[cur][j] == 1) {
                        pq.offer(j);
                        v[j] = true;
                    }
                }
            }
        }
        
        return answer;
    }
}