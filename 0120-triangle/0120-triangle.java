//DP DP TABULATION TABULATION

//we take 2d dp array of size n x n
// we check base case, last row with all columns
//we try to start from n-1 to reach 0,0
//we evaluate for down and diagonal condition 
// take min of both, store in dp and return dp[0][0]


class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();

        int[][] dp = new int[n][n];

        for(int j=0; j<n; j++){
            dp[n-1][j] = triangle.get(n-1).get(j);
        }

        for(int i=n-2; i>=0; i--){
            for(int j=i; j>=0; j--){
                int down = triangle.get(i).get(j) + dp[i+1][j];
                int dia = triangle.get(i).get(j) + dp[i+1][j+1];

                dp[i][j] = Math.min(down, dia);
            }
        }

        return dp[0][0];
    }
}

// TC : O(n x n)
// SC : O(n x n)