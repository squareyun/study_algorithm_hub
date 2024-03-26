import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int left = 0, right = 0;
        int answer = 0;
        HashSet<Character> hs = new HashSet<>();
        
        while (right < s.length()) {
            char c = s.charAt(right);
            
            while (hs.contains(c)) {
                hs.remove(s.charAt(left));
                left++;
            }
            
            hs.add(c);
            answer = Math.max(answer, right - left + 1);
            right++;
        }
        
        return answer;
    }
}