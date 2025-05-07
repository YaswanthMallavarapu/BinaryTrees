//method 1
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public static boolean findLCS(TreeNode root, ArrayList<TreeNode> path, TreeNode target) {
        if (root == null)
            return false;
        path.add(root);
        if (root == target)
            return true;
        if ((findLCS(root.left, path, target)) || (findLCS(root.right, path, target)))
            return true;
        path.remove(path.size() - 1);
        return false;

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> path1 = new ArrayList<>();
        ArrayList<TreeNode> path2 = new ArrayList<>();
        findLCS(root, path1, p);
        findLCS(root, path2, q);
        int trace1 = 0;
        int trace2 = 0;
        int i = 0;
        while (i < path1.size() && i < path2.size() && path1.get(i) == path2.get(i))
            i++;
        return (i > 0) ? path1.get(i - 1) : null;
    }
}

// method 2
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q)
            return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null)
            return right;
        else if (right == null)
            return left;
        else
            return root;
    }
}