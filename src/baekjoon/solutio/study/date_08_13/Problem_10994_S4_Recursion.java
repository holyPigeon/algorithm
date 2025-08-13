package baekjoon.solutio.study.date_08_13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_10994_S4_Recursion {
    static StringBuilder sb;
    static boolean[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int length = 1 + 4 * (N - 1);
        arr = new boolean[length][length];

        start(N, 0);
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (arr[i][j]) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    private static void start(int N, int start) {
        if (N == 0) {
            return;
        }
        int length = 1 + 4 * (N - 1);
        int end = start + length;
        for (int i = start; i < end; i++) {
            if (i == start || i == end - 1) {
                for (int j = start; j < end; j++) {
                    arr[i][j] = true;
                }
            } else {
                for (int j = start; j < end; j++) {
                    if (j == start || j == end - 1) {
                        arr[i][j] = true;
                    }
                }
            }
        }
        start(N - 1, start + 2);
    }
}