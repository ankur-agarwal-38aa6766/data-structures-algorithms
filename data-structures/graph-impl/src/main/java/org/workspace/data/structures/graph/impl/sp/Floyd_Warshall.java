package org.workspace.data.structures.graph.impl.sp;

import java.util.Arrays;
import java.util.Scanner;

public class Floyd_Warshall {

    private final Scanner scan;
    private final int INF = Integer.MAX_VALUE;

    Floyd_Warshall() {
        scan = new Scanner(System.in);
    }

    private int[][] getWeightInAdjMatrix(int vertix_count) {
        int[][] adj_matrix = new int[vertix_count][];
        for (int i = 0; i < vertix_count; i++) {
            adj_matrix[i] = Arrays.stream(scan.nextLine().split(" "))
                    .limit(vertix_count)
                    .mapToInt(w -> w.matches("[0-9]+") ? Integer.parseInt(w) : INF)
                    .toArray();
        }
        return adj_matrix;
    }

    private int sum(int[][] adj, int src, int dest, int k) {
        if (adj[src][k] < INF && adj[k][dest] < INF && (adj[src][k] + adj[k][dest]) < INF)
            return adj[src][k] + adj[k][dest];
        return INF;
    }

    private void algorithm(int[][] adj, int v) {
        for (int k = 0; k < v; k++) {
            for (int src = 0; src < v; src++) {
                for (int desc = 0; desc < v; desc++) {
                    int midSum = sum(adj, src, desc, k);
                    if (adj[src][desc] > midSum)
                        adj[src][desc] = midSum;
                }
            }
        }
    }

    private static String reduceArray(int[] vertix_link) {
        return Arrays.stream(vertix_link)
                .boxed()
                .map(String::valueOf)
                .reduce((v1, v2) -> (v1 + " " + v2))
                .orElse("");
    }

    private void print(int[][] adj) {
        Arrays.stream(adj)
                .map(Floyd_Warshall::reduceArray)
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        Floyd_Warshall obj = new Floyd_Warshall();

        int T = obj.scan.nextInt();

        while (T-- > 0) {
            int V = obj.scan.nextInt();
            obj.scan.nextLine();
            int[][] adj = obj.getWeightInAdjMatrix(V);

            obj.algorithm(adj, V);
            obj.print(adj);
        }
    }
}
