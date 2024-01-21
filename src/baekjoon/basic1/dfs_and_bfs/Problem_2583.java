package baekjoon.basic1.dfs_and_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// (0,2), (4,4)
// (2,0), (4,4) x, y축 바꾸기
// (5-2,0), (5-4,4) 세로만 반전
// (3,0), (1,4)
// (3,0), (1,4)

public class Problem_2583 {

    static int[] dx = {0, 0, 1, -1};
    static int[] dy=  {1, -1, 0, 0};
    static int[][] map;
    static boolean[][] isVisited;
    static List<Integer> areas;
    static int area;
    static int M;
    static int N;
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        isVisited = new boolean[M][N];
        areas = new ArrayList<>();

        // init
        for (int i = 0; i < K; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int[] point1 = new int[2];
            int[] point2 = new int[2];

            point1[0] = Integer.parseInt(st2.nextToken());
            point1[1] = Integer.parseInt(st2.nextToken());
            point2[0] = Integer.parseInt(st2.nextToken());
            point2[1] = Integer.parseInt(st2.nextToken());

            int[] convertedPoint1 = convertToIndex(point1);
            int[] convertedPoint2 = convertToIndex(point2);
            for (int j = convertedPoint2[0]; j < convertedPoint1[0]; j++) {
                for (int k = convertedPoint1[1]; k < convertedPoint2[1]; k++) {
                    map[j][k] = 1;
                }
            }
        }

        // logic
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0 && !isVisited[i][j]) {
                    area = 0;
                    bfs(i, j);
                    areas.add(area);
                }
            }
        }

        // sort
        Collections.sort(areas);

        System.out.println(areas.size());
        for (Integer area : areas) {
            System.out.print(area + " ");
        }
    }

    private static int[] convertToIndex(int[] point) {
        // x, y축 바꾸기
        int temp = point[0];
        point[0] = point[1];
        point[1] = temp;

        // 세로 반전
        point[0] = M - point[0];
        
        return point;
    }

    private static void bfs(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        isVisited[i][j] = true;
        area++;

        while(!queue.isEmpty()) {
            int[] poll = queue.poll();

            for (int k = 0; k < 4; k++) {
                int cx = poll[0] + dx[k];
                int cy = poll[1] + dy[k];

                if (cx >= 0 && cy >= 0 && cx < M && cy < N && (!isVisited[cx][cy] && map[cx][cy] == 0)) {
                        isVisited[cx][cy] = true;
                        area++;
                        queue.offer(new int[]{cx, cy});
                }
            }
        }
    }
}
