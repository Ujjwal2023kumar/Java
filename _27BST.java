import java.util.*;
public class _27BST {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
        }
    }
    public static Node insert(Node root, int val){
        if(root == null){
            root = new Node(val);
            return root;
        }
        if(root.data > val){
            // left subtree
            root.left = insert(root.left, val);
        }else{
            // right subtree
            root.right = insert(root.right, val);
        }
        return root;
    }
    public static void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
    public static boolean search(Node root, int key){
        if(root == null){
            return false;
        }
        if(root.data == key){
            return true;
        }
        if(key < root.data){
            return search(root.left, key);
        }else{
            return search(root.right, key);
        }  
    }
    public static Node delete(Node root, int val){
        if(root.data < val){
            root.right = delete(root.right, val);
        }else if(root.data > val){
            root.left = delete(root.left, val);
        }else{
            //Case 1 : leaf node
            if(root.left == null && root.right == null){
                return null;
            }
            //Case 2 : single child
            if(root.left == null){
                return root.right;
            }else if(root.right == null){
                return root.left;
            }
            //Case 3 : both children
            Node IS = findInorderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, val);
        }
        return root;
    }

    public static Node findInorderSuccessor(Node root){
        while(root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static void printInRange(Node root, int k1, int k2){
        if(root == null){
            return;
        }
        if(k1 <= root.data && root.data <= k2){
            printInRange(root.left, k1, k2);
            System.out.print(root.data + " ");
            printInRange(root.right, k1, k2);
        }else if(root.data < k1){
            printInRange(root.left, k1, k2);
        }else{
            printInRange(root.right, k1, k2);
        }
    }
    public static void printPath(ArrayList<Integer> path){
        for(int i = 0; i< path.size(); i++){
            System.out.print(path.get(i) + "->");
        }
        System.out.println("Null");
    }
    public static void printRoot2Leaf(Node root, ArrayList<Integer> path){
        if(root == null) {
          return;  
        }
        path.add(root.data);
        if(root.left == null && root.right == null){
            printPath(path);
        }
        printRoot2Leaf(root.left, path);
        printRoot2Leaf(root.right, path);
        path.remove(path.size()-1);
    }
    public static boolean isValidBST(Node root, Node min, Node max){
        if(root == null){
            return true;
        }
        if(min != null && root.data <= min.data){
            return false;
        }else if(max != null && root.data >= max.data){
            return false;
        }
        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }
    public static Node mirrorBST(Node root){
        if(root == null){
            return null;
        }
        Node leftSubtree = mirrorBST(root.left);
        Node rightSubtree = mirrorBST(root.right);

        root.left = rightSubtree;
        root.right = leftSubtree;

        return root;
    }
    public static Node balancedBST(int arr[], int st, int end){
        if(st > end){
            return null;
        }
        int mid = (st + end)/2;
        Node root = new Node(arr[mid]);
        root.left = balancedBST(arr, st, mid - 1);
        root.right = balancedBST(arr, mid + 1, end);

        return root;
    }
    public static void main(String[] args) {
        //Binary Search Tree

        //Build binary search tree
        System.out.print("Building BST: ");
        int values[] = {5,1,3,4,2,7};
        Node root = null;

        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }
        inorder(root);
        System.out.println();

        //search key in binary search tree
        System.out.print("Search key in BST: ");
        if(search(root, 2)){
            System.out.println("Key Found");
        }else{
            System.out.println("Key Not Found");
        }

        //delete node in binary search tree
        System.out.print("Delete Node in BST: ");
        root = delete(root, 1);
        inorder(root);
        System.out.println();

        //print in range in binary search tree
        System.out.print("Print in range in BST: ");
        printInRange(root, 1, 5);        
        System.out.println();

        //print path in binary search tree
        System.out.print("Print from root to leaf in BST: ");
        printRoot2Leaf(root, new ArrayList<>());

        //Is Valid binary search tree
        System.out.print("Is Valid BST: ");
        if(isValidBST(root, null, null)){
            System.out.println("Valid BST");
        }else{
            System.out.println("Invalid BST");
        }
        
        //Mirror BST
        System.out.print("Mirror of BST: ");
        mirrorBST(root);
        inorder(root);
        System.out.println();

        //Sorted Array to Balanced BST
        System.out.print("Sorted Array to Balanced BST: ");
        int arr[] = {3,5,6,8,10,11,12};
        Node root1 = balancedBST(arr, 0, arr.length-1);
        inorder(root1);

        //Convert BST into balanced BST
        
    }
}
