package baekjoon.basic1.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem_1707 {

    static int K;
    static List<Integer>[] adjacentVertexes;
    static boolean[] isVisited;
    static boolean[] check;
    static boolean isEven;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine());


        for (int i = 0; i < K; i++) {
            // init 1
            StringTokenizer st = new StringTokenizer(br.readLine());
            int vCount = Integer.parseInt(st.nextToken());
            int eCount = Integer.parseInt(st.nextToken());
            adjacentVertexes = new ArrayList[vCount + 1];
            isVisited = new boolean[vCount + 1];
            check = new boolean[vCount + 1];
            isEven = true;

            // init 2
            for (int j = 1; j <= vCount; j++) {
                adjacentVertexes[j] = new ArrayList<>();
            }

            for (int j = 0; j < eCount; j++) {
                StringTokenizer st2 = new StringTokenizer(br.readLine());
                int v = Integer.parseInt(st2.nextToken());
                int e = Integer.parseInt(st2.nextToken());
                adjacentVertexes[v].add(e);
                adjacentVertexes[e].add(v);
            }

            // logic
            for (int j = 1; j <= vCount; j++) {
                if (isEven) {
                    dfs(j);
                } else {
                    break;
                }
            }

            if (isEven) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        }
    }

    static void dfs(int i) {
        isVisited[i] = true;
        for (int adjacentVertex : adjacentVertexes[i]) {
            if (!isVisited[adjacentVertex]) {
                check[adjacentVertex] = !check[i]; // 이전 노드와 다른 값을 넣어줌
                dfs(adjacentVertex);
            } else if (check[adjacentVertex] == check[i]) {
                isEven = false;
            }
        }
    }
}
