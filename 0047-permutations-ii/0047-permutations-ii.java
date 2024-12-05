class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backTrack(res, new ArrayList<>(), nums, new boolean[nums.length]);
        return res;
    }

    private void backTrack(List<List<Integer>> res, List<Integer> list, int[] nums, boolean[] flag){

        //if we match the length, it is a permutation if not stored earlier
        if(list.size() == nums.length && !res.contains(list)){
            res.add(new ArrayList<>(list));
            return;
        }

        for(int i=0; i<nums.length; i++){

            //skip if we get the same element
            if(flag[i]) continue;

            //add the new element
            flag[i] = true;
            list.add(nums[i]);

            //go back to try other element
            backTrack(res, list, nums, flag);

            //remove the element and mark it as false
            flag[i] = false;
            list.remove(list.size() - 1);
        }
    }
}

//TC : O(n! x n)
//SC : O(2n) --> stack space and boolean array space