class Solution {
    public int maxScore(String s) {
        int n = s.length();

        //we will do in single iteration
        //we will maximize zeros on left - ones on left 
        //result will be max Difference + total ones

        int ones = 0;
        int zeros = 0;
        int maxDiff = Integer.MIN_VALUE;

        for(int i=0; i<n-1; i++){
            if(s.charAt(i) == '0') zeros++;
            else ones++;

            maxDiff = Math.max(maxDiff, zeros - ones);
        }
        if(s.charAt(n-1) == '1') ones++;

        return maxDiff + ones;
    }
}

//TC : O(n)
//SC : O(1)