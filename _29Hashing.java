import java.util.*;
public class _29Hashing {
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
    public static boolean isValidAnangram(String s, String t){
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            char ch = s.charAt(i);
            if(map.get(ch) != null){
                if(map.get(ch) == 1){
                    map.remove(ch);
                }else{
                    map.put(ch, map.get(ch)-1);
                }
            }else{
                return false;
            }
        }
        return map.isEmpty();
    }

    public static void main(String[] args) {

        // HashMap demonstration
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("India", 150);
        hm.put("China", 100);
        hm.put("US", 50);
        hm.put("Japan", 25);
        System.out.println("Hashmap: " + hm);
        System.out.println("Value of Key India: " + hm.get("India"));
        System.out.println("Is Key India contained: " + hm.containsKey("India"));

        Set<String> keys = hm.keySet();
        System.out.println(keys);
        for (String k : keys) {
            System.out.println("Key: " + k + ", Value: " + hm.get(k));
        }

        hm.remove("Japan");
        System.out.println("After removing Key Japan: " + hm);
        System.out.println("Size of Hashmap : " + hm.size());
        hm.clear();
        System.out.println("Is Hashmap empty: " + hm.isEmpty());
        System.out.println("Hashmap after clearing: " + hm);

        // LinkedHashMap - keys are inserted in order
        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();
        lhm.put("India", 150);
        lhm.put("China", 100);
        lhm.put("US", 50);
        lhm.put("Japan", 25);
        System.out.println("LinkedHashMap: " + lhm);

        // TreeMap - keys are ordered
        TreeMap<String, Integer> tm = new TreeMap<>();
        tm.put("India", 150);
        tm.put("China", 100);
        tm.put("US", 50);
        tm.put("Japan", 25);
        System.out.println("TreeMap: " + tm);

        // Majority Element > n/3
        System.out.print("Majority Element(s): ");
        int arr[] = {1, 3, 2, 5, 1, 3, 1, 5, 1};
        System.out.println(majorityElement(arr));

        //Valid Anangram
        System.out.print("Valid Anangram: ");
        String s = "race"; String t = "care";
        System.out.println(isValidAnangram(s,t));
    }
}
