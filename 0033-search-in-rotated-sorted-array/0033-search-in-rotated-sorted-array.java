class Solution {
    public int search(int[] nums, int target) {
        
        int low = 0;
        int high = nums.length - 1;
        
        //binary search, find the sorted part then target lies in this part else other part
        while(low <= high){
            int mid = (low + high)/2;
            if(nums[mid] == target) return mid;

            //identify the sorted half
            if(nums[low] <= nums[mid]){
                if(nums[low] <= target && target <= nums[mid]) high = mid - 1;
                else low = mid + 1;
            }else{
                if(nums[mid] <= target && target <= nums[high]) low = mid + 1;
                else high = mid - 1;
            }
        }

        //if target not found then return -1;
        return -1;
    }
}

//TC : O(nlogn)
//SC : O(1)