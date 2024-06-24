import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static int S, T;
    static int answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        List<Integer>[] adj, adjR;
        adj = new ArrayList[n + 1];
        adjR = new ArrayList[n + 1];
        for (int i=1; i<=n; i++) {
            adj[i] = new ArrayList<>();
            adjR[i] = new ArrayList<>();
        }

        int from, to;
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            adj[from].add(to);
            adjR[to].add(from);
        }

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        
        boolean[] fromS = new boolean[n + 1];
        boolean[] fromT = new boolean[n + 1];
        boolean[] toS = new boolean[n + 1];
        boolean[] toT = new boolean[n + 1];

        fromS[T] = true;
        fromT[S] = true;
        
        dfs(S, fromS, adj);
        dfs(T, fromT, adj);
        dfs(S, toS, adjR);
        dfs(T, toT, adjR);
            
        for (int i=1; i<=n; i++) {
            if (fromS[i] && fromT[i] && toS[i] && toT[i]) {
                answer++;
            }
        }

        answer -= 2; // 출근길, 퇴근길 제거
        System.out.println(answer);
    }

    static void dfs(int now, boolean[] v, List<Integer>[] adjList) {
        if (v[now]) return;
        v[now] = true;
        
        for (int i : adjList[now]) {
            dfs(i, v, adjList);
        }
    }
    
}
