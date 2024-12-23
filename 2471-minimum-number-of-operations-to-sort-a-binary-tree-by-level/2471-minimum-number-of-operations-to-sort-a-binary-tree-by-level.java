/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int minimumOperations(TreeNode root) {

        //BFS
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int res = 0;

        while(!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for(int i=0; i<size; i++){
                TreeNode curr = queue.remove();
                list.add(curr.val);
                if(curr.left != null) queue.add(curr.left);
                if(curr.right != null) queue.add(curr.right);
            }

            //adding to the result
            res += minSwap(list);    
        }
        
        return res;
    }

    //helper function to count the swap
    private int minSwap(List<Integer> list){
        List<Integer> sorted = new ArrayList<>(list);
        Collections.sort(sorted);
        Map<Integer, Integer> pos = new HashMap<>();

        for(int i=0; i<sorted.size(); i++){
            pos.put(sorted.get(i), i);
        }

        int i=0;
        int swap = 0;
        while(i < list.size()){
            int idx = pos.get(list.get(i));
            if(idx == i) i++;
            else{
                int temp = list.get(i);
                list.set(i, list.get(idx));
                list.set(idx, temp);
                swap++;
            }
        }

        return swap;
    }
}

//TC : O(n + nlogn)
//SC : O(3n)
