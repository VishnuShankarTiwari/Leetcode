//  DP DP TABULATION    SPACE OPTIMIZED

// using prev array to store previous results and fetch from there
// temp will store the  results of curr row and we can get the row -1 from temp;
// return prev[n-1]

class Solution {
    public int uniquePaths(int m, int n) {
        int[] prev = new int[n];
        Arrays.fill(prev, 0);

        for(int i=0; i<m; i++){
            int[] temp = new int[n];
            Arrays.fill(temp, 0);
            for(int j=0; j<n; j++){

                if(i == 0 && j == 0) temp[j] = 1;

                else{
                    
                    int up = 0, left = 0;
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

// TC: O(N X M)
// SC : O(2N)