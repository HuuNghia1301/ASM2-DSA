import java.util.*;

public class Main {
    static final int INF = Integer.MAX_VALUE;

    // Dijkstra Algorithm
    public static void dijkstra(int graph[][], int start) {
        int V = graph.length;
        int[] dist = new int[V];
        boolean[] sptSet = new boolean[V];  // Đỉnh đã được thăm

        Arrays.fill(dist, INF);
        dist[start] = 0;

        for (int count = 0; count < V - 1; count++) {
            int u = minDistance(dist, sptSet);
            sptSet[u] = true;

            for (int v = 0; v < V; v++) {
                if (!sptSet[v] && graph[u][v] != 0 && dist[u] != INF && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }

        printSolution(dist);
    }

    private static int minDistance(int[] dist, boolean[] sptSet) {
        int min = INF, minIndex = -1;
        for (int v = 0; v < dist.length; v++) {
            if (!sptSet[v] && dist[v] <= min) {
                min = dist[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    private static void printSolution(int[] dist) {
        System.out.println("Dijkstra - Vertex \t Distance from Source");
        for (int i = 0; i < dist.length; i++) {
            System.out.println(i + " \t " + dist[i]);
        }
    }

    // Prim's Algorithm
    public static void prim(int graph[][]) {
        int V = graph.length;
        int[] key = new int[V]; // Lưu trọng số của các cạnh nối
        int[] parent = new int[V]; // Lưu cha của mỗi đỉnh
        boolean[] inMST = new boolean[V]; // Đỉnh có trong MST

        Arrays.fill(key, INF);
        key[0] = 0; // Bắt đầu từ đỉnh 0
        parent[0] = -1; // Đỉnh nguồn không có cha

        for (int count = 0; count < V - 1; count++) {
            int u = minKey(key, inMST);
            inMST[u] = true;

            for (int v = 0; v < V; v++) {
                if (graph[u][v] != 0 && !inMST[v] && graph[u][v] < key[v]) {
                    key[v] = graph[u][v];
                    parent[v] = u;
                }
            }
        }

        printMST(parent, graph);
    }

    private static int minKey(int[] key, boolean[] inMST) {
        int min = INF, minIndex = -1;
        for (int v = 0; v < key.length; v++) {
            if (!inMST[v] && key[v] < min) {
                min = key[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    private static void printMST(int[] parent, int[][] graph) {
        System.out.println("Prim - Edge \t Weight");
        for (int i = 1; i < parent.length; i++) {
            System.out.println(parent[i] + " - " + i + " \t " + graph[i][parent[i]]);
        }
    }

    // Main method to test both algorithms and measure time
    public static void main(String[] args) {
        int graph[][] = {
                {0, 10, 0, 0, 0, 0},
                {10, 0, 5, 0, 0, 0},
                {0, 5, 0, 20, 0, 0},
                {0, 0, 20, 0, 10, 0},
                {0, 0, 0, 10, 0, 5},
                {0, 0, 0, 0, 5, 0}
        };

        // Measuring Dijkstra's Algorithm performance
        long startTime = System.currentTimeMillis();
        dijkstra(graph, 0);  // Tìm đường đi ngắn nhất từ đỉnh 0
        long endTime = System.currentTimeMillis();
        System.out.println("Dijkstra Algorithm Time: " + (endTime - startTime) + " ms");

        // Measuring Prim's Algorithm performance
        startTime = System.currentTimeMillis();
        prim(graph);  // Tìm cây khung nhỏ nhất từ đồ thị
        endTime = System.currentTimeMillis();
        System.out.println("Prim's Algorithm Time: " + (endTime - startTime) + " ms");
    }
}
