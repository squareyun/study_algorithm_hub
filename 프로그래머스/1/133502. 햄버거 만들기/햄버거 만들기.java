import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        
        List<Integer> stack = new ArrayList<>();
        for (int i=0; i<ingredient.length; i++) {
            stack.add(ingredient[i]);
            int sz = stack.size();
            if (sz >= 4) {
                if (stack.get(sz-1) == 1 && stack.get(sz-2) == 3 && stack.get(sz-3) == 2 && stack.get(sz-4) == 1) {
                    for (int j=0; j<4; j++) {
                        stack.remove(stack.size()-1);
                    }
                    answer++;
                }
            }
        }
        
        return answer;
    }
}