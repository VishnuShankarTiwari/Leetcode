class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        HashSet<Integer> set = new HashSet<>();
        
        //insert the banned element to set
        for(int i : banned) set.add(i);

        int sum = 0;
        int count = 0;
        for(int i=1; i<=n; i++){
            //skip the banned element
            if(set.contains(i)) continue;

            //if not banned add to sum
            sum += i;

            //if sum becomes greater than maxSum then we don't take and break;
            if(sum > maxSum) break;
            count++;
        }

        return count;
    }
}

//TC : O(m + n*c) --> c is constant
//SC : O(n) --> set 