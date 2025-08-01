package baekjoon.solutio.home_practice.date_07_31_recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_2630_S2_Recursion {
    static int[][] arr;
    static int whiteCount = 0;
    static int blueCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divide(arr, 0, 0, N);

        System.out.println(whiteCount);
        System.out.println(blueCount);
    }

    private static void divide(int[][] arr, int x, int y, int N) {
        if (isColorSame(arr, x, y, N)) {
            if (arr[x][y] == 0) {
                whiteCount++;
            } else {
                blueCount++;
            }
            return;
        }

        int newN = N / 2;

        divide(arr, x, y , newN);
        divide(arr, x + newN, y , newN);
        divide(arr, x, y + newN , newN);
        divide(arr, x + newN, y + newN, newN);
    }

    private static boolean isColorSame(int[][] arr, int x, int y, int N) {
        for (int i = x; i < x + N; i++) {
            for (int j = y; j < y + N; j++) {
                if (arr[i][j] != arr[x][y]) {
                    return false;
                }
            }
        }

        return true;
    }
}
