package baekjoon.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 체스판을 칠하자
 * 변을 공유하는 사각형은 다른 색으로 칠해야 한다. -> 어떤 x칸의 상하좌우로는 모두 다른 색이 칠해져야 한다. 경계일 경우 빼고
 */

public class Problem_1018 {

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int n, m;
    static int count;
    static boolean[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new boolean[n + 1][m + 1];

        // input
        for (int i = 1; i < n + 1; i++) {
            String s = br.readLine();
            for (int j = 1; j < m + 1; j++) {
                if (s.charAt(j - 1) == 'W') {
                    map[i][j] = true;
                }
            }
        }

//        for (int i = 1; i < n + 1; i++) {
//            for (int j = 1; j < m + 1; j++) {
//                if (map[i][j] == true) {
//                    System.out.print("W");
//                } else {
//                    System.out.print("B");
//                }
//            }
//            System.out.println();
//        }

        // logic
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                boolean value = map[i][j];
                changeSameColor(i, j, value);
            }
        }


        System.out.println(count);
    }

    private static void changeSameColor(int i, int j, boolean value) {
        for (int k = 0; k < 4; k++) {
            int currentX = i + dx[k];
            int currentY = j + dy[k];
            // 경계를 벗어낫는지 조사
            // 같은 색인지 조사. 같은 색이라면 다른 색으로 바꾸고 count를 1추가
            if (isInsideOfBorder(currentX, currentY)) {
                if (isSameColor(currentX, currentY, value)) {
                    map[currentX][currentY] = !value;
                    count++;
                }
            }
        }
    }

    public static boolean isInsideOfBorder(int x, int y) {
        return x >= 1 || x <= n || y >= 1 || y <= m;
    }

    public static boolean isSameColor(int cx, int cy, boolean value) {
        return map[cx][cy] == value;
    }
}
