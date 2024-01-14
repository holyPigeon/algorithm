package baekjoon.basic1.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
theme: 배추밭에 배추지렁이가 몇 마리 필요한지 구하자.

- 배추지렁이는 "인접한" 배추로 이동할 수 있다. 따라서 BFS 를 사용해서 탐색하는 것이 좋아보인다.
- 인접한 모든 배추로 이동하고, 더 이상 이동할 수 없을 때(BFS 가 종료될 때)마다 count 를 증가시킨다면 될 것 같다.
 */

public class Problem_1012 {

    static int n, m, k;
    static int[][] array;
    static boolean[][] isVisited;
    static int[] dx = new int[]{0, 0, 1, -1};
    static int[] dy = new int[]{1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testcase; i++) {
            // init
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            array = new int[n][m];
            isVisited = new boolean[n][m];

            for (int j = 0; j < k; j++) {
                StringTokenizer st2 = new StringTokenizer(br.readLine());
                array[Integer.parseInt(st2.nextToken())][Integer.parseInt(st2.nextToken())] = 1;
            }

            // logic
            int count = 0;
            for (int j = 0; j < n; j++) {
                for (int l = 0; l < m; l++) {
                    if (!isVisited[j][l] && array[j][l] == 1) {
                        bfs(j, l);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }


    }

    private static void bfs(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        isVisited[i][j] = true;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            for (int k = 0; k < 4; k++) {
                int x = poll[0] + dx[k];
                int y = poll[1] + dy[k];

                if (x >= 0 && y >= 0 && x < n && y < m) {
                    if (!isVisited[x][y] && array[x][y] == 1) {
                        isVisited[x][y] = true;
                        queue.offer(new int[]{x, y});
                    }
                }
            }
        }
    }
}
