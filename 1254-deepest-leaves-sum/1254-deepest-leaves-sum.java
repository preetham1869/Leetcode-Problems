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
    int sum = 0;
    public int height(TreeNode root){
        if(root==null)return 0;
        return 1+Math.max(height(root.left),height(root.right));
    }
    public void traverse(TreeNode root,int curr,int req){
        if (root == null) return;
        traverse(root.left,curr+1,req);
        if (curr==req){
            sum+=root.val;
        }
        traverse(root.right,curr+1,req);
    }
    public int deepestLeavesSum(TreeNode root) {
        int h = height(root);
        traverse(root,1,h);
        return sum;
    }
}