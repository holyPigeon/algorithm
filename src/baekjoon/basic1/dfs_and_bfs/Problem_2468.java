package baekjoon.basic1.dfs_and_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
theme: 내린 비의 높이가 1~100일 때, 모든 케이스르 아울러 최대 안전지대 개수는 몇 개인지 구하자.

- 먼저 bfs를 통해 탐색을 진행한다.
- 1차적으로 배열 상에서 물에 잠긴 부분을 파악한다.
- bfs 를 통해 안전지대임을 확인한다.
    - 침수되지 않은 곳을 계속해서 bfs? 또는 dfs 를 통해 탐색한다.
    - 이 때, 4방향의 가능한 모두가 침수되어 있으면 끝내고, 열려있는 곳이 있다면 그 곳을 탐색한다. (bfs 라면 큐에 넣기)
 */

public class Problem_2468 {

    static int n;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] map;
    static boolean[][] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        // init
        int maxHeight = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, map[i][j]);
            }
        }

        // logic
        int max = 0;
        for (int i = 1; i <= maxHeight; i++) {
            int count = 0;
            isVisited = new boolean[n][n];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (!isVisited[j][k] && map[j][k] > i) {
                        count++;
                        bfs(j, k, i);
                    }
                }
            }
            max = Math.max(max, count);
        }

//        result.forEach(number -> System.out.print(number + " "));
        System.out.println(max);
    }

    private static void bfs(int i, int j, int height) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        isVisited[i][j] = true;

        while (!queue.isEmpty()) {
            int[] currentIndex = queue.poll();
            for (int k = 0; k < 4; k++) {
                int x = currentIndex[0] + dx[k];
                int y = currentIndex[1] + dy[k];

                if (x >= 0 && y >= 0 && x < n && y < n) {
                    if (!isVisited[x][y] && map[x][y] > height) {
                        isVisited[x][y] = true;
                        queue.offer(new int[]{x, y});
                    }
                }
            }
        }
    }

    private static void dfs(int x, int y, int height) {
        isVisited[x][y] = true;
        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx > n - 1 || ny > n - 1) continue;
            if(isVisited[nx][ny]) continue;
            if(map[nx][ny]> height) {
                dfs(nx,ny, height);
            }
        }
    }
}
