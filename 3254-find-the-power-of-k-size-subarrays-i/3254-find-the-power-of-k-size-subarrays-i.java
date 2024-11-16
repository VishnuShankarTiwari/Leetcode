// DEQUE IN SLIDING WINDOW APPROACH

//we take a deque and array 
//we always work on idx in deque
//remove the element if window size > k
//if elements are not consecutive and ordered then we remove from deque
//add to deque last idx
// if all conditions satisfy then we add last element to array else add -1 
// return array


class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n-k+1];
        Deque<Integer> dq = new ArrayDeque<>();

        for(int i=0; i<n; i++){
            if(!dq.isEmpty() && dq.peekFirst() <= i-k){
                dq.pollFirst();
            }

            while(!dq.isEmpty() && nums[dq.peekLast()] != nums[i] -1){
                dq.pollLast();
            }

            dq.offerLast(i);
            if(i >= k-1){
                if(dq.size() == k) res[i-k+1] = nums[dq.peekLast()];
                else res[i-k+1] = -1;
            }
        }
        return res;
    }
}



// TC: O(N)
// SC : O(N)