class Solution {
    public boolean doesValidArrayExist(int[] derived) {

        int n = derived.length;
        return check(derived, 0) || check(derived, 1);
    }

    private boolean check(int[] derived, int start){
        int n = derived.length;
        int[] original = new int[n];
        original[0] = start;

        for(int i=1; i<n; i++){
            original[i] = original[i-1] ^ derived[i-1];
        }

        return (original[n-1] ^ original[0]) == derived[n-1];
    }
}

//TC : O(n)
//SC : O(n)