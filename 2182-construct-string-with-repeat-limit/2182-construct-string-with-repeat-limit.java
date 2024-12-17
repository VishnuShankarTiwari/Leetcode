class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] freq = new int[26];
        for(char ch : s.toCharArray()){
            freq[ch - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        int idx = 25;
        while(idx >= 0){
            if(freq[idx] ==0){
                idx--;
                continue;
            }

            int used = Math.min(freq[idx], repeatLimit);
            for(int k=0; k<used; k++){
                sb.append((char) ('a' + idx));
            }
            freq[idx] -= used;

            if(freq[idx] > 0){
                int prevIdx = idx - 1;
                while(prevIdx >= 0 && freq[prevIdx] == 0){
                    prevIdx--;
                }
                if(prevIdx < 0){
                    break;
                }
                sb.append((char) ('a' + prevIdx));
                freq[prevIdx]--;
            }
        }

        return sb.toString();
    }
}

//TC : O(2n)
//SC : O(1)