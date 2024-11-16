//DP DP  SPACE OPTIMIZATION


// we just take two cases as first one doesnot contain the 0th element and second one as it doesnot have last element
// we pass the array and start idx, end idx
// we take two variable prev2 and prev
// iterate on array and always keep storing the last two index max sum
// for next value prev2 = prev; prev = curr in same manner
// return prev as the maxsum will be at n-1 index and prev will have max value


class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        
        return Math.max(helper(nums, 1, n-1), helper(nums, 0, n-2));
    }

    public int helper(int[] nums, int start, int end){
        int prev = 0;
        int prev2 = 0;

        for(int i=start; i<=end; i++){
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