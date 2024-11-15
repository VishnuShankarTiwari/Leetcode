// A KIND OF BRUTE FORCE IN BINARY SEARCH

//we first move from 0 and find left till where the array is non-decreasing
//then move from backward to find right till where the array is non-increasing 
//if left > right return 0 as as  whole array is sorted
//otherwise we we again iterate from 0 to right till either l <= left(above one) 
//and r should be less than array length, and arr[l] become greater than arr[r]
//simultaneously find the min of res and r-l-1
//return res


class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        int left = 0;
        int right = n - 1;

        while(left+1 < n && arr[left] <= arr[left+1]) left++;
        while(right-1 >= 0 && arr[right-1] <= arr[right]) right--;

        if(left >= right) return 0;
        int res = right, l = 0, r = right;

        while(l <= left){        
            while(r < n && arr[r] < arr[l]) r++;
            res = Math.min(res, r-l-1);
            l++;
        }
        return res;
    }
}

// TC: O(N)
// SC: O(1)