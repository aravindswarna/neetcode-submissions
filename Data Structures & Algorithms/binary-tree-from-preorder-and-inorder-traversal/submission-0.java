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
    Map<Integer, Integer> map = new HashMap<>();
    int pIdx = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int i = 0;
        for(int ele: inorder){
            map.put(ele, i++);
        }
        return con(preorder, 0, preorder.length-1);
    }
    public TreeNode con(int[] pre, int s, int e){
        if(s > e) return null;
        int ele = pre[pIdx++];
        TreeNode node = new TreeNode(ele);
        int idx = map.get(ele);
        node.left = con(pre, s, idx-1);
        node.right = con(pre, idx+1, e);
        return node;
    }


}
