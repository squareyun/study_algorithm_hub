import java.util.*;

class Solution {
    
    static int answer = 10000;
    
    public int solution(String begin, String target, String[] words) {
        HashSet<String> hs = new HashSet<>();
        for (int i=0; i<words.length; i++) {
            hs.add(words[i]);
        }
        if (!hs.contains(target)) {
            answer = 0;
        } else {
            solve(begin, target, hs, 0);
        }
        return answer;
    }
    
    static void solve(String begin, String target, HashSet<String> hs, int count) {
        HashSet<String> newHs = null;
        
        for (String cur : hs) {
            int diff = 0;
            boolean flag = true;
            
            for (int i=0; i<begin.length(); i++) {
                if (cur.charAt(i) != begin.charAt(i)) {
                    diff++;
                    if (diff > 1) {
                        flag = false;
                        break;
                    }
                }
            }
            
            if (flag) {
                if (cur.equals(target)) {
                    answer = Math.min(answer, count + 1);
                    return;
                }
                
                newHs = new HashSet<>();
                for (String temp : hs) {
                    if(!cur.equals(temp))
                        newHs.add(temp);
                }
                solve(cur, target, newHs, count + 1);
            }
        }
    }
}