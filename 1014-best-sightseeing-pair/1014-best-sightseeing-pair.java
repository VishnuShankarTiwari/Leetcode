class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int n = values.length;
        int max = 0;
        int score = 0;

        for(int j=1; j<n; j++){
            //calculating the max
            max = Math.max(values[j-1] + j-1, max);

            //Calculating the score
            score = Math.max(score, max + values[j] - j);
        }

        return score;
    }
}

//TC : O(n)
//SC : O(1)