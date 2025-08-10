import java.util.ArrayList;
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

    //Function to find elemennt on kth level of a tree
    public static void kLevel(Node root1, int level, int k){
        if(root1 == null){
            return;
        }
        if(level == k){
            System.out.print(root1.data + " ");
            return;
        }
        kLevel(root1.left, level+1, k);
        kLevel(root1.right, level+1, k);
    }

    //Function to find lowest common ancestor
    public static boolean getPath(Node root, int n, ArrayList<Node> path){
        if(root == null){
            return false;
        }
        path.add(root);
        if (root.data == n) {
            return true;
        }

        boolean foundLeft = getPath(root.left, n, path);
        boolean foundRight = getPath(root.right, n, path);

        if(foundLeft || foundRight){
            return true;
        }

        path.remove(path.size()-1);
        return false;
    }
    public static Node lca1(Node root, int n1, int n2){
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        getPath(root, n1, path1);
        getPath(root, n2, path2);

        // last common ancestor
        int i = 0;
        for(; i < path1.size() && i < path2.size(); i++){
            if(path1.get(i) != path2.get(i)) {
                break;
            }
        }

        //last equal node 
        Node lca = path1.get(i-1);
        return lca;
    }

    //Function to find lowest common ancestor (Optimized Approach)
    public static Node lca2(Node root, int n1, int n2){
        
        if(root == null || root.data  == n1 || root.data == n2){
            return root;
        }

        Node leftLca = lca2(root.left, n1, n2);
        Node rightLca = lca2(root.right, n1, n2);

        if(rightLca == null) {
            return leftLca;
        }
        if(leftLca == null) {
            return rightLca;
        }

        return root;
    }

    //Function to find minimum distance between 2 nodes
    public static int lcaDist(Node root, int n){
        if(root == null){
            return -1;
        }
        if(root.data == n){
            return 0;
        }
        int leftDist = lcaDist(root.left, n);
        int rightDist = lcaDist(root.right, n);

        if(leftDist == -1 && rightDist == -1){
            return -1;
        }else if(leftDist == -1){
            return rightDist+1;
        }else{
            return leftDist+1;
        }
    }
    public static int minDist(Node root, int n1, int n2){
        Node lca = lca2(root, n1, n2);
        int dist1 = lcaDist(lca, n1);
        int dist2 = lcaDist(lca, n2);
        return dist1 + dist2;
    }

    //Function to find Kth ancestor of Node
    public static int KAncestor(Node root, int n, int k){
        if(root == null){
            return -1;
        }
        if(root.data == n){
            return 0;
        }

        int leftDist = KAncestor(root.left, n, k);
        int rightDist = KAncestor(root.right, n, k);

        if(leftDist == -1 && rightDist == -1){
            return -1;
        }

        int max = Math.max(leftDist, rightDist);
        if(max+1 == k){
            System.out.println(root.data);
        }
        return max+1;
    }

    //Function Transform to Sum Tree
    public static int transform(Node root){
        if(root == null){
            return 0;
        }
        int leftChild = transform(root.left);
        int rightChild = transform(root.right);

        int data = root.data;
        int newLeft = root.left == null ? 0 : root.left.data;
        int newRight = root.right == null ? 0 : root.right.data;
        root.data = newLeft + leftChild + newRight + rightChild;
        
        return data;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

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


        System.out.print("Kth Level of a tree: ");
        int k = 3;
        kLevel(root, 1, k);
        System.out.println();


        System.out.print("Lowest Common Ancestor: ");
        int n1 = 4, n2 = 5;
        System.out.println(lca1(root, n1, n2).data);

        System.out.print("Lowest Common Ancestor (Optimized): ");
        System.out.println(lca2(root, n1, n2).data);

        System.out.print("Minimum Distance between 2 Nodes: ");
        System.out.println(minDist(root, n1, n2));

        System.out.print("Kth ancestor of Node: ");
        KAncestor(root,5,2);

        System.out.print("Transform to Sum Tree: ");
        transform(root);
        BinaryTree.preorder(root);
    }
}
