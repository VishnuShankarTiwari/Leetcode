class Solution {
    public int minimizeXor(int num1, int num2) {
        int count = Integer.bitCount(num2);

        int x = 0;

        for(int i=31; i>=0 && count>0; i--){
            if((num1 & (1 << i)) != 0){
                x |= (1 << i);
                count--;
            }
        }

        for(int i=0; i<=31 && count>0; i++){
            if((x & (1 << i)) == 0){
                x |= (1 << i);
                count--;
            }
        }

        return x;

    }
}

//TC : O(2 x 32)
//SC : O(1)