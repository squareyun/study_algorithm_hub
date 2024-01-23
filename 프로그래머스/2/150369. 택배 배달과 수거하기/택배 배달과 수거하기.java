import java.util.*;

class Solution {
    public long solution(int cap, int n, int[] d, int[] p) {
        long answer = 0;
        
        int[] deliveries = new int[d.length];
        int[] pickups = new int[p.length];
        for (int i=n-1; i>=0; i--) {
            deliveries[i] = d[n-i-1];
            pickups[i] = p[n-i-1];
        }
        
        int sumD = 0, sumP = 0;
        for (int i=0; i<n; i++) {
            sumD += deliveries[i];
            sumP += pickups[i];
            
            while (sumD > 0 || sumP > 0) {
                sumD -= cap;
                sumP -= cap;
                answer += (n - i) * 2;
            }
        }
        
        return answer;
    }
}