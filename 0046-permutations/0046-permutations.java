class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        //calling helper function
        helper(nums, res, 0);

        return res;
    }

    private void helper(int[] nums, List<List<Integer>> res, int idx){
        if(idx == nums.length){
            //list of integer to store current permutation
            List<Integer> list = new ArrayList<>();

            //adding one by one elements to list
            for(int i : nums){
                list.add(i);
            }

            //adding one permutation to result of all permutations
            res.add(list);
            return;
        }
        
        //recursive call to helper and swaping to get next permutation
        for(int i=idx; i<nums.length; i++){
            swap(nums, i, idx);
            helper(nums, res, idx+1);
            swap(nums, i, idx);
        }
    }

    //swap function
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

//TC : O(n x n!)
//SC : O(n)