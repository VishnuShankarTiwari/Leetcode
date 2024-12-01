class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        //minPrice initialization
        int minPrice = prices[0];
        int maxProfit = 0;
        for(int i=1; i<n; i++){
            //current profit
            int profit = prices[i] - minPrice;
            //maxProfit updation
            maxProfit = Math.max(maxProfit, profit);
            //minPrice updation
            minPrice = Math.min(minPrice, prices[i]);
        }

        return maxProfit;
    }
}

// TC : O(n)
// SC : O(1)