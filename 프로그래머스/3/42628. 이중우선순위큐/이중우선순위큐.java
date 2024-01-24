import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        
        StringTokenizer st = null;
        for (int i=0; i<operations.length; i++) {
            st = new StringTokenizer(operations[i], " ");
            String op = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            
            switch(op) {
                case "I":
                    tm.put(num, tm.getOrDefault(num, 0) + 1);
                    break;
                case "D":
                    if (tm.isEmpty()) break;
                    
                    int key = 0;
                    if (num == 1) {
                        key = tm.lastKey();
                    } else if (num == -1) {
                        key = tm.firstKey();
                    }
                    
                    if (tm.get(key) == 1)
                        tm.remove(key);
                    else
                        tm.put(key, tm.get(key) - 1);
                    break;
            }
        }
        
        if (tm.isEmpty()) {
            return new int[]{0, 0};
        } else {
            answer[0] = tm.lastKey();
            answer[1] = tm.firstKey();
        }
        
        return answer;
    }
}