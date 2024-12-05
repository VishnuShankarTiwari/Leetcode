class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int idx = m+n-1;
        int i = m-1;
        int j = n-1;

        //we will use the extra space in nums1  to sort and store the element of nums2 in nums1 to reduce the space complexity
        while(i >= 0 && j >= 0){
            //if nums1 element is greater than nums2 element then we store at last unoccupied position in nums1
            if(nums1[i] >= nums2[j]){
                nums1[idx--] = nums1[i--];
               
            }else{
                //nums1 element goes to last onoccupied position
                nums1[idx--] = nums2[j--];
            }    
        }

        //storing remaining elements of nums2 to nums1
        while(j >= 0){
            nums1[idx--] = nums2[j--];
        }
    }
}

//TC : O(m + n)
//SC : O(1)