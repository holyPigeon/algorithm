package baekjoon.basic1.bfs;

/*
theme: 탐색 결과를 각각 dfs, bfs 로 나타내자
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem_1260 {

    static int n, m, startV;
    static List<Integer>[] graph;
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        startV = Integer.parseInt(st.nextToken());

        isVisited = new boolean[n + 1];
        graph = new ArrayList[n + 1];

        // init
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 1; i <= n; i++) {
            isVisited[i] = false;
        }
        for (int i = 0; i < m; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st1.nextToken());
            int b = Integer.parseInt(st1.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        // dfs logic
        for (int i = 0; i < n; i++) {
            dfs(startV);
        }

        // init
        for (int i = 1; i <= n; i++) {
            isVisited[i] = false;
        }

        // bfs logic
        System.out.println();
        bfs(startV);
    }

    public static void dfs(int v) {
        if (isVisited[v]) {
            return;
        }
        isVisited[v] = true;
        System.out.print(v + " ");
        for (Integer adjacentV : graph[v]) {
            dfs(adjacentV);
        }
    }

    public static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);
        isVisited[v] = true;
        System.out.print(v + " ");

        while (!queue.isEmpty()) {
            Integer startV = queue.poll();
            for (Integer adjacentV : graph[startV]) {
                if (!isVisited[adjacentV]) {
                    isVisited[adjacentV] = true;
                    System.out.print(adjacentV + " ");
                    queue.offer(adjacentV);
                }
            }
        }
    }
}
