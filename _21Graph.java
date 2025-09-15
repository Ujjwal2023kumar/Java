import java.util.*;

public class _21Graph {
    static class Edge {
        int src, dest, wt;
        Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    // ---------- Create Graph ----------
    static void createGraph(ArrayList<Edge>[] graph, int V) {
        for (int i = 0; i < V; i++) graph[i] = new ArrayList<>();
        // Example Graph
        graph[0].add(new Edge(0, 1, 5));

        graph[1].add(new Edge(1, 0, 5));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 3));

        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 3, 1));
        graph[2].add(new Edge(2, 4, 2));

        graph[3].add(new Edge(3, 1, 3));
        graph[3].add(new Edge(3, 2, 1));

        graph[4].add(new Edge(4, 2, 2));
    }

    // ---------- BFS ----------
    public static void bfs(ArrayList<Edge>[] graph, int V) {
        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[V];
        q.add(0);
        while (!q.isEmpty()) {
            int curr = q.remove();
            if (!vis[curr]) {
                System.out.print(curr + " ");
                vis[curr] = true;
                for (Edge e : graph[curr]) q.add(e.dest);
            }
        }
        System.out.println();
    }

    // ---------- DFS ----------
    public static void dfs(ArrayList<Edge>[] graph, int curr, boolean vis[]) {
        System.out.print(curr + " ");
        vis[curr] = true;
        for (Edge e : graph[curr]) {
            if (!vis[e.dest]) dfs(graph, e.dest, vis);
        }
    }

    // ---------- Has Path ----------
    public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean vis[]) {
        if (src == dest) return true;
        vis[src] = true;
        for (Edge e : graph[src]) {
            if (!vis[e.dest] && hasPath(graph, e.dest, dest, vis)) return true;
        }
        return false;
    }

    // ---------- Connected Components ----------
    public static void connectedComponents(ArrayList<Edge>[] graph, int V) {
        boolean vis[] = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(graph, i, vis);
                System.out.println();
            }
        }
    }

    // ---------- Detect Cycle Undirected ----------
    public static boolean detectCycleUndirected(ArrayList<Edge>[] graph, int curr, int par, boolean vis[]) {
        vis[curr] = true;
        for (Edge e : graph[curr]) {
            if (!vis[e.dest]) {
                if (detectCycleUndirected(graph, e.dest, curr, vis)) return true;
            } else if (e.dest != par) return true;
        }
        return false;
    }

    // ---------- Bipartite Graph ----------
    public static boolean isBipartite(ArrayList<Edge>[] graph, int V) {
        int col[] = new int[V];
        Arrays.fill(col, -1);
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < V; i++) {
            if (col[i] == -1) {
                q.add(i);
                col[i] = 0;
                while (!q.isEmpty()) {
                    int curr = q.remove();
                    for (Edge e : graph[curr]) {
                        if (col[e.dest] == -1) {
                            col[e.dest] = 1 - col[curr];
                            q.add(e.dest);
                        } else if (col[e.dest] == col[curr]) return false;
                    }
                }
            }
        }
        return true;
    }

    // ---------- Detect Cycle Directed ----------
    public static boolean detectCycleDirected(ArrayList<Edge>[] graph, int V) {
        boolean vis[] = new boolean[V];
        boolean stack[] = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                if (detectCycleDirectedUtil(graph, i, vis, stack)) return true;
            }
        }
        return false;
    }

    private static boolean detectCycleDirectedUtil(ArrayList<Edge>[] graph, int curr, boolean vis[], boolean stack[]) {
        vis[curr] = true;
        stack[curr] = true;
        for (Edge e : graph[curr]) {
            if (stack[e.dest]) return true;
            if (!vis[e.dest] && detectCycleDirectedUtil(graph, e.dest, vis, stack)) return true;
        }
        stack[curr] = false;
        return false;
    }

    // ---------- Topological Sort (DFS) ----------
    public static void topoSortDFS(ArrayList<Edge>[] graph, int V) {
        boolean vis[] = new boolean[V];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < V; i++) {
            if (!vis[i]) topoDFS(graph, i, vis, st);
        }
        while (!st.isEmpty()) System.out.print(st.pop() + " ");
        System.out.println();
    }

    private static void topoDFS(ArrayList<Edge>[] graph, int curr, boolean vis[], Stack<Integer> st) {
        vis[curr] = true;
        for (Edge e : graph[curr]) {
            if (!vis[e.dest]) topoDFS(graph, e.dest, vis, st);
        }
        st.push(curr);
    }

    // ---------- Topological Sort (BFS - Kahn) ----------
    public static void topoSortBFS(ArrayList<Edge>[] graph, int V) {
        int indeg[] = new int[V];
        for (int i = 0; i < V; i++) {
            for (Edge e : graph[i]) indeg[e.dest]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) if (indeg[i] == 0) q.add(i);

        while (!q.isEmpty()) {
            int curr = q.remove();
            System.out.print(curr + " ");
            for (Edge e : graph[curr]) {
                indeg[e.dest]--;
                if (indeg[e.dest] == 0) q.add(e.dest);
            }
        }
        System.out.println();
    }

    // ---------- All Paths from src to dest ----------
    public static void allPaths(ArrayList<Edge>[] graph, int src, int dest, String path, boolean vis[]) {
        if (src == dest) {
            System.out.println(path + dest);
            return;
        }
        vis[src] = true;
        for (Edge e : graph[src]) {
            if (!vis[e.dest]) allPaths(graph, e.dest, dest, path + src + "->", vis);
        }
        vis[src] = false;
    }

    // ---------- Dijkstra ----------
    static class Pair implements Comparable<Pair> {
        int node, dist;
        Pair(int n, int d) { node = n; dist = d; }
        public int compareTo(Pair p) { return this.dist - p.dist; }
    }

    public static void dijkstra(ArrayList<Edge>[] graph, int src, int V) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int dist[] = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            for (Edge e : graph[curr.node]) {
                int newDist = dist[curr.node] + e.wt;
                if (newDist < dist[e.dest]) {
                    dist[e.dest] = newDist;
                    pq.add(new Pair(e.dest, newDist));
                }
            }
        }
        System.out.println("Dijkstra from " + src + ": " + Arrays.toString(dist));
    }

    // ---------- Bellman-Ford ----------
    public static void bellmanFord(ArrayList<Edge>[] graph, int V, int src) {
        int dist[] = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        ArrayList<Edge> edges = new ArrayList<>();
        for (int i = 0; i < V; i++) edges.addAll(graph[i]);

        for (int i = 0; i < V - 1; i++) {
            for (Edge e : edges) {
                if (dist[e.src] != Integer.MAX_VALUE && dist[e.src] + e.wt < dist[e.dest]) {
                    dist[e.dest] = dist[e.src] + e.wt;
                }
            }
        }
        System.out.println("Bellman-Ford from " + src + ": " + Arrays.toString(dist));
    }

    // ---------- Floyd-Warshall ----------
    public static void floydWarshall(int[][] matrix, int V) {
        int dist[][] = new int[V][V];
        for (int i = 0; i < V; i++) dist[i] = Arrays.copyOf(matrix[i], V);

        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] != 1e9 && dist[k][j] != 1e9) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }
        System.out.println("Floyd-Warshall:");
        for (int[] row : dist) System.out.println(Arrays.toString(row));
    }

    // TODO: Add Prim’s, Kruskal’s, DSU, Flights with K stops, Connecting Cities, Flood Fill, Tarjan, Kosaraju (SCC)

    // ---------- Main ----------
    public static void main(String[] args) {
        int V = 7;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph, V);

        System.out.print("BFS: ");  bfs(graph, V);
        System.out.print("DFS: "); dfs(graph, 0, new boolean[V]); System.out.println();
        System.out.println("Has Path (0->5)? " + hasPath(graph, 0, 5, new boolean[V]));
        System.out.print("Connected Components: "); connectedComponents(graph, V);
        System.out.println("Cycle Detection (Undirected): " + detectCycleUndirected(graph, 0, -1, new boolean[V]));
        System.out.println("Bipartite Graph: " + isBipartite(graph, V));
        System.out.println("Cycle Detection (Directed): " + detectCycleDirected(graph, V));
        System.out.print("Topological Sort (DFS): "); topoSortDFS(graph, V);
        System.out.print("Topological Sort (BFS - Kahn): "); topoSortBFS(graph, V);

        System.out.println("All Paths 0->4:");
        allPaths(graph, 0, 4, "", new boolean[V]);

        dijkstra(graph, 0, V);
        bellmanFord(graph, V, 0);

        int INF = (int)1e9;
        int[][] matrix = {
            {0, 5, INF, INF, INF, INF, INF},
            {5, 0, 1, 3, INF, INF, INF},
            {INF, 1, 0, 1, 2, INF, INF},
            {INF, 3, 1, 0, INF, INF, INF},
            {INF, INF, 2, INF, 0, INF, INF},
            {INF, INF, INF, INF, INF, 0, INF},
            {INF, INF, INF, INF, INF, INF, 0}
        };
        floydWarshall(matrix, V);
    }
}
