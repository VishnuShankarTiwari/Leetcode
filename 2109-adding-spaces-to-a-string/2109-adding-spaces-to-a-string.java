class Solution {
    public String addSpaces(String s, int[] spaces) {
        //stringbuilder to insert space
        StringBuilder sb = new StringBuilder(s);

        //counter to add indexes
        int i = 0;
        for(int idx : spaces){
            
            //insert spaces
            sb.insert(idx + i, " ");
            i++;
        }

        return sb.toString();
    }
}

//TC : O(n x m)
//SC :O(1)