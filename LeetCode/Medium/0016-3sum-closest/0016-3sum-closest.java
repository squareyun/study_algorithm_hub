class Solution {
    public int threeSumClosest(int[] nums, int target) {
        
        int answer = nums[0] + nums[1] + nums[2];
        
        Arrays.sort(nums); // -4 -1 1 2
        
        for (int i = 0; i < nums.length; i++) {
            
            int left = i + 1;
            int right = nums.length - 1;
            
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                
                if (Math.abs(target - sum) < Math.abs(target - answer)) {
                    answer = sum;
                }
                
                if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        
        return answer;
    }
}