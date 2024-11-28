// 0-1 BFS


class Solution {
    public int minimumObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Directions for moving up, down, left, right
        int[][] dir = {
            {0, 1}, {1, 0}, {0, -1}, {-1, 0}
        };

        // Priority queue for 0-1 BFS
        Deque<int[]> deque = new ArrayDeque<>();

        // Distance array to store minimum obstacles removed to reach each cell
        int[][] dist = new int[m][n];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        // Starting from top-left corner
        deque.offer(new int[]{0, 0});
        dist[0][0] = 0;

        while (!deque.isEmpty()) {
            int[] current = deque.poll();
            int x = current[0];
            int y = current[1];

            // Explore all possible directions
            for (int[] d : dir) {
                int nx = x + d[0];
                int ny = y + d[1];

                // Check if new direction is within bounds
                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                    int newDist = dist[x][y] + grid[nx][ny];

                    // If shorter path is found, update the distance and add to deque
                    if (newDist < dist[nx][ny]) {
                        dist[nx][ny] = newDist;
                        if (grid[nx][ny] == 0) {
                            deque.offerFirst(new int[]{nx, ny}); // 0-cost move, add to front
                        } else {
                            deque.offerLast(new int[]{nx, ny}); // 1-cost move, add to back
                        }
                    }
                }
            }
        }

        // Return the minimum obstacles removed to reach the bottom-right corner
        return dist[m - 1][n - 1];
    }
}

//TC : O(4(m x n))
//SC : O(2(m x n))
