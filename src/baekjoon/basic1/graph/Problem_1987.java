package baekjoon.basic1.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem_1987 {

    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};
    static int r, c;
    static char[][] map;
    static int[][] distance;
    static boolean[][] isVisited;
    static Set<Character> visitedSquare;
    static int count;

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
        visitedSquare.add(map[0][0]);
        distance[0][0] = 1;
        List<Integer> distances = new ArrayList<>();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (!visitedSquare.contains(map[i][j])) {
                    count = 0;
                    dfs(0, 0);
                }
            }
        }

        // result
        int max = 1;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (distance[i][j] > max) {
                    max = distance[i][j];
                }
            }
        }

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

    private static void dfs(int i, int j) {

        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];

            if (x >= 0 && y >= 0 && x < r && y < c) {
                if (!visitedSquare.contains(map[x][y])) {
                    visitedSquare.add(map[x][y]);
                    count++;
                    if (count > max) {
                        max = count;
                    }
                    dfs(x, y);
                }
            }
        }


    }

    // 아이디어 1: 방문한 곳을 차레대로 1, 2, 3... 이렇게 채운다. 결론적으로 distance 배열 상에서 가장

    /*private static void bfs(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        visitedSquare.add(map[i][j]);

        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            int oldX = poll[0];
            int oldY = poll[1];

            for (int k = 0; k < 4; k++) {
                int x = oldX + dx[k];
                int y = oldY + dy[k];

                if (x >= 0 && y >= 0 && x < r && y < c) {
                    if (!visitedSquare.contains(map[x][y])) {
                        visitedSquare.add(map[x][y]);
                        if (distance[x][y] < distance[oldX][oldY] + 1) {
                            distance[x][y] = distance[oldX][oldY] + 1;
                        }
                        queue.offer(new int[]{x, y});
                    }
                }
            }
        }
    }*/
}
