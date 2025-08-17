import java.util.*;

public class _31Graph {

    // -------------------- Graph Representation -------------------- //
    static class Edge {
        int src, dest, wt;
        Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    static void createGraph(ArrayList<Edge>[] graph, int V) {
        for (int i = 0; i < V; i++) graph[i] = new ArrayList<>();
        // Example Graph
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));
        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));
        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));
        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));
        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));
        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));
        graph[6].add(new Edge(6, 5, 1));
    }

    // -------------------- BFS -------------------- //
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

    // -------------------- DFS -------------------- //
    public static void dfs(ArrayList<Edge>[] graph, int curr, boolean vis[]) {
        System.out.print(curr + " ");
        vis[curr] = true;
        for (Edge e : graph[curr]) {
            if (!vis[e.dest]) dfs(graph, e.dest, vis);
        }
    }

    // -------------------- Path Check -------------------- //
    public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean vis[]) {
        if (src == dest) return true;
        vis[src] = true;
        for (Edge e : graph[src]) {
            if (!vis[e.dest] && hasPath(graph, e.dest, dest, vis)) return true;
        }
        return false;
    }

    // -------------------- Connected Components -------------------- //
    public static void connectedComponents(ArrayList<Edge>[] graph, int V) {
        boolean vis[] = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(graph, i, vis);
                System.out.println();
            }
        }
    }

    // -------------------- Cycle Detection (Undirected) -------------------- //
    public static boolean detectCycleUndirected(ArrayList<Edge>[] graph, int curr, int par, boolean vis[]) {
        vis[curr] = true;
        for (Edge e : graph[curr]) {
            if (!vis[e.dest]) {
                if (detectCycleUndirected(graph, e.dest, curr, vis)) return true;
            } else if (e.dest != par) return true;
        }
        return false;
    }

    // -------------------- Bipartite Graph -------------------- //
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

    // -------------------- Cycle Detection (Directed) -------------------- //
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

    // -------------------- Topological Sort (DFS) -------------------- //
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

    // -------------------- Topological Sort (BFS - Kahn’s Algo) -------------------- //
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

    // -------------------- MAIN -------------------- //
    public static void main(String[] args) {
        int V = 7;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph, V);

        System.out.println("=== BFS ===");
        bfs(graph, V);

        System.out.println("=== DFS ===");
        dfs(graph, 0, new boolean[V]);
        System.out.println();

        System.out.println("=== Has Path (0->5)? " + hasPath(graph, 0, 5, new boolean[V]));

        System.out.println("\n=== Connected Components ===");
        connectedComponents(graph, V);

        System.out.println("\n=== Cycle Detection (Undirected) ===");
        System.out.println(detectCycleUndirected(graph, 0, -1, new boolean[V]));

        System.out.println("\n=== Bipartite Graph ===");
        System.out.println(isBipartite(graph, V));

        System.out.println("\n=== Cycle Detection (Directed) ===");
        System.out.println(detectCycleDirected(graph, V));

        System.out.println("\n=== Topological Sort (DFS) ===");
        topoSortDFS(graph, V);

        System.out.println("\n=== Topological Sort (BFS - Kahn) ===");
        topoSortBFS(graph, V);

        // TODO: Add
        // All Paths Source->Target
        // Dijkstra
        // Bellman-Ford
        // Prim’s MST
        // Kruskal’s MST
        // Disjoint Set Union
        // Cheapest Flights K Stops
        // Connecting Cities
        // Flood Fill
        // Tarjan’s Algo (SCC, Bridge, Articulation)
        // Floyd Warshall
        // Kosaraju’s Algo
    }
}
