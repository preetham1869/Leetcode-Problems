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
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> res= new ArrayList<>();
        inOrderTraversal(root,res);
        return buildBalancedBST(res, 0, res.size()-1);
    }
    void inOrderTraversal(TreeNode node,List<Integer> res){
        if(node==null) return;
        inOrderTraversal(node.left,res);
        res.add(node.val);
        inOrderTraversal(node.right,res);
    }
    TreeNode buildBalancedBST(List<Integer> res,int left,int right){
        if(left>right)return null;
        int mid=(left+right)/2;
        TreeNode node=new TreeNode(res.get(mid));
        node.left=buildBalancedBST(res,left,mid-1);
        node.right=buildBalancedBST(res,mid+1,right);
        return node;
    }
}