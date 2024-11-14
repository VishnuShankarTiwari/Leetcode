//BINARY SEARCH

// we find the maxQuantity
//traverse from 0 to maxQuantity and find the minimum number of distribution to a specific store
//we check what could be the number of stores required if we want to exhaust out all product from quantities and we gradually increase if its not possible and number of store comes under n we perform binary search


class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int m = quantities.length;
        int maxQuantity =0;

        for(int quantity : quantities){
            maxQuantity = Math.max(maxQuantity, quantity);
        }

        int left = 0;
        int right = maxQuantity;
        int ans = m;

        while(left <= right){
            int mid = (left + right) / 2;

            if(isPossible(n, quantities, mid)){
                ans = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        
        return ans;
    }

    private boolean isPossible(int n, int[] quantities, int maxLimit){
        int numOfStoreRequired = 0;

        for(int quantity : quantities){
            numOfStoreRequired += Math.ceil((quantity * 1.0) / maxLimit);
        }
        return (numOfStoreRequired <= n);
    }
}

//TC : O(nlogx)
//SC : O(1)