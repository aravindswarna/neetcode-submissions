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
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> list = new ArrayList<>();
        if(root == null) return list;
        TreeNode dummy = new TreeNode();
        Deque<TreeNode> Q = new ArrayDeque<>();
        Q.addLast(root);
        Q.addLast(dummy);
        List<Integer> level = new ArrayList<>();
        while(!Q.isEmpty()){
            TreeNode node = Q.removeFirst();
            if(node != dummy){
                level.add(node.val);
            } else {
                list.add(level);
                level = new ArrayList<>();
                if(!Q.isEmpty()){
                    Q.addLast(dummy);
                }
            }
            if(node.left != null) Q.addLast(node.left);
            if(node.right != null) Q.addLast(node.right);
        }
        return list;
    }
}
