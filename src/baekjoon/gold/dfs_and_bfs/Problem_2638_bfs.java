package baekjoon.gold.dfs_and_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_2638_bfs {

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int[][] map;
    static int[][] count;
    static boolean[][] isVisited;
    static int m;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int[m][n];

        // init
        for (int i = 0; i < m; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st2.nextToken());
            }
        }

        /*
        logic
         */
        int time = 0;
        boolean isEmpty = false;
        while(!isEmpty) {
            // 기록 초기화
            isVisited = new boolean[m][n];
            count = new int[m][n];
            isEmpty = true;

            // 2면 이상 맞닿은 치즈 조사 후 -1로 변경
            bfs(0, 0);

            // count 가 2 이상인 치즈 모두 0으로 변경
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (count[i][j] >= 2) {
                        map[i][j] = 0;
                    }
                }
            }

            // map 이 비어있는지 확인
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] == 1) {
                        isEmpty = false;
                    }
                }
            }
            time++;
        }

        System.out.println(time);
    }

    private static void bfs(int m, int n) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(m, n));
        isVisited[m][n] = true;

        while (!queue.isEmpty()) {
            Node originNode = queue.poll();

            for (int i = 0; i < 4; i++) {
                int cm = originNode.m + dx[i];
                int cn = originNode.n + dy[i];

                if (isAvailableNode(cm, cn)) {
                    if (map[cm][cn] == 0) {
                        queue.add(new Node(cm, cn));
                        isVisited[cm][cn] = true;
                    }
                    if (map[cm][cn] == 1) {
                        count[cm][cn]++;
                    }
                }
            }
        }
    }

    private static boolean isAvailableNode(int cm, int cn) {
        return cm >= 0 && cn >= 0 && cm < m && cn < n &&
                !isVisited[cm][cn];
    }

    private static class Node {
        int m;
        int n;

        public Node(int m, int n) {
            this.m = m;
            this.n = n;
        }
    }
}
