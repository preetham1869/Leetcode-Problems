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
    private long maxi = 0;
    private long totalSum = 0;
    private long TS(TreeNode root) {
        if (root == null) return 0;
        return root.val + TS(root.left) + TS(root.right);
    }
    private long dfs(TreeNode root) {
        if (root == null) return 0;
        long left = dfs(root.left);
        long right = dfs(root.right);
        long subTreeSum = root.val + left + right;
        maxi = Math.max(maxi, subTreeSum * (totalSum - subTreeSum));
        return subTreeSum;
    }
    public int maxProduct(TreeNode root) {
        totalSum = TS(root);
        dfs(root);
        return (int)(maxi % 1000000007);
    }
}
