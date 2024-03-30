// https://leetcode.com/problems/roman-to-integer/

import java.util.*;

class Solution {
    public int romanToInt(String s) {
        
        HashMap<Character, Integer> dict = makeDict();
        int len = s.length();
        int answer = 0;
        
        for (int i=0; i<len; i++) {
            if (i != len - 1 && dict.get(s.charAt(i)) < dict.get(s.charAt(i+1))) {
                answer -= dict.get(s.charAt(i));
            } else {
                answer += dict.get(s.charAt(i));
            }
        }
        
        return answer;
    }
    
    static HashMap makeDict() {
        HashMap<Character, Integer> dict = new HashMap<>();
        
        dict.put('I', 1);
        dict.put('V', 5);
        dict.put('X', 10);
        dict.put('L', 50);
        dict.put('C', 100);
        dict.put('D', 500);
        dict.put('M', 1000);
        
        return dict;
    }
}