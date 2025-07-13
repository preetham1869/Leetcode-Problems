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
    TreeNode newroot= null;
    TreeNode curr=null;
    public void inorder(TreeNode root){
        if(root==null)return;
        inorder(root.left);
        if(newroot==null){
            newroot=new TreeNode(root.val);
            curr=newroot;
        }
        else{
            curr.right= new TreeNode(root.val);
            curr=curr.right;
        }
        inorder(root.right);
    }
    public TreeNode increasingBST(TreeNode root) {
        newroot=null;
        curr=null;
        inorder(root);
        return newroot;
    }
}