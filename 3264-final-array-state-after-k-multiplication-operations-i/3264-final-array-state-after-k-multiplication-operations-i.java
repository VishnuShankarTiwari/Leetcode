class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        int n = nums.length;

        //brute force 
        while(k > 0){

            //finding min and idx
            int min = nums[0];
            int idx = 0;
            for(int i=1; i<n; i++){
                if(nums[i] < min){
                    min = nums[i];
                    idx = i;
                }
            }

            //replacing min element to min * multiplier
            nums[idx] *= multiplier;
            k--;
        }

        return nums;
    }
}

//TC : O(nk)
//SC : O(1)