/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;
        boolean leftToRight = true;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                if (leftToRight) {
                    TreeNode node = queue.pollFirst();
                    level.add(node.val);
                    if (node.left != null)
                        queue.offerLast(node.left);
                    if (node.right != null)
                        queue.offerLast(node.right);
                } else {
                    TreeNode node = queue.pollLast();
                    level.add(node.val);
                    if (node.right != null)
                        queue.offerFirst(node.right);
                    if (node.left != null)
                        queue.offerFirst(node.left);
                }
            }
            result.add(level);
            leftToRight = !leftToRight;
        }
        return result;
    }
}