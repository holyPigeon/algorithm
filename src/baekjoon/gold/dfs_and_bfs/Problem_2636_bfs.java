package baekjoon.gold.dfs_and_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.Queue;

/*
theme: 치즈가 모두 녹기까지 걸리는 시간과 녹기 1시간 전 남아있는 치즈의 개수를 구하라.

intro
- 치즈는 공기와 닿으면 녹는다. 즉, 4면 중 한 면이라도 공기와 닿아있으면 녹아서 해당 자리는 1시간 뒤에서 치즈 -> 공기로 대체된다.
- 다만 공기는 치즈의 경계 바깥에만 있고 치즈 내부 구멍에는 없으므로, 치즈 내부는 바깥과 연결되지 않는 이상 녹지 않는다.

trouble shooting
- 이에 따라 map 배열 외의 또 하나의 배열을 만들어서 매 회차 공기와 맞닿은 치즈는 어디인지 체크가 필요 (boolean[] isEdge)
- 치즈에 구멍이 있는지 조사하는 방법 -> BFS 를 통해 0인 부분만 방문하면서 조사해봤는데 끊긴다면 구멍으로 간주
 */

public class Problem_2636_bfs {

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int[][] map;
    static int[][] lastMap;
    static boolean[][] isVisited;
    static int m;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int[m][n];
        lastMap = new int[m][n];
        isVisited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st2.nextToken());
            }
        }

        boolean isEmpty = false;
        int time = 0;
        while (!isEmpty) {

            /*
            - 이전 map의 모습 보존
             */
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    lastMap[i][j] = map[i][j];
                }
            }

            /*
            - 외부 치즈 녹이기
            구멍이 아닌 원소와 맞닿아 있는 치즈들을 전부 1에서 -1로 바꾼다.
             */
            bfs(0, 0);

            /*
            - -1 상태의 치즈 녹이기
            -1인 원소들을 모두 0으로 바꾼다.
             */
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] == -1) {
                        map[i][j] = 0;
                    }
                }
            }
            isVisited = new boolean[m][n];

            /*
            - 모두 비었는지 체크
             */
            isEmpty = true;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] != 0) {
                        isEmpty = false;
                    }
                }
            }
            time++;
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (lastMap[i][j] == 1) {
                    count++;
                }
            }
        }

        System.out.println(time);
        System.out.println(count);

    }

    private static void bfs(int i, int j) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(i, j));
        isVisited[i][j] = true;

        while (!queue.isEmpty()) {
            Node poll = queue.poll();

            for (int k = 0; k < 4; k++) {
                int ci = poll.i + dx[k];
                int cj = poll.j + dy[k];

                if (ci >= 0 && cj >= 0 && ci < m && cj < n && !isVisited[ci][cj]) {
                    if (map[ci][cj] == 1 && map[poll.i][poll.j] == 0) { // 공기와 맞닿은 치즈들을 1에서 -1로 바꾼다.
                        map[ci][cj] = -1;
                    }
                    if (map[ci][cj] == 0) { // 옆에 공기들로 이동, 이동한 곳은 방문 처리
                        isVisited[ci][cj] = true;
                        queue.add(new Node(ci, cj));
                    }
                }
            }
        }
    }

    private static class Node {
        int i;
        int j;

        public Node(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
