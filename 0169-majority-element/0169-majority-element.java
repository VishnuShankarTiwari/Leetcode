                    //Moore's Voting Algorithm//

//we take current element as curr, increases the count if curr found next
//or decrement the count if any other element is found 
//if count reaches 0; we take new element as curr;
//we are bound to get curr as majority, following this algo.


class Solution {
    public int majorityElement(int[] nums) {
        int curr = nums[0];
        int count = 1;

        for(int i=1; i<nums.length; i++){
            if(count == 0){
            curr = nums[i];
            count = 1;
            }
            else if(nums[i] == curr){
                count++;
            }
            else{
                count--;
            }
        }
        count = 0;
        for(int num : nums) {
            if(num == curr) {
                count++;
            }
        }

        return (count > nums.length / 2) ? curr : -1;
    }
}

// TC: O(N)
//SC : O(1)