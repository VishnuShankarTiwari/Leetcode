class Solution {
    public String addBinary(String a, String b) {
        int n = a.length();
        int m = b.length();

        int i = 0;
        int carry  = 0;
        String res = "";

        //condition check for out of bound and carry not equal 1
        while(i < n || i < m || carry != 0){
            //initialize x to 0 and 1 if i=='1'  for addition
            int x = 0;
            if(i < n && a.charAt(n-i-1) == '1'){
                x = 1;
            }

            //initialize y to 0 and 1 if i=='1' for addition
            int y = 0;
            if(i < m && b.charAt(m-i-1) == '1'){
                y = 1;
            }

            //modulo to get 0 if addition result 2 and adding to start 
            res = (((x + y + carry) % 2 ) + res);

            //carry calculation by division 
            carry = (x + y + carry) / 2;
            i++;
        }

        return res;
    }
}

//TC : O(n)
//SC : O(1)