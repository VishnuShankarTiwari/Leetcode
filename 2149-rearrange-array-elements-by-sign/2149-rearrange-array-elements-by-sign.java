class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;

        //create a new array and initialize neg & pos idx
        int[] arr = new int[n];
        int posIdx = 0;
        int negIdx = 1;

        //store to new array in asked fashion & maintain neg, pos idx
        for(int i=0; i<n; i++){
            if(nums[i] < 0){
                arr[negIdx] = nums[i];
                negIdx += 2;
            }else{
                arr[posIdx] = nums[i];
                posIdx += 2;
            }
        }

        return arr;
    }
}

// TC : O(n)
// SC : O(n)