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
        int firstNumber = arr[x][y];
        boolean divide = false;
        int dividedN = N / 2;
        if (N == 1) {
            if (firstNumber == 0) {
                whiteCount++;
            } else {
                blueCount++;
            }
            return;
        }

        for (int i = x; i < x + N; i++) {
            for (int j = y + 1; j < y + N; j++) {
                if (arr[i][j] != firstNumber) {
                    divide = true;
                    break;
                }
            }
        }

        if (divide) {
            divide(arr, x, y , dividedN);
            divide(arr, x + dividedN, y , dividedN);
            divide(arr, x, y + dividedN , dividedN);
            divide(arr, x + dividedN, y + dividedN, dividedN);
        } else {
            if (firstNumber == 0) {
                whiteCount++;
            } else {
                blueCount++;
            }
        }
    }

    private static
}
