import java.util.*;

public class bellman {
    public static int n;
    public static int[][] graph;

    static void solve(int src) {
        int[] dist = new int[n];
        for (int i = 0; i < n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[src] = 0;
        for (int i = 1; i < n; i++) {
            for (int u = 0; u < n; u++) {
                for (int v = 0; v < n; v++) {
                    if (dist[u] != Integer.MAX_VALUE && graph[u][v] != 0 && dist[u] + graph[u][v] < dist[v]) {
                        dist[v] = dist[u] + graph[u][v];
                    }
                }
            }
        }
        for (int u = 0; u < n; u++) {
            for (int v = 0; v < n; v++) {
                if (dist[u] != Integer.MAX_VALUE && graph[u][v] != 0 && dist[u] + graph[u][v] < dist[v]) {
                    System.out.println("Negative cycles");
                    return;
                }
            }
        }
        System.out.println("Src Dist");
        for (int i = 0; i < n; i++) {
            System.out.println(i + " ~ " + dist[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the matrix");
        n = sc.nextInt();
        System.out.println("Enter the weight matrix of the graph");
        graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();
            }
        }
        System.err.println("Enter the src vertex: ");
        int src = sc.nextInt();
        solve(src - 1);
        sc.close();
    }
}
