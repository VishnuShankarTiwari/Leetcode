class Solution {
    public int waysToSplitArray(int[] nums) {
        int n = nums.length;

        //calculating total sum 
        long rightSum = 0;
        for(int num : nums){
            rightSum += num;
        }

        //while iteration we add leftsum and subtract element from total sum
        long leftSum = 0;
        int count = 0;

        for(int i=0; i<n-1; i++){
            leftSum += nums[i];
            rightSum -= nums[i];

            if(leftSum >= rightSum) count++;
        }

        return count;
    }
}

//TC : O(2n)
//SC : O(1)