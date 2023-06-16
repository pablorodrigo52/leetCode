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
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode actualNode = root;

        if (actualNode.val == val) {
            return root;
        }

        if (root.left != null) {
            actualNode = searchBST(root.left, val);

            if (actualNode != null) {
                return actualNode;
            }
        } 
        
        if (root.right != null) {
            actualNode = searchBST(root.right, val);

            if (actualNode != null) {
                return actualNode;
            }
        }

        return null;
    }
}