class Solution {
    public String addSpaces(String s, int[] spaces) {
        int n = s.length();
        int m = spaces.length;

        //stringbuilder to insert space
        StringBuilder sb = new StringBuilder();

        //counter to add space at index in string at spaces[i]
        int i = 0;
        
        for(int idx=0; idx<n; idx++){
            
            //if idx is within spaces then append space
            if(i < m && spaces[i] == idx){
                sb.append(" ");
                i++;
            }

            //append last left over string
            sb.append(s.charAt(idx));    
        }
        

        return sb.toString();
    }
}

//TC : O(n + m)
//SC :O(1)