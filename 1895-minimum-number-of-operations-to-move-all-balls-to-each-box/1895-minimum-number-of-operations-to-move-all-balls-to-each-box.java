class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        
        //we calculate number of operation from both sides fwd and bwd
        //then add up them to make answer array
        int[] left = new int[n];
        int[] right = new int[n];
        int[] res = new int[n];

        left[0] = 0;
        right[n-1] = 0;

        int count = boxes.charAt(0) - '0';
        for(int i=1; i<n; i++){
            left[i] = left[i-1] + count;
            count += boxes.charAt(i) - '0';
        }

        count = boxes.charAt(n-1) - '0';
        for(int i=n-2; i>=0; i--){
            right[i] = right[i+1] + count;
            count += boxes.charAt(i) - '0';
        }

        for(int i=0; i<n; i++){
            res[i] = left[i] + right[i];
        }

        return res;
    }
}

//TC : O(3n)
//SC : O(3n)