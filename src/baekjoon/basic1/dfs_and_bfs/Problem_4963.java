package baekjoon.basic1.dfs_and_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_4963 {

    static int[] dx = new int[]{1, -1, 0, 0, 1, 1, -1, -1};
    static int[] dy = new int[]{0, 0, 1, -1, 1, -1, 1, -1};
    static int w, h;
    static int count;
    static int[][] map;
    static boolean[][] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0) { // 만약 너비와 높이가 모두 0이라면 종료
                break;
            }

            // init
            map = new int[h][w];
            isVisited = new boolean[h][w];
            for (int i = 0; i < h; i++) {
                StringTokenizer st2 = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st2.nextToken());
                }
            }

            // logic
            count = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (!isVisited[i][j]) {
                        bfs(i, j);
                    }
                }
            }

            System.out.println(count);
        }
    }

    private static void bfs(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        if (map[i][j] == 1) {
            queue.offer(new int[]{i, j});
            isVisited[i][j] = true;
            count++;
        }

        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            for (int k = 0; k < 8; k++) {
                int y = poll[0] + dy[k];
                int x = poll[1] + dx[k];

                if (x >= 0 && y >= 0 && x < w && y < h) {
                    if (!isVisited[y][x] && map[y][x] == 1) {
                        isVisited[y][x] = true;
                        queue.offer(new int[]{y, x});
                    }
                }
            }
        }
    }
}
