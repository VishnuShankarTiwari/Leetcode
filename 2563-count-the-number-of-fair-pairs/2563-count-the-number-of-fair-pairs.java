// BRUTE FORCE

// TLE      TLE    TLE      TLE

class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);

        return lowerRange(nums, upper) - lowerRange(nums, lower -1);
    }

    private long lowerRange(int[] nums, int sum){
        int n = nums.length;
        long res = 0;
        for(int i=0, j=n-1; i<j; ++i){
            while(i < j && nums[i] + nums[j] > sum){
                --j;
            }
            res += j - i;
        }
        return res;
    }
}


//TC : O(N²) 
//SC : (1)