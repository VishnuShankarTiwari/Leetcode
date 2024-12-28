class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;

        int[] subarraySum = new int[n - k + 1];
        int i = 0;
        int j = 0;
        int windowSum = 0;

        while (j < n) {
            windowSum += nums[j];

            if (j - i + 1 == k) {
                subarraySum[i] = windowSum;
                windowSum -= nums[i];
                i++;
            }
            j++;
        }

        int[] result = new int[3];
        solve(subarraySum, 3, 0, k, result);

        return result;
    }

    void solve(int[] subarraySum, int count, int i, int k, int[] result){
        if (count == 0) return;

        if (i >= subarraySum.length) return;

        int take = subarraySum[i] + helper(subarraySum, count - 1, i + k, k);
        int notTake = helper(subarraySum, count, i + 1, k);

        if (take >= notTake) {
            result[3 - count] = i;
            solve(subarraySum, count - 1, i + k, k, result);
        } else {
            solve(subarraySum, count, i + 1, k, result);
        }
    }

    int helper(int[] subarraySum, int count, int i, int k){
        if (count == 0) return 0;
        if (i >= subarraySum.length) return 0;

        int take = subarraySum[i] + helper(subarraySum, count - 1, i + k, k);
        int notTake = helper(subarraySum, count, i + 1, k);

        return Math.max(take, notTake);
    }
}