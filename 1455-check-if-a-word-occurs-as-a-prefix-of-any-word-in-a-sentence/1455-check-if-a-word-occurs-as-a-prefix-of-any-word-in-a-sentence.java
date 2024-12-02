//TWO POINTER WITHOOT BUILT-IN METHOD

class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        int n = sentence.length(); 
        int m = searchWord.length();
        int idx = 1;
        int i = 0;
        int j = 0;
        while(i < n){
            //remove leading space if any
            while(i<n && sentence.charAt(i) == ' ') i++;

            //compare words
            while(i<n && j<m && sentence.charAt(i) == searchWord.charAt(j)){
                i++;
                j++;
            }
            
            if(j == m) return idx;
            j=0;

            //search next space
            while(i<n && sentence.charAt(i) != ' ') i++;

            //move to next word
            i +=1;
            idx++;
        }

        return -1;
    }
}