class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        int m = searchWord.length();
        //form an array
        String words[] = sentence.split(" ");
        int n = words.length;
        
        //search in words array if length greater than length of searchWord length
        for(int i=0; i<n; i++){
            if(words[i].length() >= m){

                //check substring of length searchWord length equals searchWord
                if(words[i].substring(0, m).equals(searchWord)){
                    return i+1; // return (1-based index)
                }
            }
        }

        return -1;
    }
}