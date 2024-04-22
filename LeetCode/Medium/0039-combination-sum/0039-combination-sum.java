// https://leetcode.com/problems/combination-sum/

import java.util.*;

class Solution {
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(answer, new ArrayList<>(), candidates, target, 0);
        
        return answer;
    }
    
    private static void dfs(List<List<Integer>> answer, ArrayList<Integer> comb, int[] candidates, int target, int start) {
        
        if (target < 0) return;
        
        if (target == 0) {
            answer.add(new ArrayList<>(comb));
            return;
        }
        
        for (int i=start; i<candidates.length; i++) {
            int cur = candidates[i];
            comb.add(cur);
            dfs(answer, comb, candidates, target - cur, i);
            comb.remove(comb.size() - 1);
        }
    }
}