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
 * 
 * The idea is visit all nodes for each level before continue the loop.
 * Its like a tunning of my simple BFS.
 * 
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> toVisit = new LinkedList<>();
        toVisit.add(root);

        while(!toVisit.isEmpty()) {
            int height = toVisit.size();
            List<Integer> levelOrder = new ArrayList<>();

            for(int i = 0; i < height; i++) {
                TreeNode node = toVisit.poll();

                if (node != null) {
                    if (node.left!=null) {
                        toVisit.add(node.left);
                    }                

                    if (node.right != null) {
                        toVisit.add(node.right);
                    }

                    levelOrder.add(node.val);
                }
            }

            if (levelOrder.size() > 0) {
                res.add(levelOrder);
            }
        }

        return res;
    }
}