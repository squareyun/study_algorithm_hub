// https://leetcode.com/problems/roman-to-integer/

import java.util.*;

class Solution {
    public int romanToInt(String s) {
        
        HashMap<String, Integer> dict = makeDict();
        int len = s.length();
        int answer = 0;
        
        for (int i=0; i<len; i++) {
            if (i != len - 1 && dict.containsKey(s.substring(i, i+2))) {
                answer += dict.get(s.substring(i, i+2));
                i++;
            } else {
                answer += dict.get(s.substring(i, i+1));
            }
        }
        
        return answer;
    }
    
    static HashMap makeDict() {
        HashMap<String, Integer> dict = new HashMap<>();
        dict.put("I", 1);
        dict.put("V", 5);
        dict.put("X", 10);
        dict.put("L", 50);
        dict.put("C", 100);
        dict.put("D", 500);
        dict.put("M", 1000);
        dict.put("IV", 4);
        dict.put("IX", 9);
        dict.put("XL", 40);
        dict.put("XC", 90);
        dict.put("CD", 400);
        dict.put("CM", 900);
        return dict;
    }
}