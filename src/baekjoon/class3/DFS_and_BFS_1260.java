package baekjoon.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DFS_and_BFS_1260 {

    static int n, m, startV;
    static List<Integer>[] graph;
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        startV = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        isVisited = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        Arrays.stream(graph)
                .forEach(Collections::sort);

        // dfs
        for (int i = 1; i <= n; i++) {
            dfs(startV);
        }

        // init
        for (int i = 1; i <= n; i++) {
            isVisited[i] = false;
        }

        // bfs
        System.out.println();
        bfs(startV);
    }

    public static void dfs(int v) {
        if(isVisited[v]) {
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

        while(!queue.isEmpty()) {
            Integer currentV = queue.poll();
            for (Integer adjacentV : graph[currentV]) {
                if (!isVisited[adjacentV]) {
                    isVisited[adjacentV] = true;
                    System.out.print(adjacentV + " ");
                    queue.offer(adjacentV);
                }
            }
        }
    }
}
