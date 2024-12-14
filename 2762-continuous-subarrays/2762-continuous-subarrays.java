class Solution {
    public long continuousSubarrays(int[] nums) {
        int n = nums.length;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int start = 0;
        int end = 0;
        long count = 0;

        while(end < n){
            
            //expand the window
            map.put(nums[end], map.getOrDefault(nums[end], 0) + 1);
            
            //shrink the window
            while(map.lastEntry().getKey() - map.firstEntry().getKey() > 2){
                map.put(nums[start], map.get(nums[start]) - 1);
                
                //remove if freq = 0
                if(map.get(nums[start]) == 0){
                    map.remove(nums[start]);
                }
                
                start++;
            }

            count += (end - start) + 1;
            end++;
        }

        return count;
    }
}

//TC : O(n + nlogn)
//SC : O(n)