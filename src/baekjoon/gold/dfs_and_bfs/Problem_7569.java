package baekjoon.gold.dfs_and_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
- theme: 토마토가 모두 익을 때까지의 걸리는 시간을 구하자.

- 3차원 공간에 토마토들이 있다. 이 3차원 공간을 순회하면서 익은 + 아직 방문하지 않은 토마토가 있는 곳부터 bfs를 돌린다.
- 3차원 공간에서 인접한 토마토들이 익으므로 동서남북 + 상하 총 6개의 방향으로 탐색을 한다. 한 번에 익을 수 있는 최대한의 토마토는 6개다.
    - 이에 따라 6번 도는 for문이 끝났을 때 time을 올릴 수 있다.

- 문제점: 인접 토마토들이 익는 시간의 기준을 어떻게 잡아야 하는지 모르겠다. 처음에는 6개 방향만 조사하면 되지만, 이후 큐에 추가된
좌표들 * 6개의 방향 이런 식으로 점점 조사할 게 늘어난다. 몇 개 간격으로 시간이 1 흘렀다고 체크해야 할 지 모르겠다.

- 해결 방법을 찾은 듯? poll 해서 뽑은 애 + 1을 해버리면 상관없지 않나
 */

public class Problem_7569 {

    static int[] dx = {0, 0, 1, -1, 0, 0}; // 동 서 남 북 상 하
    static int[] dy = {1, -1, 0, 0, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int m;
    static int n;
    static int h;
    static int[][][] map;
    static int[][][] dp;
    static boolean[][][] isVisited;
    static int time = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        map = new int[h][n][m];
        isVisited = new boolean[h][n][m];
        dp = new int[h][n][m];

        // init
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                StringTokenizer st2 = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    map[i][j][k] = Integer.parseInt(st2.nextToken());
                }
            }
        }

        // logic
        int zeroCount = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (map[i][j][k] == 0) {
                        zeroCount++;
                    }
                    if (map[i][j][k] == 1 && (!isVisited[i][j][k])) {
                        bfs(i, j, k);
                    }
                }
            }
        }

        Arrays.sort(dp[h - 1][n - 1]);

        if (zeroCount == 0) {
            System.out.println(0);
            return;
        }

        zeroCount = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (map[i][j][k] == 0) {
                        zeroCount++;
                    }
                }
            }
        }

        if (zeroCount > 0) {
            System.out.println(-1);
        } else {
            System.out.println(dp[h - 1][n - 1][m - 1] + 1);
        }
    }

    private static void bfs(int q, int w, int e) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{q, w, e});

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int z = poll[0];
            int y = poll[1];
            int x = poll[2];

            for (int i = 0; i < 6; i++) {
                int cx = x + dx[i];
                int cy = y + dy[i];
                int cz = z + dz[i];

                if (cx >= 0 && cy >= 0 && cz >= 0 && cx < m && cy < n && cz < h) {
                    if (!isVisited[cz][cy][cx] && (map[cz][cy][cx] == 0 || map[cz][cy][cx] == 1)) {
                        isVisited[cz][cy][cx] = true;
                        map[cz][cy][cx] = 1;
                        dp[cz][cy][cx] = dp[z][y][x] + 1; // 인접한 곳 중에서 아직 방문 X + 토마토가 있는 곳으로 탐색 후 익게 함
                        queue.offer(new int[]{cz, cy, cx});
                    }
                }
            }
        }
    }
}
