class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        if(n < 3 || nums == null) return new ArrayList<>();

        //sort the element
        Arrays.sort(nums);
        Set<List<Integer>> res = new HashSet<>();
        
        //now fix the first element and find the other two element
        for(int i=0; i<n-2; i++){
            int left = i+1;
            int right = n-1;

            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0){
                    //add to set and move to find the other triplets
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                }
                else if(sum < 0) left++;
                else right--;
            }
        }

        return new ArrayList<>(res);
    }
}

//TC : O(n²)
//SC : O(n)