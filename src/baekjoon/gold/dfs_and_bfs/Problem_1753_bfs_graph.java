package baekjoon.gold.dfs_and_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
- theme: 방향 그래프가 주어졌을 때, 시작점에서 모든 다른 정점으로의 최단 경로를 구해라.

- 일단 처음 정점에서 갈 수 있는 정점 선택지 중에 가장
 */

public class Problem_1753_bfs_graph {

    static List<Node>[] adjacentList;
    static int[] distance;
    static boolean[] isVisited;
    static int m;
    static int n;
    static int startV;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        startV = Integer.parseInt(br.readLine());
        adjacentList = new List[m + 1];
        distance = new int[m + 1];
        isVisited = new boolean[m + 1];

        // init
        for (int i = 1; i <= m; i++) {
            adjacentList[i] = new ArrayList();
        }
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[startV] = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st2.nextToken());
            int v2 = Integer.parseInt(st2.nextToken());
            int weight = Integer.parseInt(st2.nextToken());

            adjacentList[v1].add(new Node(v2, weight));
        }

        bfs(startV);

        distance[startV] = 0;
        for (int i = 1; i < m + 1; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
                continue;
            }
            System.out.println(distance[i]);
        }
    }

    private static void bfs(int startV) {
        Queue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(startV, 0));

        while(!queue.isEmpty()) {
            Node currentNode = queue.poll();

            // 현재 노드까지의 거리 + 가중치 < 다음 노드까지의 거리 인지
            // 그리고 방문 안 한 정점인지
            if (!isVisited[currentNode.v]) {
                isVisited[currentNode.v] = true;

                for (Node netxNode : adjacentList[currentNode.v]) {
                    if (distance[currentNode.v] + netxNode.w < distance[netxNode.v]) {
                         distance[netxNode.v] = distance[currentNode.v] + netxNode.w;
                         queue.add(new Node(netxNode.v, distance[netxNode.v]));
                    }
                }
            }
        }
    }

    public static class Node implements Comparable<Node> {
        int v;
        int w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return w - o.w;
        }
    }
}
