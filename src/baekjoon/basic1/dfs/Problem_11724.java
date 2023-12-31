package baekjoon.basic1.dfs;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem_11724 {

    private static boolean[] isVisited;
    private static List<Integer>[] adjacentVertexes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        isVisited = new boolean[n + 1];
        adjacentVertexes = new ArrayList[n + 1];

        // init
        for (int i = 1; i <= n; i++) {
            isVisited[i] = false;
        }
        for (int i = 1; i <= n; i++) {
            adjacentVertexes[i] = new ArrayList<>();
        }

        for (int i = 1; i <= m; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
            int v1 = Integer.parseInt(st1.nextToken());
            int v2 = Integer.parseInt(st1.nextToken());
            adjacentVertexes[v1].add(v2);
            adjacentVertexes[v2].add(v1);
        }

        // logic
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (!isVisited[i]) {
                count++;
                dfs(i);
            }
        }

        System.out.println(count);
    }

    public static void dfs(int i) {
        if (isVisited[i]) {
            return;
        }
        isVisited[i] = true;
        for (Integer adjacentVertex : adjacentVertexes[i]) {
            if (!isVisited[adjacentVertex]) {
                dfs(adjacentVertex);
            }
        }
    }
}
