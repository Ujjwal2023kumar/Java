public class _30Tries {
    static class Node {
        Node children[] = new Node[26];
        boolean eow = false; 
        Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }
    public static Node root = new Node();
    public static void insert(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }
    public static boolean search(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.eow;
    }
    public static boolean wordBreak(String key) {
        if (key.length() == 0) return true;
        for (int i = 1; i <= key.length(); i++) {
            String firstPart = key.substring(0, i);
            String secondPart = key.substring(i);
            if (search(firstPart) && wordBreak(secondPart)) {
                return true;
            }
        }
        return false;
    }
    public static boolean startsWith(String prefix) {
        Node curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            int idx = prefix.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return true;
    }
    public static int countNodes(Node root) {
        if (root == null) return 0;
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                count += countNodes(root.children[i]);
            }
        }
        return count + 1;
    }
    public static int uniqueSubstrings(String str) {
        Node tempRoot = new Node();
        root = tempRoot;
        for (int i = 0; i < str.length(); i++) {
            String suffix = str.substring(i);
            insert(suffix);
        }
        return countNodes(root) - 1; 
    }

    static String ans = "";
    public static void longestWord(Node root, StringBuilder temp) {
        if (root == null) return;
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null && root.children[i].eow) {
                temp.append((char)(i + 'a'));
                if (temp.length() > ans.length()) {
                    ans = temp.toString();
                }
                longestWord(root.children[i], temp);
                temp.deleteCharAt(temp.length()-1);
            }
        }
    }

    public static void main(String[] args) {
        String words[] = {"the", "a", "there", "their", "any", "thee"};
        for (String w : words) insert(w);

        System.out.println("Search 'the': " + search("the"));
        System.out.println("Search 'these': " + search("these"));

        String key = "ilikesamsung";
        String dict[] = {"i","like","sam","sung","samsung","mobile","ice"};
        for (String w : dict) insert(w);
        System.out.println("Can Word Break 'ilikesamsung'? " + wordBreak(key));

        System.out.println("StartsWith 'th': " + startsWith("th"));
        System.out.println("StartsWith 'tho': " + startsWith("tho"));

        String str = "ababa";
        System.out.println("Unique substrings in '" + str + "': " + uniqueSubstrings(str));

        String words2[] = {"a","ap","app","appl","apple","apply"};
        root = new Node();
        for (String w : words2) insert(w);
        longestWord(root, new StringBuilder(""));
        System.out.println("Longest Word with all Prefixes: " + ans);
    }
}
