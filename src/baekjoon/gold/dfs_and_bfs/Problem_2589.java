package baekjoon.gold.dfs_and_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
theme: 육지로 갈 수 있는 곳 중에서 가장 멀리 떨어진 땅 간의 최단 거리를 구하자.

- dfs 를 통해 파고들면서 도달할 수 있는(육지이고, 아직 방문하지 않은) 곳 중에서 가장 멀리 있는 곳으로 가야 한다.
    - 이후 가장 멀리 있는 블럭까지의 거리(이건 쉬움)와 그곳의 인덱스를 저장한다. -> 저장한 인덱스는
- 다만 가장 효율적으로 가야 하므로, a -> b 로 갈 수 있는 경우의 수들 중 가장 짧게 갈 수 있는 경우의 수를 찾아야 한다.
    - 이를 위해, 각 경우의 수들 마다 해당 블럭까지의 걸린 거리를 기록한다. 매 블럭을 방문할 때마다 여태까지의 최단 거리보다 현재의 거리가 짧은지를 비교한다.
    - 해당 과정을 통해 나온 최솟값이
 */

public class Problem_2589 {

    static int[] dx = {0, 0, 1, -1};
    static int[] dy=  {1, -1, 0, 0};
    static char[][] map;
    static boolean[][] isVisited;
    static int answer;
    static int h;
    static int w;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        map = new char[h][w];
        isVisited = new boolean[h][w];

        // init
        for (int i = 0; i < h; i++) {
            String s = br.readLine();
            for (int j = 0; j < w; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        // logic
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (map[i][j] == 'L') {
                    isVisited = new boolean[h][w];
                    dfs(i, j, 0);
                }
            }
        }

        System.out.println(answer);
    }

    private static void dfs(int i, int j, int distance) {
        if (isVisited[i][j] || map[i][j] == 'W') { // 이미 방문했거나 방문하려는 곳이 바다일 때
            answer = Math.max(answer, distance);
            return;
        }
        isVisited[i][j] = true;

        for (int k = 0; k < 4; k++) {
            int cx = i + dx[k];
            int cy = j + dy[k];

            if (cx >= 0 && cy >= 0 && cx < h && cy < w) {
                if (!isVisited[cx][cy] && map[cx][cy] == 'L') {
                    dfs(cx, cy, distance + 1);
                    answer = Math.max(answer, distance);
                }
            }
        }
        isVisited[i][j] = false;

    }
}
