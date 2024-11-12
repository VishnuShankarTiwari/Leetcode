

class Solution {

    private int binarySearch(int[][] items, int target){
        int left = 0;
        int right = items.length -1;
        int ans = 0;

        while(left <= right){
            int mid = (left + right) / 2;
            if(items[mid][0] > target){
                right = mid-1;
            }else{
                ans = Math.max(ans, items[mid][1]);
                left = mid + 1;
            }
        }
        return ans;
    }


    public int[] maximumBeauty(int[][] items, int[] queries) {
        int n = items.length;
        int qn = queries.length;
        int[] ans = new int[qn];

        Arrays.sort(items, (a, b) -> a[0] - b[0]);
        int maxBeautyPrefix = items[0][1];
        for(int i=0; i<n; i++){
            items[i][1] = Math.max(maxBeautyPrefix, items[i][1]);
            maxBeautyPrefix = items[i][1];
        }

        for(int i=0; i<qn; i++){
            ans[i] = binarySearch(items, queries[i]);
        }
        return ans;
        
    }
}


//TC : O(n² + qn)
//SC : O(qn) / constant