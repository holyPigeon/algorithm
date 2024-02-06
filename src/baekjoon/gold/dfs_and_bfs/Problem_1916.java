package baekjoon.gold.dfs_and_bfs;

import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
- theme: 각 도시와 그 간의 간선, 가중치가 그래프로 나타난다. A와 B 두 도시가 주어졌을 때, 도달하는 최소 비용을 구하자.

- 일단 인접 그래프를 구현한다.
- BFS 를 통해 각 노드에서 가능한 가중치가 작은 곳으로 가고, 만약 도착한 곳의 최솟값을 갱신할 수 있다면, 갱신하면서 간다.
- 가능한 곳으로 가고(좌표 조건과 유사) 더 효율적인 곳으로(특정 조건 필요) 가야 한다.
 */

public class Problem_1916 {

    static List<Node>[] graph;
    static boolean[] isVisited;
    static int[] dist;
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        graph = new ArrayList[n + 1];
        dist = new int[n + 1];
        isVisited = new boolean[n + 1];

        // init
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[start].add(new Node(end, v));
        }
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st2.nextToken());
        int end = Integer.parseInt(st2.nextToken());

        bfs(start);

        System.out.println(dist[end]);
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        isVisited[start] = true;

        while(!queue.isEmpty()) {
            Integer x = queue.poll();

            Node minimumNode = new Node(0, Integer.MAX_VALUE);
            for (Node node : graph[x]) { // 해당 노드에서 갈 수 있는 노드를 고르기
                if (!isVisited[node.e]) {
//                    dist[node.e] = dist[x] + node.v;
                    if (node.v < minimumNode.v) {
                        minimumNode = node;
                    }

                    if (dist[node.e] == 0) { // 아직 방문하지 않은 노드라면 -> 갱신해준다.
                        dist[node.e] = dist[x] + node.v;
                        isVisited[start] = true;
                    }
                    if (dist[node.e] > dist[x] + node.v) { // 만약 기존 비용보다 새로운 비용이 더 싸다면 -> 갱신해준다.
                        dist[node.e] = dist[x] + node.v;
                        isVisited[start] = true;
                    }
                }
            }
            if (minimumNode.e == 0) {
                break;
            }
            queue.add(minimumNode.e);
            isVisited[minimumNode.e] = true;
        }
    }

    public static class Node {
        int e;
        int v;
        public Node(int e, int v) {
            this.e = e;
            this.v = v;
        }
    }
}
