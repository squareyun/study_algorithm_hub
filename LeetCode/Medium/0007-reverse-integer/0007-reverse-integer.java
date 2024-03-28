class Solution {
    public int reverse(int x) {
        
        boolean isNegative = false;
        
        if (x < 0) {
            isNegative = true;
            x = x * (-1);
        }
        
        long reversed = 0;
        while (x != 0) {
          reversed = reversed * 10 + x % 10;
          x /= 10;
        }
        
        reversed = isNegative ? reversed * (-1) : reversed;
        
        if (reversed > Integer.MAX_VALUE || reversed < Integer.MIN_VALUE) {
          reversed = 0;
        }
        
        return (int) reversed;
    }
}