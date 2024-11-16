//DP DP  TABULATION TABULATION

//we cannot take adjacent elements so, we choose pick - nopick method to find the maximum sum
// bottom up approach
// use dp array to store the overlapping subproblems
// we check if dp
// use pick - nopick method and find the max between them
// and store them in dp
// return dp[n-1];


class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        // Arrays.fill(dp, 0);
        dp[0] = nums[0];
        int neg = 0;

        for(int i=1; i<n; i++){
            int pick = nums[i]; if(i>1) pick += dp[i-2];
            int noPick = dp[i-1];
            dp[i] = Math.max(pick, noPick);
        }

        return dp[n-1];
    }

    // public int helper(int[] nums, int idx, int[] dp){
    //     if(idx == 0) return nums[idx];
    //     if(idx < 0) return 0;
    //     if(dp[idx] != -1) return dp[idx];

        

    //     return dp[idx] = Math.max(pick, noPick);
    // }
}

//TC: O(N)
//SC: O(N)