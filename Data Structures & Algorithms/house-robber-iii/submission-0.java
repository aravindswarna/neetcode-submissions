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
    public int rob(TreeNode root) {
        
       return Math.max(rob(root, false), rob(root, true));


    }
     Map<TreeNode, Integer> trueMap = new HashMap<>();
     Map<TreeNode, Integer> falseMap = new HashMap<>();
     public int rob(TreeNode root, boolean curr) {
        
        if(root == null) return 0;

        if(curr){ 
         if(trueMap.containsKey(root)){
            return trueMap.get(root);
         }
        } else if(falseMap.containsKey(root)){    
            return falseMap.get(root);
        }

        int rVal = 0;
        int lValP = 0;
        int rValP = 0;
        int lValNP = 0;
        int rValNP = 0;
        if(curr){
             rVal+=root.val;
             lValNP = rob(root.left, false);
             rValNP = rob(root.right, false);
             trueMap.put(root, (rVal + lValNP+ rValNP));
            return rVal + lValNP+ rValNP;
        } else {
             int ans = Math.max(rob(root.left, true), rob(root.left, false))
     + Math.max(rob(root.right, true), rob(root.right, false));
        falseMap.put(root, ans);
        return ans;
        }
    }
}