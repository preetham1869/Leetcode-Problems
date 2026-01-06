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
    public int maxLevelSum(TreeNode root) {
       Queue<TreeNode> q = new LinkedList<>();
       int maxSL=1,maxS=root.val,currL=1;
       q.add(root);
       while(!q.isEmpty()){
        int l=q.size();
        int curr=0;
        while(l-->0){
            TreeNode node =q.remove();
            curr+=node.val;
            if(node.left!=null)q.add(node.left);
            if(node.right!=null)q.add(node.right);
        }
        if(maxS<curr){
            maxS=curr;
            maxSL=currL;
        }
        currL++;
       }
       return maxSL;
    }
}