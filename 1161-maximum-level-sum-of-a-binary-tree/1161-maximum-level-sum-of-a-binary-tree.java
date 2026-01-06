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
       q.offer(root);
       while(!q.isEmpty()){
        int l=q.size();
        int curr=0;
        while(l-->0){
            TreeNode node =q.poll();
            curr+=node.val;
            if(node.left!=null)q.offer(node.left);
            if(node.right!=null)q.offer(node.right);
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