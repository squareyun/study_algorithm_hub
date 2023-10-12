import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        List<Integer> list = new ArrayList<>();
        
        long total = 1; // 전체 개수
        for (int i = 1; i <= n; i++) {
            list.add(i);
            total *= i;
        }
        
        k--; // 인덱스 0부터 시작
        int idx = 0;
        while (idx < n) {
            total = total / (n - idx);
            answer[idx++] = list.remove((int) (k / total));
            k %= total;
        }
        
        return answer;
    }
}