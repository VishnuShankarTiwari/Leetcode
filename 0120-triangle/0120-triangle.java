//DP DP MEMOIZATION MEMOIZATION

//we take 2d dp array of size n x n with -1
//we check dp[i][j] before calling the recursion
//we try to start recursion from (0,0) and reach to last row(n-1) any column
//we write recursion  for down and diagonal condition 
// take min of both, store in dp and return


class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();

        int[][] dp = new int[n][n];
        for(int i=0; i<n; i++){
            Arrays.fill(dp[i], -1);
        }

        return helper(triangle, 0, 0, dp);
    }

    public int helper(List<List<Integer>> tri, int i, int j, int[][] dp){
        int n = tri.size();
        if(i == n-1) return tri.get(i).get(j);

        if(dp[i][j] != -1) return dp[i][j];

        int down = tri.get(i).get(j) + helper(tri, i+1, j, dp);
        int dia = tri.get(i).get(j) + helper(tri, i+1, j+1, dp);

        return dp[i][j] = Math.min(down, dia);
    }
}

// TC : O(n x n)
// SC : O(n x n) + O(n)