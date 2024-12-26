class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for(int i = 0; i < n - 3; i++){
            //skip duplicates for i
            if(i > 0 && nums[i] == nums[i - 1]) continue;

            for(int j = i + 1; j < n - 2; j++){
                //skip duplicates for j
                if(j > i + 1 && nums[j] == nums[j - 1]) continue;

                long req = (long) target - ( (long) nums[i] + (long) nums[j]);
                int low = j + 1;
                int high = n - 1;

                while(low < high){
                    long sum = (long) nums[low] + (long) nums[high];
                    if(sum == req){
                        res.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high]));
                        
                        //skip duplicates for low & high
                        while(low < high && nums[low] == nums[low + 1]) low++;
                        while(low < high && nums[high] == nums[high - 1]) high--;

                        low++;
                        high--;
                    }else if(sum < req){
                        low++;
                    }else{
                        high--;
                    }
                }
            }
        }

        return res;
    }
}

//TC : O(nlogn + n x n²) --> O(n³)
//SC : O(k) --> number of uniquq quadruples