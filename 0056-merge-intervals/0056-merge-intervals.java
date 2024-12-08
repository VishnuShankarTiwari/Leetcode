class Solution {
    public int[][] merge(int[][] intervals) {
        //check if intervals length is 0 
       if(intervals.length == 0) return new int[0][0];
        int n = intervals.length;
        ArrayList<int[]> list = new ArrayList<>();
        
        //sort intervals on start
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        //comparing the last idx of curr to first idx of interval[i][0]
        int[] curr = intervals[0];
        for(int i=1; i<n; i++){
            if(curr[1] < intervals[i][0]){
                list.add(curr);
                curr = intervals[i];
            }else{
                //maximize the current 
                curr[1] = Math.max(curr[1], intervals[i][1]);
            }
        }
        list.add(curr);
        

        //converting list to array
        int[][] result = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}

//TC : O(n + nlogn)
//SC : O(n)