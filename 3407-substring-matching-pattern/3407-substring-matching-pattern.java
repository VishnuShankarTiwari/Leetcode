class Solution {
    public boolean hasMatch(String s, String p) {

        int n = s.length();
        int m = p.length();
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        int j = 0;

        //finding the substring before and after the *
        while(p.charAt(j) != '*'){
            s1.append(p.charAt(j));
            j++;
        }
        j++;

        while(j < m){
            s2.append(p.charAt(j));
            j++;
        }

        String prefix = s1.toString();
        String suffix = s2.toString();

        int m1 = prefix.length();
        int m2 = suffix.length();

        for(int i=0; i<n; i++){
            if(m1 == 0 || (n-i >= m1 && s.substring(i, i + m1).equals(prefix))){
                if(m2 == 0) return true;
                for(int k=i+m1; k<n; k++){
                    if((n-k >= m2 && s.substring(k, k + m2).equals(suffix))) return true;
                }
            }
        }   
        return false;    
    }
}

//TC : O(m + n²)
//SC : O(m)