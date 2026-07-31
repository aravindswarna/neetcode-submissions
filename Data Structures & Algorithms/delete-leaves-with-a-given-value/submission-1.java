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
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if(rem(root, target)) return null;
        else return root;
    }

    public boolean rem(TreeNode root, int target){
        if(root == null) return true;
        boolean l = rem(root.left, target);
        boolean r = rem(root.right, target);
        if(l) root.left = null;
        if(r) root.right = null;
        return root.val == target && root.left == null && root.right ==null;

    }
}