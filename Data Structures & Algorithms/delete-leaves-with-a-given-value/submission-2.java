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
        return rem(root, target);
    }

    public TreeNode rem(TreeNode root, int target){
        if(root == null) return null;
        root.left = rem(root.left, target);
        root.right = rem(root.right, target);
        if(root.val == target && root.left == null && root.right ==null){
            return null;
        }
        return root;

    }
}