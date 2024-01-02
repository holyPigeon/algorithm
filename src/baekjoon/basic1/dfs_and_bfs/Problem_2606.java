package baekjoon.basic1.dfs_and_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem_2606 {

    static List<Integer>[] graph;
    static boolean[] isVisited;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        graph = new List[n + 1];
        isVisited = new boolean[n + 1];

        // init
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
            isVisited[i] = false;
        }
        for (int i = 1; i <= m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        // logic
        dfs(1);

        System.out.println(result);
    }

    public static void dfs(int v) {
        isVisited[v] = true;
        for (Integer adjacentV : graph[v]) {
            if (!isVisited[adjacentV]) {
                result++;
                dfs(adjacentV);
            }
        }
    }
}
