/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int data;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int val) { data = val; left = null, right = null }
 * }
 **/

class Solution {
    public static void findPaths(TreeNode root, List<List<Integer>> paths, List<Integer> path) {
        if (root == null)
            return;
        path.add(root.data);
        if (root.left == null && root.right == null) {
            paths.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            return;
        }
        findPaths(root.left, paths, path);
        findPaths(root.right, paths, path);
        path.remove(path.size() - 1);
        return;
    }

    public List<List<Integer>> allRootToLeaf(TreeNode root) {
        // your code goes here
        List<List<Integer>> paths = new ArrayList<>();
        findPaths(root, paths, new ArrayList<>());
        return paths;
    }
}