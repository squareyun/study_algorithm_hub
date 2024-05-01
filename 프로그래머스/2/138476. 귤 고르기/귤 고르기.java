import java.util.*;

class Solution {
    
    public int solution(int k, int[] tangerine) {
        
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int num : tangerine) {
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }
        
        List<Integer> list = new ArrayList<>();
        for (Integer v : hm.values()) {
            list.add(v);
        }
        
        Collections.sort(list);
        
        int answer = 1;
        int acc = 0;
        for (int i=list.size()-1; i>=0; i--) {
            acc += list.get(i);
            if (acc >= k) break;
            answer++;
        }
        
        return answer;
    }
}