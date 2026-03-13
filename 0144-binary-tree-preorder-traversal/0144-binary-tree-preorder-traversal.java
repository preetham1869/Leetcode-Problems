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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        preorderNew(root,ans);
        return ans;
    }
    private void preorderNew(TreeNode node, List<Integer> ans){
        if(node==null)return;
        ans.add(node.val);
        preorderNew(node.left,ans);
        preorderNew(node.right,ans);
    }
}