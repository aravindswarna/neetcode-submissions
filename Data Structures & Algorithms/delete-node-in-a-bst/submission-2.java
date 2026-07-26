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
    public TreeNode deleteNode(TreeNode root, int key) {
        
        if(root == null) return null;

        TreeNode parent = null;
        TreeNode curr = root;
        while(curr != null && curr.val != key){
            parent = curr;
            if(curr.val > key){
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
        if(curr == null || curr.val != key) return root;
        System.out.println(curr.val);

        if(curr.left != null && curr.right != null){
            TreeNode min = curr.right;
            TreeNode prev = curr;
            while(min != null && min.left != null){
                prev = min;
                min = min.left;
            }
            curr.val = min.val;
            curr = min;
            parent = prev;
        }
        
        TreeNode child = curr.left == null ? curr.right: curr.left;
        if(parent == null){
            return child;
        }
        if(parent.left == curr){
            parent.left = child;
        } else {
            parent.right = child;
        }

        return root;

    }
}