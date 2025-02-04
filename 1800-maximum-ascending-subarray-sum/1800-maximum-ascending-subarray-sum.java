class Solution {
    public int maxAscendingSum(int[] nums) {
        int n = nums.length;

        int maxSum = 0;
        int sum = nums[0];

        for(int i=1; i<n; i++){
            if(nums[i] > nums[i-1]){
                sum += nums[i];
            }
            else{
                maxSum = Math.max(maxSum, sum);
                sum = nums[i];
            }
        }

        return Math.max(maxSum, sum);
    }
}

//TC : O(n)
//SC : O(1)