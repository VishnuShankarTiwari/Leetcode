class Solution {
    public boolean canChange(String start, String target) {
        int n = start.length();
        int i = 0;
        int j = 0;
        
        while(i<n || j<n){
            //skip all blank in start
            while(i<n && start.charAt(i)=='_') i++;

            //skip all blank in target
            while(j<n && target.charAt(j)=='_') j++;

            //count is same only if both the string end at same time
            if(i==n || j==n) return (i==n && j==n);

            //check false scenario
            if(start.charAt(i) != target.charAt(j) ||
            (start.charAt(i) == 'L' && j > i) || 
            (start.charAt(i) == 'R' && j < i)
            ){
                return false;
            }

            i++;
            j++;
        }

        return true;
    }
}

//TC : O(2n)
//SC : O(n)