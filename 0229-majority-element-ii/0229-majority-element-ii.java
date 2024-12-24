class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int req = (int) (n/3) + 1;

        for(int i=0; i<n; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if(map.get(nums[i]) == req){
                res.add(nums[i]);
            }
            if(res.size() == 2) break;
        }

        Collections.sort(res);
        return res;
    }
}

//TC : O(n)
//SC : O(n)