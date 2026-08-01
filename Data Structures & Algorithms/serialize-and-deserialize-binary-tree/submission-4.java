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

public class Codec {

    StringBuilder sb = new StringBuilder();
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null){
            sb.append("#,");
            return null;
        }
        sb.append(root.val);
        sb.append(",");
        serialize(root.left);
        serialize(root.right);
        return sb.toString();
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null) return null;
        System.out.println(data);
        return construct(data.split(","));
    }
    int i = 0;
    public TreeNode construct(String[] arr){
        if(i>= arr.length || arr.length == 0) return null;
       if(arr[i].equals("#")){
        i++;
        return null;
       }
       TreeNode node = new TreeNode(Integer.parseInt(arr[i++]));
       node.left = construct(arr);
       node.right = construct(arr);
       return node;

    }
}
