import java.util.*;

class Solution {
    
    static int[] arr, brr;
    static boolean[] v;
    static int n, answer;
    
    public int solution(int k, int[][] dungeons) {
        n = dungeons.length;
        
        arr = new int[n];
        brr = new int[n];
        v = new boolean[n];
        for (int i=0; i<n; i++) {
            arr[i] = i;
        }
        
        dfs(0, k, dungeons);
        
        return answer;
    }
    
    public static void dfs(int cur, int k, int[][] dungeons) {
        if (cur == n) {
            // logic
            int kTemp = k;
            int cnt = 0;
            
            for (int i=0; i<n; i++) {
                if (kTemp < dungeons[brr[i]][0]) {
                    break;
                }
                kTemp -= dungeons[brr[i]][1];
                cnt ++;
            }
            
            answer = Math.max(answer, cnt);
            
            return;
        }
        
        for (int i=0; i<n; i++) {
            if (v[i])
                continue;
            v[i] = true;
            brr[cur] = arr[i];
            dfs(cur + 1, k, dungeons);
            v[i] = false;
        }
    }
}