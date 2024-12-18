class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] res = new int[n];

        //brute force;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(prices[j] <= prices[i]){
                    res[i] = prices[i] - prices[j];
                    break;
                }else{
                    res[i] = prices[i];
                }
            }
        }

        res[n-1] = prices[n-1];

        return res;
    }
}

//TC : O(n²)
//SC : O(n)