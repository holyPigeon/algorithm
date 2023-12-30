package baekjoon.basic1.brute_force;

import java.io.*;

/*
theme: 주어진 N, M에 따라 수열을 출력한다.

- 사실상 nPm 의 개별적인 경우의 수를 나열한 것과 같다.
-
 */

public class Problem_15649 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String[] tokens = br.readLine().split(" ");
        int n = Integer.parseInt(tokens[0]);
        int m = Integer.parseInt(tokens[0]);

        for (int i = 1; i <= n; i++) {

        }
    }

    public static String findAvailableCases(int currentIndex, int n, int m) {

    }
}
