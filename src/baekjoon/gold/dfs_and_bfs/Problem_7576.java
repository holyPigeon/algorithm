package baekjoon.gold.dfs_and_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
theme: 상자 안의 토마토가 모두 익는 최소 일수를 구하시오.

- 솔직히 첫인상: 그냥 전 토마토 문제 하위호환 같음. 똑같이 bfs 쓰면 되는 거 아닌가? -> 일단 풀어보고 안되면 다른 방법 찾기
    - 예상 풀이방법 -> map 배열을 만들고 전 좌표 + 1씩 해서 일 수를 구함 (0인 곳만 가기)
 */

public class Problem_7576 {

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int n;
    static int m;
    static int[][] map;
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int tomato = Integer.parseInt(st2.nextToken());
                map[i][j] = tomato;
                if (tomato == 1) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        bfs();

        int day = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                day = Math.max(day, map[i][j]);
                if (map[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(day - 1);
    }

    private static void bfs() {
        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            int y = poll[0];
            int x = poll[1];

            for (int i = 0; i < 4; i++) {
                int cy = y + dy[i];
                int cx = x + dx[i];

                if (isAvailablePoint(cy, cx)) {
                    map[cy][cx] = map[y][x] + 1;
                    queue.offer(new int[]{cy, cx});
                }
            }
        }
    }

    private static boolean isAvailablePoint(int cy, int cx) {
        return (cy >= 0 && cx >= 0 && cy < n && cx < m)  && (map[cy][cx] == 0);
    }
}
