import java.util.*;

public class _25GreedyAlgo {
    public static ArrayList<Integer> maxActivities(int[] start, int[] end) {
        int n = start.length;
        int activities[][] = new int[n][3];

        for (int i = 0; i < n; i++) {
            activities[i][0] = i;
            activities[i][1] = start[i];
            activities[i][2] = end[i];
        }

        // Sort by finish time
        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));

        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(activities[0][0]);
        int lastEnd = activities[0][2];

        for (int i = 1; i < n; i++) {
            if (activities[i][1] >= lastEnd) {
                ans.add(activities[i][0]);
                lastEnd = activities[i][2];
            }
        }
        System.out.println("Max activities: " + ans.size());
        return ans;
    }

    public static void main(String[] args) {

        //Activity Selection
        int start[] = {1, 3, 0, 5, 8, 5};
        int end[] = {2, 4, 6, 7, 9, 9};
        ArrayList<Integer> selected = maxActivities(start, end);
        for (int i = 0; i < selected.size(); i++) {
            System.out.print("A" + selected.get(i) + " ");
        }
        System.out.println();
    }
}
