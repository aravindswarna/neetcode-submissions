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


/*
    [-15,10,20,null,null,15,5,-5]
    [-15,10,20,null,null,15,5,-5,-6]

*/
class Solution {
    int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        
        if(root == null) return 0;
        maxPathSum1(root);
        return ans;
    }

    public int maxPathSum1(TreeNode root) {
        
        if(root == null) return 0;

        int ml = maxPathSum1(root.left);
        int rl = maxPathSum1(root.right);
        int temp = root.val;
        
        temp = Math.max(temp, ml+rl+root.val);
        temp = Math.max(temp, ml+root.val);
        temp = Math.max(temp, rl+root.val);
        ans = Math.max(ans, temp);
        int ret = Math.max(ml+root.val, rl+root.val);
        return Math.max(ret, root.val);
    }
}
