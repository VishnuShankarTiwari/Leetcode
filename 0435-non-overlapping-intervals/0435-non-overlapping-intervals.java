class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a,b) -> a[1] - b[1]);

        //count no overlapping in sorted array 
        int count = 1;
        int lastEndIdx = intervals[0][1];
        for(int i=1; i<n; i++){
            if(intervals[i][0] >= lastEndIdx){
                count++;
                lastEndIdx = intervals[i][1];
            }
        }

        //return total - count of nonoverlapping
        return n -count;
    }
}

//TC : O(nlogn + n)
//SC : O(1)