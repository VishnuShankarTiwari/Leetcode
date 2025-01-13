class Solution {
    public int minimumLength(String s) {
        int n = s.length();

        int[] freq = new int[26];
        for(int i=0; i<n; i++){
            freq[s.charAt(i) - 'a']++;
        }

        int res = 0;
        for(int i=0; i<26; i++){
            if(freq[i] > 0){
                if(freq[i] % 2 == 0){
                    res += 2;
                }
                else{
                    res++;
                }
            }
        }

        return res;
    }
}

//TC : O(n + 26)
//SC : O(26)