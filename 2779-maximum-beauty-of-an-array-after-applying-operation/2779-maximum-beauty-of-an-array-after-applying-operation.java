class Solution {
    public int maximumBeauty(int[] nums, int k) {
        if(nums.length == 1) return 1;

        //create count array
        int max = 0;
        for(int num : nums){
            max = Math.max(max, num);
        }
        int[] count = new int[max+1];

        //insert range in  count array
        for(int num : nums){
            count[Math.max(num-k, 0)]++;
            count[Math.min(num+k+1, max)]--;
        }

        //find max of prefix sum
        int currSum = 0;
        int maxSum = 0;
        for(int c :count){
            currSum +=c;
            maxSum = Math.max(maxSum, currSum);
        }

        return maxSum;
    }
}

//TC : O(n + max(nums))
//SC : O(max(nums))