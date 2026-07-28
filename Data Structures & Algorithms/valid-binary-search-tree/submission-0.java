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
    public boolean isValidBST(TreeNode root) {
       int[] prev = new int[]{Integer.MIN_VALUE}; 
       return isValidBST(root,prev);
        
        
    }

    public boolean isValidBST(TreeNode root, int[] prev) {
        
        if(root == null) return true;
        boolean ans = true;
        boolean left1 = isValidBST(root.left, prev);
        ans = ans && prev[0] < root.val;
        System.out.println(prev[0]+"--"+root.val);
        prev[0] = root.val; 
        boolean right = isValidBST(root.right, prev);
        ans = ans && left1 && right;
        return ans;
        
    }
}
