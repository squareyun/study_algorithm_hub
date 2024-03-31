// https://leetcode.com/problems/3sum/

import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        Arrays.sort(nums); // -4 -1 -1 0 1 2
        
        List<List<Integer>> ans = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        
        for (int i=0; i<nums.length; i++) {
            if (i>0 && nums[i] == nums[i-1]) continue; // 중복
            
            int target = -nums[i];
            int left = i+1;
            int right = nums.length - 1;
            
            while (left < right) {
                int sum = nums[left] + nums[right];
                
                if (sum < target) {
                    left++;
                } else if (sum > target) {
                    right--;
                } else if (sum == target) {
                    List<Integer> triplet = Arrays.asList(nums[i], nums[left], nums[right]);
                    if (!set.contains(triplet)) {
                        ans.add(triplet);
                        set.add(triplet);
                    }
                    left++;
                    right--;
                    
                    // new left, right 중복
                    while (left < right && nums[left] == nums[left-1]) left++;
                    while (left < right && nums[right] == nums[right+1]) right--;
                }
            }
        }
        
        return ans;
    }
}