//DP DP  SPACE OPTIMIZATION

// we take two variable prev2 and prev
// iterate on array and always keep storing the last two index max sum
// for next value prev2 = prev; prev = curr in same manner
// return prev as the maxsum will be at n-1 index and prev will have max value


class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int prev = nums[0];
        int prev2 = 0;

        for(int i=1; i<n; i++){
            int pick = nums[i]; if(i>1) pick += prev2;
            int noPick = prev;
            int curr = Math.max(pick, noPick);

            prev2 = prev;
            prev = curr;
        }

        return prev;
    }
}

//TC: O(N)
//SC: O(1)