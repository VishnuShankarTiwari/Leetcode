// we just remove all the underlying road under a bigger climbing node to minimize the distance

class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        TreeSet<Integer> set = new TreeSet<>();
        for(int i=0; i<n; i++){
            set.add(i);
        }

        int[] res = new int[queries.length];

        for(int i=0; i<queries.length; i++){
            int l = queries[i][0] + 1;
            int r = queries[i][1];
            removeNode(set, l, r);
            res[i] = set.size() - 1;
        }

        return res;
    }

    private void removeNode(TreeSet<Integer> set, int l, int r){
        List<Integer> remove = new ArrayList<>(set.subSet(l, true, r, false));
        set.removeAll(remove);
    }

}

// TC : O(qLogn + nLogn)
// SC : O(n)