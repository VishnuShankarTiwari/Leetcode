//DP DP MEMOIZATION




//if n <= 1, we return n
//we take array dp with -1 at all element, if we check if dp[n] not equal to -1 then we return it 
// otherwise we store the recursive value n-1 + n-1 at dp[n]

class Solution {
    int[] dp;
    public int fib(int n) {
        if(n <= 1) return n;
        dp = new int[n+1];
        Arrays.fill(dp, -1);

        return helper(n);
    }

    public int helper(int n){
        if(n <= 1) return n;

        if(dp[n] != -1) return dp[n];

        dp[n] = helper(n-1) + helper(n-2);

        return dp[n];
    }
}

// TC: O(n)
// SC: O(n)