import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.tree.TreeNode;

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
 * https://leetcode.com/problems/find-mode-in-binary-search-tree/description/
 */
class Solution {
    private Map<Integer, Integer> modes = new HashMap();

    public int[] findMode(TreeNode root) {
        // dfs filling the modes data structure O(n)
        // sort array and return the higher elements O(nlogn) ---- loop throught array to find higher O(n)
            // if +two elements has same mode, return all

        List<Integer> higherModes = new ArrayList<>();
        Integer higher = 0;

        dfs(root); // O(n)

        for(Map.Entry<Integer,Integer> entry : modes.entrySet()) { // O(n)
            if (entry.getValue() >= higher) {
                if (higherModes.size() > 0 &&
                modes.get(higherModes.get(0)) < entry.getValue()) {
                    higherModes.clear();
                }

                higherModes.add(entry.getKey());
                higher = entry.getValue();
            }
        }

        return higherModes.stream().mapToInt(Integer::intValue).toArray(); //O(n)
    }

    private void dfs(TreeNode root) {
        // do a normal dfs
        if (root == null) {
            return;
        }

        // mount modes map
        Integer mode = modes.get(root.val);
        if (mode != null) {
            modes.put(root.val, ++mode);
        } else {
            modes.put(root.val, 1);
        }

        dfs(root.left);
        dfs(root.right);
    }
}