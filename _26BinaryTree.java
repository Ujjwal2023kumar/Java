import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class _26BinaryTree {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    static class BinaryTree {
        static int idx = -1;

        public static Node buildTree(int[] nodes) {
            idx++;
            if (idx >= nodes.length || nodes[idx] == -1) {
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }

        public static void preorder(Node root) {
            if (root == null) return;
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }

        public static void inorder(Node root) {
            if (root == null) return;
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }

        public static void postorder(Node root) {
            if (root == null) return;
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }

        public static void levelorder(Node root) {
            if (root == null) return;

            Queue<Node> q = new java.util.LinkedList<>();
            q.add(root);
            q.add(null);

            while (!q.isEmpty()) {
                Node currNode = q.poll();
                if (currNode == null) {
                    System.out.println();
                    if (!q.isEmpty()) {
                        q.add(null);
                    }
                } else {
                    System.out.print(currNode.data + " ");
                    if (currNode.left != null) q.add(currNode.left);
                    if (currNode.right != null) q.add(currNode.right);
                }
            }
        }
    }
    public static int height(Node root){
        if(root == null){
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        return Math.max(lh, rh) + 1;
    }
    public static int countofNodes(Node root){
        if(root == null){
            return 0;
        }
        int lcount = countofNodes(root.left);
        int rcount = countofNodes(root.right);
        return lcount + rcount + 1;
    }

    public static int sumofNodes(Node root){
        if(root == null){
            return 0;
        }
        int lsum = sumofNodes(root.left);
        int rsum = sumofNodes(root.right);
        return lsum + rsum + root.data;
    }

    // Function to count number of nodes in the tree
    public static int countOfNodes(Node root) {
        if (root == null) {
            return 0;
        }
        int leftCount = countOfNodes(root.left);
        int rightCount = countOfNodes(root.right);
        return leftCount + rightCount + 1;
    }

    // Function to compute the diameter of the tree
    public static int diameter(Node root) {
        if (root == null) {
            return 0;
        }
        int leftDiameter = diameter(root.left);
        int rightDiameter = diameter(root.right);
        int leftHeight = countOfNodes(root.left);
        int rightHeight = countOfNodes(root.right);
        int selfDiameter = leftHeight + rightHeight + 1;

        return Math.max(selfDiameter, Math.max(leftDiameter, rightDiameter));
    }

    // Function to check if two trees are identical
    public static boolean isIdentical(Node node, Node subRoot) {
        if (node == null && subRoot == null) {
            return true;
        } else if (node == null || subRoot == null || node.data != subRoot.data) {
            return false;
        }

        return isIdentical(node.left, subRoot.left) && isIdentical(node.right, subRoot.right);
    }

    // Function to check if one tree is a subtree of another
    public static boolean isSubtree(Node root, Node subRoot) {
        if (root == null) {
            return false;
        }
        if (root.data == subRoot.data && isIdentical(root, subRoot)) {
            return true;
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    // Helper class to store node and its horizontal distance
    static class Info {
        Node node;
        int hd;

        public Info(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    // Function to print the top view of a binary tree
    public static void topView(Node root) {
        if (root == null) return;

        Queue<Info> q = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();
        int min = 0, max = 0;
        q.add(new Info(root, 0));

        while (!q.isEmpty()) {
            Info curr = q.remove();
            int hd = curr.hd;
            Node node = curr.node;

            if (!map.containsKey(hd)) {
                map.put(hd, node);
            }

            min = Math.min(min, hd);
            max = Math.max(max, hd);

            if (node.left != null) {
                q.add(new Info(node.left, hd - 1));
            }
            if (node.right != null) {
                q.add(new Info(node.right, hd + 1));
            }
        }

        for (int i = min; i <= max; i++) {
            System.out.print(map.get(i).data + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        Node root = BinaryTree.buildTree(nodes);

        System.out.println("Root Node: " + root.data);

        System.out.print("Preorder: ");
        BinaryTree.preorder(root);
        System.out.println();

        System.out.print("Inorder: ");
        BinaryTree.inorder(root);
        System.out.println();

        System.out.print("Postorder: ");
        BinaryTree.postorder(root);
        System.out.println();

        System.out.println("Level Order:");
        BinaryTree.levelorder(root);

        System.out.println("Height of Tree: " + height(root));
        System.out.println("No of Nodes: " + countofNodes(root));
        System.out.println("Sum of Nodes: " + sumofNodes(root));


        System.out.println("Diameter of Tree: " + diameter(root));

        Node subRoot = new Node(2);
        subRoot.left = new Node(4);
        subRoot.right = new Node(5);
        System.out.println("Is subtree: " + isSubtree(root, subRoot));

        System.out.print("Top View of Tree: ");
        topView(root);
    }
}
