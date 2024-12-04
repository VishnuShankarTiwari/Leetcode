class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        int i = 0, j = 0;

        //if string2 becomes greater than string1 then it is not possible
        if(m > n) return false;

        //iterate on both string using two pointers
        while(i < n && j < m){

            //condition checking
            if((str1.charAt(i) == str2.charAt(j)) ||
            (str1.charAt(i) == str2.charAt(j) - 1) ||
            (str1.charAt(i) == 'z' && str2.charAt(j) == 'a')
            ){
                //incrementing the pointer on string2 if condtions are met
                j++;
            }
            
            //otherwise always increment the pointer on string1
            i++;
        }
        
        //if pointer on string2 reaches outof bound we return
        return (j == m);
    }
}

//TC : O(MIN(n, m))
//SC : O(1)