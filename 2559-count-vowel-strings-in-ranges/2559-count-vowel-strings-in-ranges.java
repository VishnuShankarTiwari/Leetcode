class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int m = queries.length;
        //prefix sum calculation
        int[] preSum = new int[n];
        preSum[0] = isVowel(words[0]);
        for(int i=1; i<n; i++){
            preSum[i] = preSum[i-1] + isVowel(words[i]);
        }

        //result calculation as res[i] = presum[r] - presum[l-1]
        int[] res = new int[m];
        for(int i=0; i<m; i++){
            int l = queries[i][0];
            int r = queries[i][1];

            int ans = preSum[r];
            if(l != 0){
                ans -= preSum[l-1];
            }

            res[i] = ans;
        }

        return res;
    }

    private int isVowel(String word){
        HashSet<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        
        char first = word.charAt(0);
        char last = word.charAt(word.length()-1);

        if(set.contains(first) && set.contains(last)){
            return 1;
        }

        return 0;
    }
}

//TC : O(n + m)
//SC : O(max(words[i].length))