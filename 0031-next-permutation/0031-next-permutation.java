class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;

        //finding the pivot
        int pivot = -1;
        for (int i = n - 2; i >= 0; i--){
            if (nums[i] < nums[i + 1]){
                pivot = i;
                break;
            }
        }

        //if pivot does not exist, reverse the entire array to get the smallest arrangement
        if (pivot == -1){
            reverse(nums, 0, n - 1);
            return;
        }

        //swap pivot with the next greater element in idx greater than pivot
        for (int i = n - 1; i > pivot; i--){
            if (nums[i] > nums[pivot]){
                swap(nums, i, pivot);
                break;
            }
        }

        //reverse all elements from pivot + 1 to n - 1
        reverse(nums, pivot + 1, n - 1);
    }

    //helper function for swap
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    //helper function for reverse using swap function
    public void reverse(int[] nums, int start, int end){
        while (start < end){
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}

//TC : O(3n)
//SC : O(1)
