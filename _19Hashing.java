import java.util.*;

public class _19Hashing {

    // ---------------------- HashMap Problems ---------------------- //
    public static List<Integer> majorityElement(int arr[]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer> result = new ArrayList<>();
        for (Integer key : map.keySet()) {
            if (map.get(key) > arr.length / 3) {
                result.add(key);
            }
        }
        return result;
    }

    public static boolean isValidAnangram(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);   // FIX: earlier bug (was s.charAt(i))
            if (map.get(ch) != null) {
                if (map.get(ch) == 1) {
                    map.remove(ch);
                } else {
                    map.put(ch, map.get(ch) - 1);
                }
            } else {
                return false;
            }
        }
        return map.isEmpty();
    }

    public static String getStart(HashMap<String, String> tickets) {
        HashMap<String, String> revMap = new HashMap<>();
        for (String key : tickets.keySet()) {
            revMap.put(tickets.get(key), key);
        }
        for (String key : tickets.keySet()) {
            if (!revMap.containsKey(key)) {
                return key;
            }
        }
        return null;
    }

    // ---------------------- HashSet Problems ---------------------- //
    public static int countDistinctElement(int nums[]) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        return set.size();
    }

    public static int union(int arr1[], int arr2[]) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : arr1) set.add(i);
        for (int i : arr2) set.add(i);
        return set.size();
    }

    public static int intersection(int arr1[], int arr2[]) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : arr1) set.add(i);
        int count = 0;
        for (int i : arr2) {
            if (set.contains(i)) {
                count++;
                set.remove(i);
            }
        }
        return count;
    }

    // ---------------------- MAIN DEMONSTRATION ---------------------- //
    public static void main(String[] args) {

        // ================= HashMap =================
        System.out.println("=== HashMap Demo ===");
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("India", 150);
        hm.put("China", 100);
        hm.put("US", 50);
        hm.put("Japan", 25);
        System.out.println("HashMap: " + hm);
        System.out.println("Value of India: " + hm.get("India"));
        System.out.println("Contains India? " + hm.containsKey("India"));
        System.out.println("Keys: " + hm.keySet());
        for (String k : hm.keySet()) {
            System.out.println("Key: " + k + ", Value: " + hm.get(k));
        }
        hm.remove("Japan");
        System.out.println("After remove Japan: " + hm);
        System.out.println("Size: " + hm.size());
        hm.clear();
        System.out.println("Is empty: " + hm.isEmpty());

        // ================= LinkedHashMap =================
        System.out.println("\n=== LinkedHashMap Demo ===");
        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();
        lhm.put("India", 150);
        lhm.put("China", 100);
        lhm.put("US", 50);
        lhm.put("Japan", 25);
        System.out.println("LinkedHashMap (insertion order): " + lhm);

        // ================= TreeMap =================
        System.out.println("\n=== TreeMap Demo ===");
        TreeMap<String, Integer> tm = new TreeMap<>();
        tm.put("India", 150);
        tm.put("China", 100);
        tm.put("US", 50);
        tm.put("Japan", 25);
        System.out.println("TreeMap (sorted keys): " + tm);

        // ================= HashSet =================
        System.out.println("\n=== HashSet Demo ===");
        HashSet<Integer> set = new HashSet<>();
        set.add(1); set.add(2); set.add(4); set.add(2); set.add(1);
        System.out.println("HashSet: " + set);
        System.out.println("Iterating with Iterator:");
        Iterator<Integer> it = set.iterator();
        while (it.hasNext()) System.out.println(it.next());
        System.out.println("Iterating with for-each:");
        for (Integer i : set) System.out.println(i);
        System.out.println("Contains 2? " + set.contains(2));
        set.remove(2);
        System.out.println("After remove 2: " + set);
        System.out.println("Size: " + set.size());
        set.clear();
        System.out.println("Is empty: " + set.isEmpty());

        // ================= LinkedHashSet =================
        System.out.println("\n=== LinkedHashSet Demo ===");
        LinkedHashSet<String> lhs = new LinkedHashSet<>();
        lhs.add("Apple");
        lhs.add("Banana");
        lhs.add("Orange");
        lhs.add("Mango");
        System.out.println("LinkedHashSet (insertion order): " + lhs);
        lhs.remove("Banana");
        System.out.println("After remove Banana: " + lhs);

        // ================= TreeSet =================
        System.out.println("\n=== TreeSet Demo ===");
        TreeSet<Integer> ts = new TreeSet<>();
        ts.add(50); ts.add(20); ts.add(70); ts.add(10);
        System.out.println("TreeSet (sorted): " + ts);
        System.out.println("First element: " + ts.first());
        System.out.println("Last element: " + ts.last());
        System.out.println("HeadSet (<50): " + ts.headSet(50));
        System.out.println("TailSet (>=50): " + ts.tailSet(50));
        System.out.println("SubSet (20-70): " + ts.subSet(20, 70));

        // ================= Problems =================
        System.out.println("\n=== Hashing Problems ===");
        int arr[] = {1, 3, 2, 5, 1, 3, 1, 5, 1};
        System.out.println("Majority Element > n/3: " + majorityElement(arr));

        String s = "race", t = "care";
        System.out.println("Valid Anagram? " + isValidAnangram(s, t));

        int nums[] = {4,3,2,5,6,7,3,4,2,1};
        System.out.println("Distinct Elements: " + countDistinctElement(nums));

        int arr1[] = {7,3,9};
        int arr2[] = {6,3,9,2,9,4};
        System.out.println("Union: " + union(arr1, arr2));
        System.out.println("Intersection: " + intersection(arr1, arr2));

        HashMap<String, String> tickets = new HashMap<>();
        tickets.put("Chennai", "Bengaluru");
        tickets.put("Mumbai", "Delhi");
        tickets.put("Goa", "Chennai");
        tickets.put("Delhi", "Goa");
        String start = getStart(tickets);
        System.out.print("Itinerary: " + start);
        for (int i = 0; i < tickets.size(); i++) {
            System.out.print(" -> " + tickets.get(start));
            start = tickets.get(start);
        }
        System.out.println();

        int arr3[] = {15,-2,2,-8,1,7,10,23};
        HashMap<Integer, Integer> sumIdx = new HashMap<>();
        int sum = 0, len = 0;
        for (int j = 0; j < arr3.length; j++) {
            sum += arr3[j];
            if (sum == 0) len = j + 1;
            if (sumIdx.containsKey(sum)) {
                len = Math.max(len, j - sumIdx.get(sum));
            } else {
                sumIdx.put(sum, j);
            }
        }
        System.out.println("Largest subarray with sum 0: " + len);

        int arr4[] = {10,2,-2,-20,10};
        int k = -10;
        HashMap<Integer, Integer> sumCount = new HashMap<>();
        sumCount.put(0, 1);
        int sum1 = 0, ans = 0;
        for (int j = 0; j < arr4.length; j++) {
            sum1 += arr4[j];
            if (sumCount.containsKey(sum1 - k)) {
                ans += sumCount.get(sum1 - k);
            }
            sumCount.put(sum1, sumCount.getOrDefault(sum1, 0) + 1);
        }
        System.out.println("Subarrays with sum " + k + ": " + ans);
    }
}
