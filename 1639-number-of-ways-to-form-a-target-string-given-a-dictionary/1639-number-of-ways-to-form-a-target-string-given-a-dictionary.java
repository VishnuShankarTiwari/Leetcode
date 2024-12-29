class Solution {
    
    int MOD = 1000000007;

    public int numWays(String[] words, String target) {
        int wordLen = words[0].length();
        int targetLen = target.length();
        int charFreq[][] = new int[wordLen][26];
        

        for(String word : words){
            for(int i=0; i<word.length(); i++){
                int charIdx = word.charAt(i) - 'a';
                charFreq[i][charIdx]++;
            }
        }
        
        long dp[][] = new long[wordLen+1][targetLen+1];
        for(int i=0; i<wordLen+1; i++){
            Arrays.fill(dp[i], -1);
        }
        
        return (int) recur(0, 0, charFreq, target, words, dp);
    }

    //recursion call and memoized result
    long recur(int wordIdx, int targetIdx, int charFreq[][], String target, String words[], long[][] dp){
        if(targetIdx == target.length()){
            dp[wordIdx][targetIdx] = 1;
            return 1;
        }
        if(wordIdx == words[0].length()){
            dp[wordIdx][targetIdx] = 0;
            return 0;
        }
        if(target.length() - targetIdx > words[0].length() - wordIdx){
            dp[wordIdx][targetIdx] = 0;
            return 0;
        }

        if(dp[wordIdx][targetIdx] != -1) return dp[wordIdx][targetIdx];

        int currIdx = target.charAt(targetIdx) - 'a';
        int freq = charFreq[wordIdx][currIdx];

        long pick = freq * recur(wordIdx+1, targetIdx+1, charFreq, target, words, dp);
        long noPick = recur(wordIdx+1, targetIdx, charFreq, target, words, dp);

        long res = (pick + noPick) % MOD;
        dp[wordIdx][targetIdx] = res;
        return res;
    }
}

//TC : O(n x m) + O(n x t)
//SC : O(m x 26) + O(m x t)