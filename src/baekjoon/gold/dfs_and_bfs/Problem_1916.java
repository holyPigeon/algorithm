package baekjoon.gold.dfs_and_bfs;

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
        Arrays.fill(dist, Integer.MAX_VALUE);

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
        Queue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));
        dist[start] = 0;

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();

            if (!isVisited[currentNode.e]) {
                isVisited[currentNode.e] = true;

                for (Node node : graph[currentNode.e]) { // 해당 노드에서 갈 수 있는 노드를 고르기
                    if ((dist[node.e] > dist[currentNode.e] + node.v) && !isVisited[node.e]) { // 만약 기존 비용보다 새로운 비용이 더 싸다면 갱신해준다.
                        dist[node.e] = dist[currentNode.e] + node.v; // 갱신
                        queue.add(new Node(node.e, dist[node.e])); // 큐에 도달 비용이 갱신된 노드를 새로 추가한다.
                    }
                }
            }
        }
    }

    public static class Node implements Comparable<Node> {
        int e;
        int v;

        public Node(int e, int v) {
            this.e = e;
            this.v = v;
        }

        @Override
        public int compareTo(Node o) {
            return v - o.v;
        }
    }
}
