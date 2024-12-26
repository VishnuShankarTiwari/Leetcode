class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        return countPartitions(nums, target, n);
    }

    private int countPartitions(int[] nums, int tar, int n) {
        int total = 0;

        for (int i : nums) {
            total += i;
        }

        if (total - tar < 0 || (total - tar) % 2 != 0) return 0;
        return findWays(nums, (total - tar) / 2);
    }

    private int findWays(int[] nums, int tar) {
        int n = nums.length;
        int[] prev = new int[tar + 1];
        int[] curr = new int[tar + 1];

        if (nums[0] == 0) prev[0] = 2;
        else prev[0] = 1;

        if (nums[0] != 0 && nums[0] <= tar) prev[nums[0]] = 1;

        for (int idx = 1; idx < n; idx++) {
            for (int sum = 0; sum <= tar; sum++) {
                int notTake = prev[sum];
                int take = 0;
                if (nums[idx] <= sum) take = prev[sum - nums[idx]];
                curr[sum] = notTake + take;
            }
            prev = curr.clone();
        }

        return prev[tar];
    }
}

//TC : O(n x s)
//SC : O(s)