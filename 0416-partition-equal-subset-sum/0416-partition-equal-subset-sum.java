class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;

        //sum calculation
        for(int num : nums){
            sum += num;
        }
        
        //odd sum cannot be partitioned
        if(sum % 2 != 0) return false;

        //target = sum/2
        return helper(nums, sum/2, n);
    }

    public boolean helper(int[] nums, int target, int n){

        //boolean dp initialization
        Boolean[][] dp = new Boolean[n][target+1];
        for(int i=0; i<n; i++){
            for(int j=0; j<=target; j++){
                dp[i][j] = false;
            }
        }
        
        //base cases
        for(int i=0; i<n; i++) dp[i][0] = true;
        if(nums[0] <= target) dp[0][nums[0]] = true;
        
        //take, not take method and result stored in dp
        for(int idx=1; idx<n; idx++){
            for(int k=1; k<=target; k++){
                boolean notTake = dp[idx-1][k];
                boolean take = false;
                if(k>=nums[idx]){
                    take = dp[idx-1][k-nums[idx]];
                }
                dp[idx][k] = (take | notTake);
            }
        }
        
        return dp[n-1][target];
    }
}