import java.util.*;

public class _27BST {
    static class Node {
        int data;
        Node left, right;
        Node(int data) { this.data = data; }
    }

    public static Node insert(Node root, int val) {
        if (root == null) return new Node(val);
        if (root.data > val) root.left = insert(root.left, val);
        else root.right = insert(root.right, val);
        return root;
    }

    public static void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static boolean search(Node root, int key) {
        if (root == null) return false;
        if (root.data == key) return true;
        return key < root.data ? search(root.left, key) : search(root.right, key);
    }

    public static Node delete(Node root, int val) {
        if (root == null) return null;
        if (root.data < val) root.right = delete(root.right, val);
        else if (root.data > val) root.left = delete(root.left, val);
        else {
            if (root.left == null && root.right == null) return null;
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            Node IS = findInorderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);
        }
        return root;
    }

    public static Node findInorderSuccessor(Node root) {
        while (root.left != null) root = root.left;
        return root;
    }

    public static void printInRange(Node root, int k1, int k2) {
        if (root == null) return;
        if (k1 <= root.data && root.data <= k2) {
            printInRange(root.left, k1, k2);
            System.out.print(root.data + " ");
            printInRange(root.right, k1, k2);
        } else if (root.data < k1) {
            printInRange(root.right, k1, k2);
        } else {
            printInRange(root.left, k1, k2);
        }
    }

    public static void printPath(ArrayList<Integer> path) {
        for (int val : path) System.out.print(val + "->");
        System.out.println("Null");
    }

    public static void printRoot2Leaf(Node root, ArrayList<Integer> path) {
        if (root == null) return;
        path.add(root.data);
        if (root.left == null && root.right == null) printPath(path);
        printRoot2Leaf(root.left, path);
        printRoot2Leaf(root.right, path);
        path.remove(path.size() - 1);
    }

    public static boolean isValidBST(Node root, Node min, Node max) {
        if (root == null) return true;
        if (min != null && root.data <= min.data) return false;
        if (max != null && root.data >= max.data) return false;
        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }

    public static Node mirrorBST(Node root) {
        if (root == null) return null;
        Node leftSubtree = mirrorBST(root.left);
        Node rightSubtree = mirrorBST(root.right);
        root.left = rightSubtree;
        root.right = leftSubtree;
        return root;
    }

    public static Node balancedBST(int arr[], int st, int end) {
        if (st > end) return null;
        int mid = (st + end) / 2;
        Node root = new Node(arr[mid]);
        root.left = balancedBST(arr, st, mid - 1);
        root.right = balancedBST(arr, mid + 1, end);
        return root;
    }

    public static void getInorder(Node root, ArrayList<Integer> inorder) {
        if (root == null) return;
        getInorder(root.left, inorder);
        inorder.add(root.data);
        getInorder(root.right, inorder);
    }

    public static Node createBST(ArrayList<Integer> inorder, int st, int end) {
        if (st > end) return null;
        int mid = (st + end) / 2;
        Node root = new Node(inorder.get(mid));
        root.left = createBST(inorder, st, mid - 1);
        root.right = createBST(inorder, mid + 1, end);
        return root;
    }

    public static Node bstToBalancedBST(Node root) {
        ArrayList<Integer> inorder = new ArrayList<>();
        getInorder(root, inorder);
        return createBST(inorder, 0, inorder.size() - 1);
    }

    static class Info {
        boolean isBST;
        int size, min, max;
        Info(boolean isBST, int size, int min, int max) {
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }

    public static int maxBST = 0;

    public static Info largestBST(Node root) {
        if (root == null) return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        Info leftInfo = largestBST(root.left);
        Info rightInfo = largestBST(root.right);

        int size = leftInfo.size + rightInfo.size + 1;
        int min = Math.min(root.data, Math.min(leftInfo.min, rightInfo.min));
        int max = Math.max(root.data, Math.max(leftInfo.max, rightInfo.max));

        if (leftInfo.isBST && rightInfo.isBST && root.data > leftInfo.max && root.data < rightInfo.min) {
            maxBST = Math.max(maxBST, size);
            return new Info(true, size, min, max);
        }
        return new Info(false, size, min, max);
    }

    public static Node merge2BST(Node root4, Node root5) {
        ArrayList<Integer> arr1 = new ArrayList<>();
        getInorder(root4, arr1);
        ArrayList<Integer> arr2 = new ArrayList<>();
        getInorder(root5, arr2);

        int i = 0, j = 0;
        ArrayList<Integer> finalArr = new ArrayList<>();
        while (i < arr1.size() && j < arr2.size()) {
            if (arr1.get(i) <= arr2.get(j)) finalArr.add(arr1.get(i++));
            else finalArr.add(arr2.get(j++));
        }
        while (i < arr1.size()) finalArr.add(arr1.get(i++));
        while (j < arr2.size()) finalArr.add(arr2.get(j++));
        return createBST(finalArr, 0, finalArr.size() - 1);
    }

    public static void main(String[] args) {
        int values[] = {5, 1, 3, 4, 2, 7};
        Node root = null;
        for (int val : values) root = insert(root, val);
        System.out.print("BST: "); inorder(root); System.out.println();

        System.out.println("Search 2: " + (search(root, 2) ? "Found" : "Not Found"));

        root = delete(root, 1);
        System.out.print("After Deletion: "); inorder(root); System.out.println();

        System.out.print("In Range 1-5: "); printInRange(root, 1, 5); System.out.println();

        System.out.println("Root to Leaf Paths:");
        printRoot2Leaf(root, new ArrayList<>());

        System.out.println("Valid BST? " + (isValidBST(root, null, null) ? "Yes" : "No"));

        System.out.print("Mirror: "); inorder(mirrorBST(root)); System.out.println();

        int arr[] = {3, 5, 6, 8, 10, 11, 12};
        System.out.print("Balanced from Sorted: "); inorder(balancedBST(arr, 0, arr.length - 1)); System.out.println();

        Node root2 = new Node(8);
        root2.left = new Node(6);
        root2.left.left = new Node(5);
        root2.left.left.left = new Node(3);
        root2.right = new Node(10);
        root2.right.right = new Node(11);
        root2.right.right.right = new Node(12);
        System.out.print("BST to Balanced: "); inorder(bstToBalancedBST(root2)); System.out.println();

        Node root3 = new Node(50);
        root3.left = new Node(30);
        root3.left.left = new Node(5);
        root3.left.right = new Node(20);
        root3.right = new Node(60);
        root3.right.left = new Node(45);
        root3.right.right = new Node(70);
        root3.right.right.left = new Node(65);
        root3.right.right.right = new Node(80);
        largestBST(root3);
        System.out.println("Largest BST size: " + maxBST);

        Node root4 = new Node(2);
        root4.left = new Node(1);
        root4.right = new Node(4);
        Node root5 = new Node(9);
        root5.left = new Node(3);
        root5.right = new Node(12);
        System.out.print("Merge 2 BSTs: "); inorder(merge2BST(root4, root5)); System.out.println();
    }
}
