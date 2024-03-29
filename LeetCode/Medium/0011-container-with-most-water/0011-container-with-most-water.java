class Solution {
    public int maxArea(int[] height) {
        
        int left = 0;
        int right = height.length - 1;
        int answer = 0;
        
        while (left < right) {
            int curArea = (right - left) * Math.min(height[left], height[right]);
            answer = Math.max(answer, curArea);
            
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        
        return answer;
    }
}