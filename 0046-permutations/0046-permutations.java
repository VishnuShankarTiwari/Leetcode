class Solution {
    public List<List<Integer>> permute(int[] nums) {
        //array list to return all permutations
        List<List<Integer>> res = new ArrayList<>();

        //calling back tracking function
        backTrack(res, new ArrayList<>(), nums);

        return res;
        
    }

    private void backTrack(List<List<Integer>> res, ArrayList<Integer> list, int[] nums){
        for(int i : nums){
            
            //if list length becomes same
            if(list.size() == nums.length){
                res.add(new ArrayList<>(list));
                return;
            }

            //skip element if already in list
            if(list.contains(i)) continue;

            //add the new element
            list.add(i);

            //backtrack to try out other element
            backTrack(res, list, nums);

            //remove the element
            list.remove(list.size() - 1);
        }
    }
}

//TC : O(n! x n)
//SC : O(n) --> stack space