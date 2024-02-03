package baekjoon.gold.dfs_and_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
theme: 시작방에서 끝방으로 가야되는데, 중간에 장애물로 검은 방들로 길이 막혀있다.
만약 검은 방을 치워서 끝 방에 도달할 수 있다면, 그 최소 개수는 몇 개인지 구하자.

- 첫 인상: 존1나 어려울 것 같다. ㅋㅋㅋㅋ 접근 방법은 미로찾기 느낌이기 때문에 아마도 dfs 일 것. 그 중에서도 백트래킹일 가능성이 높음.
- 검은 방이 나오면 뚫고 지나가면서 count++. 끝방에 도달했을 경우 count 가 가장 낮은 놈이 정답이 된다.
    - 근데 솔직히 어떻게 만들어야될 지 모르겠음. 전에 백트래킹 문제 푼 걸 참고해야될 듯

- 풀다가 막힌 부분: 최대한 안 막힌 곳으로 가다가 막힌 부분이 나오면 뚫는 전략을 사용하고 있다. 대충 디버깅으로 보니까 이 방법이 맞는 것 같기는 한데,
지금 리스트 이용해서 갈 수 있는 길, 못 가는 길 체크하는 부분이 메모리가 많이 드는 것 같다. -> 개선이 필요한 듯
 */

public class Problem_2665 {

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int n;
    static int[][] map;
    static boolean[][] isVisited;
    static int minBreakCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        isVisited = new boolean[n][n];

        // init
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = line.charAt(j) - 48;
                if (map[i][j] == 0) {
                    minBreakCount++;
                }
            }
        }

        dfs(0, 0, 0);

        System.out.println(minBreakCount);
    }

    private static void dfs(int i, int j, int breakCount) {
        if (breakCount > minBreakCount) { // 이미 부순 벽이 ㅈㄴ 많아서 가망이 없다면 돌아오기
            return;
        }
        if (i == n - 1 && j == n - 1) { // 끝방에 도달했다면 부순 벽의 개수 체크 및 최솟값 갱신
            minBreakCount = Math.min(minBreakCount, breakCount);
            return;
        }

        isVisited[i][j] = true;
        List<int[]> unAvailableRoute = new ArrayList<>();

        // 갈 수 있는 길을 미리 조사한다.
        for (int k = 0; k < 4; k++) {
            int ci = i + dy[k];
            int cj = j + dx[k];

            // 갈 수 있는 길을 미리 조사한다.
            if (isAvailablePoint(ci, cj)) {
                if (map[ci][cj] == 1) { // 갈 수 있는 길을 추가
                    dfs(ci, cj, breakCount);
                } else if (map[ci][cj] == 0) { // 갈 수 없는 길을 추가
                    unAvailableRoute.add(new int[]{ci, cj});
                }
            }
        }

        // 정 갈 길이 없으면 벽을 뚫는다.
        for (int[] point : unAvailableRoute) {
            dfs(point[0], point[1], ++breakCount);
        }

        isVisited[i][j] = false;
    }

    private static boolean isAvailablePoint(int ci, int cj) {
        return (ci >= 0 && cj >= 0 && ci < n && cj < n) && !isVisited[ci][cj];
    }
}
