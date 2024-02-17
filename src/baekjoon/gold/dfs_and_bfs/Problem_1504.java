package baekjoon.gold.dfs_and_bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

/*
- theme: 방향이 없는 그래프에서 1 -> N 으로 이동하는데 주어진 임의의 2개 정점을 통과하면서 이동하라.

- 기본적으로 그래프에서 정점 사이의 최단거리를 구하기 때문에 다익스트라로 접근한다.
- 다만, 이전에 방문했던 정점과 간선을 모두 재방문할 수 있다. 따라서 일단 방문은 기록하지 않는다.
- 1 -> v -> u -> n 또는 1 -> u -> n -> n 의 방향으로 가는 방법이 있다. 경우의 수가 적기 때문에 둘 다 시도해본다.
- 1 -> v, v -> u, u -> n 총 3번의 bfs 를 시행한다. 근데 두 번이므로 3 * 2 = 6번 한다.

 */

public class Problem_1504 {

    static List<Node>[] graph;
    static int[] distance;
    static int n;
    static int e;


    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n + 1];
        distance = new int[n];
        
        // init
        for (int i = 1; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        Arrays.fill(distance, Integer.MAX_VALUE);

        for (int i = 0; i < e; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st2.nextToken());
            int v2 = Integer.parseInt(st2.nextToken());
            int w = Integer.parseInt(st2.nextToken());

            graph[v1].add(new Node(v2, w));
            graph[v2].add(new Node(v1, w));
        }

        StringTokenizer st3 = new StringTokenizer(br.readLine());
        int u = Integer.parseInt(st3.nextToken());
        int v = Integer.parseInt(st3.nextToken());

        // logic
        bfs(1);
    }

    private static void bfs(int i) {
        Queue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(i, 0));

        while(!queue.isEmpty()) {
            Node currentNode = queue.remove();
            int currentV = currentNode.opponentV;
            int currentW = currentNode.w;

            for (Node node : graph[currentV]) {
                if (distance[currentNode.opponentV] + currentNode.w < distance[node.opponentV]) {
                    distance[node.opponentV] = distance[currentNode.opponentV] + currentNode.w;
                    queue.add(new Node(node.opponentV, distance[node.opponentV]));
                    // 어떻게 루프를 멈출 지가 중요. 방문을 통해 멈추는 게 아니라면 어떻게?
                }

            }
        }
    }

    private static class Node implements Comparable<Node> {
        int opponentV;
        int w;

        public Node(int opponentV, int w) {
            this.opponentV = opponentV;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return w - o.w;
        }
    }
}
