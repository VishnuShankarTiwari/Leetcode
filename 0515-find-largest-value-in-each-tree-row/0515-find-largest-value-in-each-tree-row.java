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
    public List<Integer> largestValues(TreeNode root) {
        if(root == null) return new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> res = new ArrayList<>();

        //BFS
        q.add(root);

        while(!q.isEmpty()){
            int n = q.size();
            int max = Integer.MIN_VALUE;

           for(int i=0; i<n; i++){
            TreeNode curr = q.poll();
            max = Math.max(max, curr.val);

            if(curr.left != null) q.add(curr.left);
            if(curr.right != null) q.add(curr.right);
           }

            res.add(max);
        }

        return res;
    }
}

//TC : O(n)
//SC : O(1)