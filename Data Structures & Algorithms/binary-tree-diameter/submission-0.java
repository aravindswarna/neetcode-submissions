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
    int ans = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        dm(root);
        return ans == 0? 0: ans-1;

    }

    public int dm(TreeNode root){
        if(root == null) return 0;
        int lc = dm(root.left);
        int rc = dm(root.right);
        ans = Math.max(ans, lc+rc+1);
        return Math.max(lc, rc)+1;
    }
}
