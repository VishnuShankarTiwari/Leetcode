// SLIDING WINDOW APPROACH

// we use prefix sum
// deque to add  or remove at both end
//initialize min length with max value;
// checks the window sum is greater than equal to k, then take min of minlength or i-pollfirst idx
// we ensure deque only holds index of prefix sums in increasing order only
//add to last 
// return minlength, or -1 other wise


class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        int[] preSum = new int[n+1];

        for(int i=0; i<n; i++){
            preSum[i+1] = preSum[i] + nums[i];
        }

        Deque<Integer> dq = new LinkedList<>();
        int minLen = Integer.MAX_VALUE;

        for(int i=0; i<=n; i++){
            while(!dq.isEmpty() && preSum[i] - preSum[dq.peekFirst()] >= k){
                minLen = Math.min(minLen, i - dq.pollFirst());
            }
            while(!dq.isEmpty() && preSum[i] <= preSum[dq.peekLast()]){
                dq.pollLast();
            }

            dq.offerLast(i);
        }
        return minLen == Integer.MAX_VALUE ? -1 : minLen;
    }
}


//TC: O(n) + O(n) --> O(N)
//SC: O(n) + O(n) --> O(N)