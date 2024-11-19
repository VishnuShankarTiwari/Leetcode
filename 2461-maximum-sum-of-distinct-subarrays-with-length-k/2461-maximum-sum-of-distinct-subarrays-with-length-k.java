//FIXED LENGTH WITH SLIDING WINDOW WITH FREQUENCY MAP

// we will use maxsum, currSum and compare to get maxSum
// frequency map to store the frequency and value
// if window size grow bigger than k, simply remove if left element from currSum
// remove its frquency from map


class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        long maxSum = 0;
        long currSum = 0;

        for(int i=0; i<n;i++){
            currSum += nums[i];
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

            if(i >= k -1){
                if(map.size() == k){
                    maxSum = Math.max(maxSum, currSum);
                }
                currSum -= nums[i-k+1];
                map.put(nums[i-k+1], map.get(nums[i-k+1]) - 1);
                if(map.get(nums[i-k+1]) == 0){
                    map.remove(nums[i-k+1]);
                }
            }
        }

        return maxSum;
    }
}

// TC : O(N)
// SC : O(N)