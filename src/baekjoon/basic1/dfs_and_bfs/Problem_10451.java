package baekjoon.basic1.dfs_and_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_10451 {

    static int[] graph;
    static boolean[] isVisited;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCaseCount = Integer.parseInt(br.readLine());


        for (int i = 0; i < testCaseCount; i++) {
            int size = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            // init
            isVisited = new boolean[size+ 1];
            for (int j = 1; j <= size; j++) {
                isVisited[j] = false;
            }

            graph = new int[size + 1];
            for (int j = 1; j <= size; j++) {
                int b = Integer.parseInt(st.nextToken());
                graph[j] = b;
            }

            // logic
            count = 0;
            for (int j = 1; j <= size; j++) {
                if (!isVisited[j]) {
                    count++;
                    dfs(j);
                }
            }

            System.out.println(count);
        }
    }

    public static void dfs(int v) {
        isVisited[v] = true;
        int nextV = graph[v];
        if (!isVisited[nextV]) {
            dfs(nextV);
        }
    }
}
