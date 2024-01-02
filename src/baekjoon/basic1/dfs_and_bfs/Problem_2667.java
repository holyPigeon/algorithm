package baekjoon.basic1.dfs_and_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem_2667 {

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int n;
    static int[][] map;
    static boolean[][] isVisited;
    static int count = 0;
    static List<Integer> result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        isVisited = new boolean[n][n];
        result = new ArrayList<>();

        // init
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(line.substring(j, j + 1));
                isVisited[i][j] = false;
            }
        }

        // logic
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1 && !isVisited[i][j]) {
                    count++;
                    result.add(0);
                    bfs(i, j);
                }
            }
        }

        Collections.sort(result);
        System.out.println(count);
        result.forEach(System.out::println);

    }

    public static void bfs(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        isVisited[i][j] = true;
        result.set(count - 1, result.get(count - 1) + 1);

        while (!queue.isEmpty()) {
            int[] currentIndex = queue.poll();
            for (int k = 0; k < 4; k++) {
                int x = currentIndex[0] + dx[k];
                int y = currentIndex[1] + dy[k];

                if (x >= 0 && y >= 0 && x < n && y < n) {
                    if (map[x][y] == 1 && !isVisited[x][y]) {
                        isVisited[x][y] = true;
                        result.set(count - 1, result.get(count - 1) + 1);
                        queue.offer(new int[]{x, y});
                    }
                }
            }
        }
    }
}
