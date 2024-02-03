package baekjoon.gold.dfs_and_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
theme: 시작방에서 끝방으로 가야되는데, 중간에 장애물로 검은 방들로 길이 막혀있다.
만약 검은 방을 치워서 끝 방에 도달할 수 있다면, 그 최소 개수는 몇 개인지 구하자.

- 첫 인상: 존1나 어려울 것 같다. ㅋㅋㅋㅋ 접근 방법은 미로찾기 느낌이기 때문에 아마도 dfs일 것. 그 중에서도 백트래킹일 가능성이 높음.
- 검은 방이 나오면 뚫고 지나가면서 count++. 끝방에 도달했을 경우 count가 가장 낮은 놈이 정답이 된다.
    - 근데 솔직히 어떻게 만들어야될 지 모르겠음. 전에 백트래킹 문제 푼 걸 참고해야될 듯
 */

public class Problem_2665 {

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int n;
    static int[][] map;
    static boolean[][] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        isVisited = new boolean[n][n];

        // init
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = line.charAt(j) - 48;
            }
        }

        dfs();
    }

    private static void dfs() {
        isVisited[0][0] = true;
    }

    private static boolean isAvailablePoint(int cy, int cx) {
        return (cy >= 0 && cx >= 0 && cy < n && cx < n)  && (map[cy][cx] == 1);
    }
}
