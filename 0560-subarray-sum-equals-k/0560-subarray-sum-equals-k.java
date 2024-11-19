// Using map to store the value of occurence
// we use prefix sum but with a variable because we don't need the whole array
// check for currPrefixSum - k to be equal to value in map.
// if found add to res;

class Solution {
    public int subarraySum(int[] nums, int k) {
       int res = 0;
        int curr = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for(int i : nums){
            curr += i;
            res += map.getOrDefault(curr - k, 0);
            map.put(curr, map.getOrDefault(curr, 0) + 1);
        }
        
        return res;
    }
}

//TC : O(N)
//SC : O(N)