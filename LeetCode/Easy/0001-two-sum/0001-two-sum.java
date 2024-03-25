import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        HashMap<Integer, Integer> hm = new HashMap<>();
        int n = nums.length;

        for (int i=0; i<n; i++) {
            if (hm.containsKey(nums[i])) {
                return new int[]{i, hm.get(nums[i])};
            }
            hm.put(target - nums[i], i);
        }

        return new int[]{};
    }
}