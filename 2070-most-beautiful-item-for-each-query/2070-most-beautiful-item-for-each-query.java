//    STATIC   QUERY PRECOMPUTATION 


//sort items based on price
//store queries to 2d integer array along with their respective index
//sort 2d queries array
//iterate on 2d queries array and find maxBeautyPrefix
//simultaneously check the item price lessthan 2d queries price if less than then
//store in answer array at query index from 2d query
//return answer


class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        int n = items.length;
        int qn = queries.length;
        int[] ans = new int[qn];
        Arrays.sort(items, (a, b) -> a[0] - b[0]);

        int[][] indexedQueries = new int[qn][2];
        for(int i=0; i<qn; i++){
            indexedQueries[i][0] = queries[i];
            indexedQueries[i][1] = i;
        }

        Arrays.sort(indexedQueries, (a, b) -> a[0]- b[0]);
        
        int itemIndex = 0;
        int maxBeautyPrefix = 0;
        for(int i=0; i<qn; i++){
            int queryPrice = indexedQueries[i][0];
            int queryIndex = indexedQueries[i][1];
    
            while(itemIndex < items.length && items[itemIndex][0] <= queryPrice){
                maxBeautyPrefix = Math.max(maxBeautyPrefix, items[itemIndex][1]);
                itemIndex++;
            }
            ans[queryIndex] = maxBeautyPrefix;
        }
        return ans;
    }
}


//TC : O(2qn + nlogn + qlogq) => O(NlogN)
//SC : O(qn)