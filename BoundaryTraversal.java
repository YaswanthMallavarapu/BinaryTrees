
// User function Template for Java
/*
class Node
{
    int data;
    Node left, right;

    public Node(int d)
    {
        data = d;
        left = right = null;
    }
}
*/

class Solution {
    public static boolean isLeaf(Node root) {
        return (root.left == null) && (root.right == null);
    }

    public static void leftboundary(Node root, ArrayList<Integer> result) {
        Node curr = root.left;
        while (curr != null) {
            if (!isLeaf(curr))
                result.add(curr.data);
            if (curr.left != null)
                curr = curr.left;
            else
                curr = curr.right;
        }
    }

    public static void leafnodes(Node root, ArrayList<Integer> result) {
        if (root == null)
            return;
        if (isLeaf(root)) {
            result.add(root.data);
            return;
        }
        leafnodes(root.left, result);
        leafnodes(root.right, result);
    }

    public static void rightboundary(Node root, ArrayList<Integer> result) {
        Node curr = root.right;
        Stack<Integer> st = new Stack<>();
        while (curr != null) {
            if (!isLeaf(curr))
                st.push(curr.data);
            if (curr.right != null)
                curr = curr.right;
            else
                curr = curr.left;
        }
        while (!st.isEmpty()) {
            result.add(st.pop());
        }
    }

    ArrayList<Integer> boundaryTraversal(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null)
            return result;
        if (!isLeaf(root))
            result.add(root.data);
        leftboundary(root, result);
        leafnodes(root, result);
        rightboundary(root, result);
        return result;
    }
}
