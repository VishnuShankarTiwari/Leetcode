class Solution {
    public long findScore(int[] nums) {
        int n = nums.length;

        //copy and sort the array
        int copy[][] = new int[n][2];
        for(int i=0; i<n; i++){
            copy[i][0] = nums[i];
            copy[i][1] = i;
        }
        Arrays.sort(copy, (a, b) -> a[0] - b[0]);

        //get minimum from copy and mark in nums with negative
        long res = 0;
        for(int i=0; i<n; i++){
            int ele = copy[i][0];
            int idx = copy[i][1];
            if(nums[idx] < 0) continue;
            res += nums[idx];
            nums[idx] = -nums[idx];
            if(idx-1 >= 0 && nums[idx-1] > 0) nums[idx-1] = -nums[idx-1];
            if(idx+1 < n && nums[idx+1] > 0) nums[idx+1] = -nums[idx+1];
            
        }

        return res;
    }
}

//TC : O(nlogn + 2n)
//SC : O(n)