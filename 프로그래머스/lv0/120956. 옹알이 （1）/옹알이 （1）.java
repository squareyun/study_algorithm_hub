import java.util.*;

class Solution {
    
    public int solution(String[] babbling) {
        int answer = 0;
        
        HashSet<String> set3 = new HashSet<>();
        HashSet<String> set2 = new HashSet<>();
        set3.add("aya");
        set3.add("woo");
        set2.add("ye");
        set2.add("ma");
        
        for (int i=0; i<babbling.length; i++) {
            String now = babbling[i];
            
            int idx = 0;
            boolean flag = true;
            while (idx < now.length()) {
                if (idx + 2 <= now.length() && set2.contains(now.substring(idx, idx + 2))) {
                    idx += 2;
                } else if (idx + 3 <= now.length() && set3.contains(now.substring(idx, idx + 3))) {
                    idx += 3;
                } else {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                answer += 1;
            }
        }
        
        return answer;
    }
}