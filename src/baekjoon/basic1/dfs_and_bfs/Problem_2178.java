package baekjoon.basic1.dfs_and_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_2178 {

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int n, m;
    static int[][] path;
    static boolean[][] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        path = new int[n][m];
        isVisited = new boolean[n][m];

        // init
        for (int i = 0; i < n; i++) { // 경로 배열 초기화
            String nodeInput = br.readLine();
            for (int j = 0; j < m; j++) {
                path[i][j] = Integer.parseInt(nodeInput.substring(j, j + 1));
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                isVisited[i][j] = false;
            }
        }

        // logic
        bfs(0, 0);

        System.out.println(path[n - 1][m - 1]);
    }

    public static void bfs(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        isVisited[i][j] = true;
        while(!queue.isEmpty()) {
            int[] currentIndex = queue.poll();
            for (int k = 0; k < 4; k++) {
                int x = currentIndex[0] + dx[k];
                int y = currentIndex[1] + dy[k];
                if (x >= 0 && y >= 0 && x < n && y < m) { // 배열 밖으로 벗어나지 않는지 검증
                    if (path[x][y] == 1) { // 이동할 좌표가 이미 방문한 곳은 아닌지 확인
                        isVisited[x][y] = true;
                        path[x][y] = path[currentIndex[0]][currentIndex[1]] + 1;
                        queue.offer(new int[]{x, y});
                    }
                }
            }
        }
    }
}
