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
    static int houseCount;
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
                houseCount = 0;
                if (!isVisited[i][j]) {
                    bfs(i, j);
                    result.add(houseCount);
                }
            }
        }

        Collections.sort(result);
        System.out.println(result.size());
        result.forEach(System.out::println);
    }

    public static void bfs(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        isVisited[i][j] = true;

        while (!queue.isEmpty()) {
            int[] currentIndex = queue.poll();
            for (int k = 0; k < 4; k++) {
                int x = currentIndex[0] + dx[k];
                int y = currentIndex[1] + dy[k];

                if (x >= 0 && y >= 0 && x < n && y < n) {
                    if (!isVisited[x][y]) {
                        isVisited[x][y] = true;
                        houseCount++;
                        queue.offer(new int[]{x, y});
                    }
                }
            }
        }
    }
}
