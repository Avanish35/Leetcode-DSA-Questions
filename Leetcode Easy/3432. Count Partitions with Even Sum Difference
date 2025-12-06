Leetcode Link: https://leetcode.com/problems/count-partitions-with-even-sum-difference/submissions/1847656873/

JAVA CODE:

class Solution {
    public int countPartitions(int[] nums) {
        int n = nums.length;
        
        int sum = 0;
        for (int x : nums) sum += x;
        
        int leftSum = 0;
        int result = 0;

        for(int i = 0; i < n - 1; i++){
            leftSum += nums[i];
            int rightSum = sum - leftSum;

            if ((leftSum - rightSum) % 2== 0){
                result++;
            }
        }
        return result;
    }
}
