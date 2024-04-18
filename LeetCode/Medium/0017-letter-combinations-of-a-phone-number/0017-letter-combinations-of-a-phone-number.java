// https://leetcode.com/problems/letter-combinations-of-a-phone-number/

class Solution {
    
    public List<String> letterCombinations(String digits) {
        
        List<String> answer = new ArrayList<>();
        
        if (digits.equals("")) return answer;
        
        String[] map = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        dfs("", digits, map, answer);
        
        return answer;
    }
    
    private void dfs(String comb, String digits, String[] map, List<String> answer) {
        
        if (digits.equals("")) {
            answer.add(comb);
            return;
        }
        
        String letters = map[digits.charAt(0) - '2'];
        for (char letter : letters.toCharArray()) {
            dfs(comb + letter, digits.substring(1), map, answer);
        }
    }
}