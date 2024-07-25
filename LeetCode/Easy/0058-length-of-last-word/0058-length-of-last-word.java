class Solution {
    public int lengthOfLastWord(String s) {
        int idx = s.length() - 1;
        while (idx >= 0 && s.charAt(idx) == ' ') {
            idx--;
        }

        int len = 0;
        while (idx >= 0 && s.charAt(idx) != ' ') {
            len++;
            idx--;
        }
        return len;
    }
}