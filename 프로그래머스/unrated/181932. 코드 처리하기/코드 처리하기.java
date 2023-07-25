import java.util.*;

class Solution {
    public String solution(String code) {
        StringBuilder answer = new StringBuilder();
        
        int mode = 0;
        
        for (int i=0; i<code.length(); i++) {
            char cur = code.charAt(i);
            if (mode == 0) {
                if (cur != '1' && i % 2 == 0) {
                     answer.append(cur);
                } else if (cur == '1') {
                    mode = 1;
                }
            } else {
                if (cur != '1' && i % 2 == 1) {
                     answer.append(cur);
                } else if (cur == '1') {
                    mode = 0;
                }
            }
        }
        
        if (answer.toString().equals("")) {
            return "EMPTY";
        }
        return answer.toString();
    }
}