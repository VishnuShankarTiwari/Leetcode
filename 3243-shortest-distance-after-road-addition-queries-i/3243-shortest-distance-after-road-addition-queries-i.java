// BFS BFS

// we use bfs traversal in graph to find the shortest distance instead of djikshtra due to time complexity
// use visited set to mark visited and upon addition we mark visited any node

class Solution {

    private List<List<Integer>> graph;

    private int bfs(int n){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        int distance = 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-->0){
                int node = queue.poll();
                if(node == n-1) return distance;
                for(int neighbor : graph.get(node)){
                    if(!visited.contains(neighbor)){
                        queue.add(neighbor);
                        visited.add(neighbor);
                    }
                }
            }
            distance++;
        }
        return -1;
    }

    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        graph = new ArrayList<>();
        for(int i=0; i<n; i++) graph.add(new ArrayList<>());
        for(int i=0; i<n-1; i++) graph.get(i).add(i+1);

        int k = queries.length;
        int[] res = new int[k];

        for(int i=0; i<k; i++){
            graph.get(queries[i][0]).add(queries[i][1]);
            res[i] = bfs(n);
        }

        return res;
    }
}

//TC : O(q x ((n + q))
//SC : O(n + q)