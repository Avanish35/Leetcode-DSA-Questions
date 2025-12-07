// Leetcode Link : https://leetcode.com/problems/count-partitions-with-max-min-difference-at-most-k/description/

// JAVA CODE :

class Solution {
    public int countPartitions(int[] nums, int k) {
        int n = nums.length;
        long MOD = 1_000_000_007;
        long[] dp = new long[n+1];
        long[] prefixSumDP = new long[n+1];

        dp[0] = 1;
        prefixSumDP[0] = 1;

        Deque<Integer> maxDeque = new ArrayDeque<>();
        Deque<Integer> minDeque = new ArrayDeque<>();

        int p=0;
        for(int i = 0; i<n; i++){
            while(!maxDeque.isEmpty() && nums[maxDeque.peekLast()]<= nums[i]){
                maxDeque.removeLast();
            }
            maxDeque.addLast(i);
            while(!minDeque.isEmpty() && nums[minDeque.peekLast()]>= nums[i]){
                minDeque.removeLast();
            }
            minDeque.addLast(i);
            while (nums[maxDeque.peekFirst()]-nums[minDeque.peekFirst()]>k){
                if(maxDeque.peekFirst() ==p){
                    maxDeque.removeFirst();
                }
                if(minDeque.peekFirst()==p){
                    minDeque.removeFirst();
                }
                p++;
            }
            long sum_dp_p_to_i = (prefixSumDP[i]-(p>0?prefixSumDP[p-1]:0)+MOD)%MOD;
            dp[i+1]=sum_dp_p_to_i;
            prefixSumDP[i+1] = (prefixSumDP[i]+dp[i+1])%MOD;
        }
        return(int)dp[n];
    }
}
