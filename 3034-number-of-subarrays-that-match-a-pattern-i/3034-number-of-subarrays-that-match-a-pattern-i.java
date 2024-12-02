class Solution {
    public int countMatchingSubarrays(int[] nums, int[] pattern) {
        
        int n = nums.length;
        int m = pattern.length;
        int count = 0;

        //subarray of size m+1
        for (int i = 0; i <= n - m - 1; i++) {

            //flag
            boolean isValid = true;
            
            //subarray traversal
            for (int k = 0; k < m; k++) {
                if (pattern[k] == 1 && nums[i + k + 1] <= nums[i + k]) {
                    isValid = false;
                    break;
                }

                if (pattern[k] == 0 && nums[i + k + 1] != nums[i + k]) {
                    isValid = false;
                    break;
                }

                if (pattern[k] == -1 && nums[i + k + 1] >= nums[i + k]) {
                    isValid = false;
                    break;
                }
            }
            //if conditions met count++
            if (isValid) {
                count++;
            }
        }

        return count;
    }
}

//TC : O(n x m)
//SC : O(1)