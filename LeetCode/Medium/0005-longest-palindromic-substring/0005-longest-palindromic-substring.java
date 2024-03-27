class Solution {
    public String longestPalindrome(String s) {
        if (s.length() < 2) return s;
        
        String answer = s.substring(0,1);
        
        for (int i=0; i<s.length()-1; i++) {
            String odd = expandFromCenter(s, i, i);
            String even = expandFromCenter(s, i, i+1);
            
            if (odd.length() > answer.length()) {
                answer = odd;
            }
            if (even.length() > answer.length()) {
                answer = even;
            }
        }
        
        return answer;
    }
    
    static String expandFromCenter(String s, int left, int right) {
        
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        
        return s.substring(left + 1, right);
    }
}