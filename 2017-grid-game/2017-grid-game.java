class Solution {
    public long gridGame(int[][] grid) {
        int n = grid[0].length;
        long[] preTop = new long[n+1];
        long[] preBottom = new long[n+1];

        //precompute prefix sums for top and bottom rows
        for(int i=0; i<n; i++){
            preTop[i+1] = preTop[i] + grid[0][i];
            preBottom[i+1] = preBottom[i] + grid[1][i];
        }

        long result = Long.MAX_VALUE;

        //iterate through all possible drop points
        for(int i=0; i<n; i++){
            long ptTop = preTop[n] - preTop[i+1];
            long ptBottom = preBottom[i];
            long maxPtSecRbt = Math.max(ptTop, ptBottom);
            result = Math.min(result, maxPtSecRbt);
        }

        return result;
    }
}

//TC : O(n)
//SC : O(n)