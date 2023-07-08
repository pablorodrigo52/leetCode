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
 *  Time complexity O(n) = O(left half + right half) + O(loop array comparing values)
 *  Space complexity has a additional data structure to storage visited values ) O(n + (m + l)) where m + l = n
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (root.left == null && root.right == null) {
            return true;
        }

        if (root.left == null || root.right == null) {
            return false;
        }

        List<Integer> visitedLeftValues = new ArrayList<>();
        List<Integer> visitedRightValues = new ArrayList<>();

        DFSLeft(root.left, visitedLeftValues); //preorder
        DFSRight(root.right, visitedRightValues); // postorder

        // compare two visited arrays;
        if (visitedLeftValues.size() != visitedRightValues.size()) {
            return false;
        }

        for (int i = 0; i < visitedLeftValues.size(); i++) {
            if (visitedLeftValues.get(i) != visitedRightValues.get(i)) {
                return false;
            }
        }

        return true;
    }

    private void DFSLeft(TreeNode node, List<Integer> visited) {
        visited.add(node.val);

        if (node.left != null) {
            DFSLeft(node.left, visited);
        } 
        visited.add(null); // flag to indicate if has null on left and root on right

        if (node.right != null) {
            DFSLeft(node.right, visited);
        }
    }

    private void DFSRight(TreeNode node, List<Integer> visited) {
        visited.add(node.val);

        if (node.right != null) {
            DFSRight(node.right, visited);
        }
        visited.add(null); // flag to indicate if has null on right and root on left

        if (node.left != null) {
            DFSRight(node.left, visited);
        }
    }
}