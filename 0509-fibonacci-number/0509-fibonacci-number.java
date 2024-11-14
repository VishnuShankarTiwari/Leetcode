//RECURSION   RECURSION 


//if n <= 1, we return n
// else recurse n-1 and n-2 in function and add them to form n th fibonacci and return in same way recursively

class Solution {
    public int fib(int n) {
        if(n <= 1) return n;

        return fib(n-1) + fib(n-2);
    }
}

// TC: (2^n)
// SC: O(n)