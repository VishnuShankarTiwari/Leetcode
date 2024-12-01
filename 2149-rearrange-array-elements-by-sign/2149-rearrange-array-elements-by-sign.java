class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;

        //separate positive and negatives from nums
        //create  positive and negative array
        int[] pos = new int[n/2];
        int[] neg = new int[n/2];
        
        //separation of pos & neg
        int x = 0, y = 0;
        for(int i : nums){
            
            if(i >= 0){
                pos[x++] = i; 
            }else{
                neg[y++] = i;
            }
        }

        //copy back positives to nums
        for(int i=0; i<n/2; i++){
            nums[i*2] = pos[i];
        }

        //copy back negatives to nums
        for(int i=0; i<n/2; i++){
            nums[2*i + 1] = neg[i];
        }

        return nums;
    }
}

// TC : O(2n)
// SC : O(n)