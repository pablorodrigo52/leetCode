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
 * Two approaches, a DFS and BFS implementations.
 * DFS -> Time complexity O(N) - linear on amount of nodes
 * DFS -> Space complexity O(N) - linear on recursive stack size 
 * BFS -> Time complexity O(N) - linear on amount of nodes
 * BFS -> Space complexity O(N + M) - where M is Queue size 
 */
class Solution {

    public int maxDepth(TreeNode root) {
        return dfs(root, 0);
    }


    public int dfs(TreeNode root, int depth) {
        if (root == null) {
            return 0;
        }
        
        int left = dfs(root.left, depth++);
        int right = dfs(root.right, depth++);

        return Math.max(left, right) + 1;
    }


    public int bfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> toVisit = new LinkedList<>();
        int depth = 0;

        toVisit.add(root);

        while(!toVisit.isEmpty()) {
            depth++;
            int nodeCount = toVisit.size();

            for (int i = 0; i < nodeCount; i++) {
                TreeNode visited = toVisit.poll();
                
                if (visited.left != null) {
                    toVisit.add(visited.left);
                }

                if (visited.right != null) {
                    toVisit.add(visited.right);
                }
            }
        }

        return depth;
    }
}