import java.util.Arrays;

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
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        // can we just do a binary search on nums and mount the tree O(n)

        if (nums.length == 1) return new TreeNode(nums[0]);
        if (nums.length == 0) return null;

        int middle = nums.length / 2;

        TreeNode root = new TreeNode(nums[middle]);
        root.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, middle));
        root.right = sortedArrayToBST(Arrays.copyOfRange(nums, middle+1, nums.length));

        return root;
    }
}