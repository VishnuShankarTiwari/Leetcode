class Solution {
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int n = heights.length, m = queries.length;
        int[] ans = new int[m];
        Arrays.fill(ans, -1);
        Map<Integer, List<int[]>> map = new HashMap<>();
        
        // Processing queries
        for (int id = 0; id < m; id++) {
            int[] query = queries[id];
            int i = query[0], j = query[1];
            if (i < j && heights[i] < heights[j]) {
                ans[id] = j;
            } else if (i > j && heights[i] > heights[j]) {
                ans[id] = i;
            } else if (i == j) {
                ans[id] = i;
            } else {
                map.putIfAbsent(Math.max(i, j), new ArrayList<>());
                map.get(Math.max(i, j)).add(new int[] {Math.max(heights[i], heights[j]), id});
            }
        }
        
        // Processing the heights
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for (int id = 0; id < n; id++) {
            int curh = heights[id];
            // Pop from priority queue and update answers
            while (!pq.isEmpty() && pq.peek()[0] < curh) {
                ans[pq.poll()[1]] = id;
            }
            
            // Add new queries to priority queue
            if (map.containsKey(id)) {
                for (int[] p : map.get(id)) {
                    pq.offer(p);
                }
            }
        }
        
        return ans;
    }
}

//TC : O(qlogn)
//SC : O(n + q)