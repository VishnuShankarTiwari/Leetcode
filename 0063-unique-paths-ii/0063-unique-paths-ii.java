// DP DP  STORAGE OPTIMIZATION

// we are using 1d dp array to store the previous subproblem ans as we only need previous row
// use another temporary array  to store the same row and after evaluation thrn transfer them to prev after evaluation of the current row
//if grid is marked 1 we just simply return 0
// else if we reach the end return 1


class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[] prev = new int[n];
        Arrays.fill(prev, 0);

        for(int i=0; i<m; i++){
            int[] temp = new int[n];
            Arrays.fill(temp, 0);

            for(int j=0; j<n; j++){
                if(obstacleGrid[i][j] == 1) temp[j] = 0;
                else if(i == 0 && j == 0) temp[j] = 1;
                else{
                    int up = 0, left  = 0;
                    if(i>0) up = prev[j];
                    if(j>0) left = temp[j-1];
                    temp[j] = up + left;
                }
            } 
            prev = temp;
        }
        return prev[n-1];
    }
}

// TC : O(N x M)
// SC : (N x M)