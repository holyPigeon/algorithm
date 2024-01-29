package baekjoon.gold.dfs_and_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

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
        int possibleCount = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (map[i][j][k] == 1) {
                        if (!isVisited[i][j][k]) {
                            bfs(i, j, k);
                            possibleCount++;
                        }
                    }
                }
            }
        }

        Arrays.sort(dp[h-1][n-1]);

        if (possibleCount > 1) {
            System.out.println(-1);
        } else {
            System.out.println(dp[h-1][n-1][m-1]);
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
                    if (!isVisited[cz][cy][cx] && map[cz][cy][cx] == 0) {
                        isVisited[cz][cy][cx] = true;
                        dp[cz][cy][cx] = dp[q][w][e] + 1;
                        queue.offer(new int[]{cz, cy, cx});
                    }
                }
            }
        }
    }
}
