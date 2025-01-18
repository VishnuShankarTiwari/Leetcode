class Solution {

    private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Deque<int[]> deque = new ArrayDeque<>();
        int[][] cost = new int[m][n];
        for(int[] row : cost) Arrays.fill(row, Integer.MAX_VALUE);
        
        deque.offer(new int[]{0, 0});
        cost[0][0] = 0;

        while (!deque.isEmpty()) {
            int[] curr = deque.pollFirst();
            int x = curr[0], y = curr[1];

            for(int i=0; i<4; i++){
                int nx = x + DIRECTIONS[i][0], ny = y + DIRECTIONS[i][1];
                if(nx >= 0 && ny >= 0 && nx < m && ny < n){
                    int newCost = cost[x][y] + (grid[x][y] == i + 1 ? 0 : 1);
                    if(newCost < cost[nx][ny]){
                        cost[nx][ny] = newCost;
                        if(grid[x][y] == i + 1){
                            deque.offerFirst(new int[]{nx, ny});
                        }
                        else{
                            deque.offerLast(new int[]{nx, ny});
                        }
                    }
                }
            }
        }

        return cost[m-1][n-1];
    }
}

//TC : O(m x n)
//SC : O(m x n)