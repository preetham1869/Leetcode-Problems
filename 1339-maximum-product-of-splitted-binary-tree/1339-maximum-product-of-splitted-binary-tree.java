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
    private long maxi=0,totalSum=0;
    private long TS(TreeNode root) {
        if (root == null)
            return 0;
        return root.val + TS(root.left) + TS(root.right);
    }
    private long dfs(TreeNode root){
        if(root==null)return 0;
        long subTreeSum=root.val+dfs(root.left)+dfs(root.right);
        long pro=subTreeSum*(totalSum - subTreeSum);
        if(pro>maxi)maxi=pro;
        return subTreeSum;
    }
    public int maxProduct(TreeNode root) {
        totalSum=TS(root);
        dfs(root);
        return(int)(maxi%1000000007);
    }
}