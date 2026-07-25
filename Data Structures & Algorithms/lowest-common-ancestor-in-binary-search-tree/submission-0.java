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
    TreeNode ans = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        lca(root, p, q);
        return ans;    
    }

    public int lca(TreeNode root, TreeNode p, TreeNode q){
        if(root == null) return -1;

        int l = lca(root.left, p, q);
        int r = lca(root.right, p, q);
        System.out.println(root +"--"+p+"--"+q+"--"+root.val+"--"+p.val+"--"+q.val+"--"+l+"--"+r);

        if(root.val == p.val && (l == 0 || r == 0)){
            ans = ans == null ? p : ans;
        } else if( root.val == q.val && (l == 0 || r == 0)){
            ans = ans == null ? q : ans;
        } else if(l == 0 && r == 0) {
             ans = ans == null ? root : ans;
        }
        if(root.val == p.val || root.val == q.val || l == 0 || r == 0) return 0;
        return -1;
    }
}
