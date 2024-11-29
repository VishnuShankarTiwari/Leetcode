class Solution {
    public int minimumTime(int[][] grid) {
        // next of top left, if greater than 1 traversal not possible
        if(grid[0][1] > 1 && grid[1][0] > 1) return -1;

        int m = grid.length, n = grid[0].length;
        int[][] dir = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        
        //visited array to mark visited
        boolean[][] vis = new boolean[m][n];
        
        //min heap to take out min everytime
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        pq.add(new int[]{0,0,0}); // add start point {time, row, col}

        while(!pq.isEmpty()){
            int[] currNode = pq.poll();
            
            // get the current time, row, col
            int time = currNode[0], currRow = currNode[1], currCol = currNode[2];

            // if last row, col return time
            if(currRow == m-1 && currCol == n-1) return time;

            //if visited continue or mark visited
            if(vis[currRow][currCol]) continue;
            vis[currRow][currCol] = true;

            for(int[] d : dir){
                //move to next all direction, find next row, col
                int nextRow = currRow + d[0], nextCol = currCol + d[1];

                //check valid next row, col
                if(nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n || vis[nextRow][nextCol]) continue;

                //flag value
                int cycleType = ((grid[nextRow][nextCol] - time) % 2 == 0) ? 1 : 0;
                
                //time = max(nextcell + flag, time + 1), add to pq
                pq.add(new int[]{Math.max(grid[nextRow][nextCol] + cycleType, time + 1), nextRow, nextCol});
            }
        }

        return -1;
    }
}

//TC : O(nm (log nm))
//SC : O(nm)