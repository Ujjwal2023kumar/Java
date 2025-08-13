import java.util.*;

public class _28Heaps {
    static class Heap {
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data) {
            arr.add(data);
            int idx = arr.size() - 1;
            int par = (idx - 1) / 2;
            while (idx > 0 && arr.get(idx) < arr.get(par)) {
                int temp = arr.get(idx);
                arr.set(idx, arr.get(par));
                arr.set(par, temp);
                idx = par;
                par = (idx - 1) / 2;
            }
        }

        public int peek() {
            return arr.get(0);
        }

        private void heapify(int i) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int minIdx = i;

            if (left < arr.size() && arr.get(minIdx) > arr.get(left)) {
                minIdx = left;
            }
            if (right < arr.size() && arr.get(minIdx) > arr.get(right)) {
                minIdx = right;
            }
            if (minIdx != i) {
                int temp = arr.get(i);
                arr.set(i, arr.get(minIdx));
                arr.set(minIdx, temp);
                heapify(minIdx);
            }
        }

        public int remove() {
            int data = arr.get(0);
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size() - 1));
            arr.set(arr.size() - 1, temp);

            arr.remove(arr.size() - 1);
            heapify(0);
            return data;
        }
    }

    public static void heapSort(int arr[]) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : arr) pq.add(num);
        int i = 0;
        while (!pq.isEmpty()) arr[i++] = pq.remove();
    }

    static class Point implements Comparable<Point> {
        int x, y, distSq;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
            this.distSq = x * x + y * y;
        }

        @Override
        public int compareTo(Point p2) {
            return this.distSq - p2.distSq;
        }
    }

    public static void main(String[] args) {
        // Max heap example
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.add(3);
        pq.add(4);
        pq.add(1);
        pq.add(7);
        System.out.println("Max Heap:");
        while (!pq.isEmpty()) {
            System.out.println(pq.remove());
        }

        // Nearby Cars
        int pts[][] = {{3, 3}, {5, -1}, {-2, 4}};
        int k = 2;
        PriorityQueue<Point> pqPoints = new PriorityQueue<>();
        for (int[] pt : pts) {
            pqPoints.add(new Point(pt[0], pt[1]));
        }
        System.out.println("Nearest " + k + " cars:");
        for (int i = 0; i < k; i++) {
            Point p = pqPoints.remove();
            System.out.println("(" + p.x + ", " + p.y + ")");
        }

        // Connect N ropes with minimum cost
        int ropes[] = {2, 3, 3, 4, 6};
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        for (int rope : ropes) pq1.add(rope);
        int cost = 0;
        while (pq1.size() > 1) {
            int min = pq1.remove();
            int min2 = pq1.remove();
            cost += min + min2;
            pq1.add(min + min2);
        }
        System.out.println("Cost of connecting ropes: " + cost);

        // Weakest soldier
        int army[][] = {{1, 0, 0, 0}, {1, 1, 1, 1}, {1, 0, 0, 0}, {1, 0, 0, 0}};
        PriorityQueue<int[]> soldierStrength = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < army.length; i++) {
            int strength = 0;
            for (int j = 0; j < army[i].length; j++) strength += army[i][j];
            soldierStrength.add(new int[]{strength, i});
        }
        System.out.println("Weakest soldier row index: " + soldierStrength.remove()[1]);

        // Sliding window max
        int window[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int maxSubarraySize = 3;
        Deque<Integer> dq = new ArrayDeque<>();
        System.out.print("Sliding window max: ");
        for (int i = 0; i < window.length; i++) {
            while (!dq.isEmpty() && dq.peekFirst() <= i - maxSubarraySize) dq.pollFirst();
            while (!dq.isEmpty() && window[dq.peekLast()] < window[i]) dq.pollLast();
            dq.offerLast(i);
            if (i >= maxSubarraySize - 1) System.out.print(window[dq.peekFirst()] + " ");
        }
        System.out.println();
    }
}
