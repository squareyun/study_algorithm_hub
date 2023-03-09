import java.util.*;

class Solution {
    public int solution(int[] elements) {
        HashSet<Integer> set = new HashSet<>();
        
        int len = elements.length;
        for (int l = 1; l <= len; l++) {
            int idx = 0;
            while (idx < len) {
                int sum = 0;
                for (int i = idx; i < idx + l; i++) {
                    int temp = i;
                    if (temp >= len)
                        temp = temp % len;
                    sum += elements[temp];
                }
                set.add(sum);
                idx++;
            }
        }
        
        int answer = set.size();
        return answer;
    }
}