class Solution {
    public int maxScore(String s) {
        int n = s.length();

        //count ones and and in next iteration we simultaneously add the ones and zero in both partition while maximizing the result
        int ones = 0;
        for(int i=0; i<n; i++){
            if(s.charAt(i) == '1') ones++;
        }

        int res = 0;
        int zeros = 0;
        for(int i=0; i<n-1; i++){
            if(s.charAt(i) == '0') zeros++;
            else ones--;

            res = Math.max(res, ones+zeros);
        }

        return res;
    }
}

//TC : O(2n)
//SC : O(1)