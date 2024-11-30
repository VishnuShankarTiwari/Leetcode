/// HEIRHOLZER ALGORITHM

class Solution {
    public int[][] validArrangement(int[][] pairs) {
        //create adjacency list and degree map
        Map<Integer, Deque<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> inDegree = new HashMap<>();
        Map<Integer, Integer> outDegree = new HashMap<>();

        //build the graph
        for(int[] pair : pairs){
            int start  = pair[0];
            int end = pair[1];
            graph.computeIfAbsent(start, k -> new ArrayDeque<>()).add(end);
            outDegree.put(start, outDegree.getOrDefault(start, 0) + 1);
            inDegree.put(end, inDegree.getOrDefault(end, 0) + 1);
        }

        //find the start node for Eulerian path
        int startNode = pairs[0][0];
        for(int node : outDegree.keySet()){
            if(outDegree.get(node) > inDegree.getOrDefault(node, 0)){
                startNode = node;
                break;
            }
        }

        //Heirholzer's Algorithme to find the Eulerian path
        List<int[]> result = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(startNode);

        while(!stack.isEmpty()){
            int node = stack.peek();
            if(graph.containsKey(node) && !graph.get(node).isEmpty()){
                stack.push(graph.get(node).poll());
            }else{
                stack.pop();
                if(!stack.isEmpty()){
                    result.add(new int[]{stack.peek(), node});
                }
            }
        }

        //reverse the result to get the correct order
        Collections.reverse(result);
        return result.toArray(new int[result.size()][]);
    }
}

//TC : O(2N + V)
//SC : O(3N + 2V)