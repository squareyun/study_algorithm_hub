import java.util.*;

class Solution {
    
    static int[] inDegree;
    static int[] outDegree;
    static int N = 1_000_001;
    static boolean isInit = true;
    
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
        
        countInOutDegree(edges);
        
        // 생성된 정점 찾기
        for (int i=1; i<=N; i++) {
            if (inDegree[i] == 0 && outDegree[i] >= 2) {
                answer[0] = i;
                break;
            }
        }
        
        // 생성된 정점과 연결된 간선 제거
        List<int[]> newEdges = new ArrayList<>();
        int totalGraphCount = 0;
        
        for (int[] edge: edges) {
            if (edge[0] == answer[0] || edge[1] == answer[0]) {
                totalGraphCount++;
                continue;
            }
            newEdges.add(new int[]{edge[0], edge[1]});
        }
        
        edges = new int[newEdges.size()][2];
        for (int i = 0; i < newEdges.size(); i++) {
            edges[i] = newEdges.get(i);
        }
        
        countInOutDegree(edges);
        
        // 막대그래프 개수 구하기
        for (int i=1; i<=N; i++) {
            if (i == answer[0]) continue;
            
            if (inDegree[i] == 0)
                answer[2]++;
        }
        
        // 8자 모양 그래프 개수 구하기
        for (int i=1; i<=N; i++) {
            if (inDegree[i] == 2 && outDegree[i] == 2)
                answer[3]++;
        }
        
        // 도넛 모양 그래프 개수
        answer[1] = totalGraphCount - answer[2] - answer[3];
        
        return answer;
    }
    
    static void countInOutDegree(int[][] edges) {
        inDegree = new int[N+1];
        outDegree = new int[N+1];
        
        if (isInit) N = -1;
        for (int[] edge : edges) {
            outDegree[edge[0]]++;
            inDegree[edge[1]]++;
            if (isInit) N = Math.max(N, Math.max(edge[0], edge[1]));
        }
        isInit = false;
    }
    
}