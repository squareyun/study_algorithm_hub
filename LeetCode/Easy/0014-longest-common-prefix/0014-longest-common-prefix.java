// https://leetcode.com/problems/longest-common-prefix/

import java.util.*;

class Solution {
    public String longestCommonPrefix(String[] strs) {
                
        // string 길이 기준 정렬
        Arrays.sort(strs, Comparator.comparing(String::length));
        
        String answer = strs[0];
        
        for (int i=1; i<strs.length; i++) {
            
            String str = strs[i];
            
            int j = answer.length();
            String sub = answer.substring(0, j);
            while (!str.startsWith(sub) && j >= 1) {
                j--;
                sub = answer.substring(0, j);
            }
            
            answer = sub;
            
            if (answer.equals("")) break;
        }
        
        return answer;
    }
}