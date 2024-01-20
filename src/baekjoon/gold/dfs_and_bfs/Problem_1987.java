package baekjoon.gold.dfs_and_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem_1987 {

    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};
    static int r;
    static int c;
    static char[][] map;
    static int[][] distance;
    static boolean[][] isVisited;
    static Set<Character> visitedSquare;
    static int max = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new char[r][c];
        distance = new int[r][c];
        isVisited = new boolean[r][c];
        visitedSquare = new HashSet<>();

        // init
        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        // logic
        dfs(0, 0, 0);

        System.out.println(max);
    }

    /*
    - 정리를 해보자.

    - dfs 를 통해 갈 수 있는 모든 길을 탐색해서 최대한의 이동거리를 구해야한다.
    - 일단 현재까지의 로직을 통해 1가지 시도는 해볼 수 있다.
    - 한 번의 탐색이 끝났을 시점을 감지해서 방문한 칸을 모두 지우고 다시 탐색해야 한다.
        - 더 이상 주변에 이동 가능한 칸이 없을 떄 -> 사방을 탐색했는데 모두 이동 불가할 때
            - 이동 불가 -> 모서리거나 이동할 칸이 이미 밟은 알파벳
     */

    private static void dfs(int i, int j, int distance) {
        if (visitedSquare.contains(map[i][j])) {
            max = Math.max(max, distance);
            return;
        }

        visitedSquare.add(map[i][j]);
        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];

            if (x >= 0 && y >= 0 && x < r && y < c) {
                dfs(x, y, distance + 1);
            }
        }
        visitedSquare.remove(map[i][j]);
    }
}
