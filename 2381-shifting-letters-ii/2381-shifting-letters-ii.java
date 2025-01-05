class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] arr = new int[n];

        //Using line sweep algorithm

        for(int[] shift : shifts){
            if(shift[2] == 1){
                arr[shift[0]]++;
                if(shift[1] + 1 < n){
                    arr[shift[1] + 1]--;
                }
            }
            else{
                arr[shift[0]]--;
                if(shift[1] + 1 < n){
                    arr[shift[1] + 1]++;
                }
            }
        }

        StringBuilder res = new StringBuilder(s);
        int sum = 0;
        for(int i=0; i<n; i++){
            sum = (sum + arr[i]) % 26;
            if(sum < 0) sum += 26;
            char shiftedChar = (char) ('a' + ((s.charAt(i) - 'a' + sum) % 26));
            res.setCharAt(i, shiftedChar);
        }

        return res.toString();
    }
}

//TC : O(n + m)
//SC : O(n + m)