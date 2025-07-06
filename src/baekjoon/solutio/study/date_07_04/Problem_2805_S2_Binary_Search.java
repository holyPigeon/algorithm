package baekjoon.solutio.study.date_07_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem_2805_S2_Binary_Search {
    static long[] trees;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st1.nextToken());
        M = Integer.parseInt(st1.nextToken());

        trees = new long[N];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st2.nextToken());
        }

        long min = 1;
        long max = Arrays.stream(trees)
                .max()
                .orElse(trees[0]) + 1;

        long result = upperBound(min, max) - 1;
        System.out.println(result);
    }

    private static long upperBound(long low, long high) {
        long mid;

        while (low < high) {
            mid = (low + high) / 2;

            long sum = sum(mid);
            if (sum >= M) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return high;
    }

    private static long sum(long height) {
        return Arrays.stream(trees)
                .map(tree -> Math.max(tree - height, 0))
                .sum();
    }
}
