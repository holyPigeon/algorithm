package baekjoon.solutio.study.date_07_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem_1654_S2_BinarySearch {
    static int[] LANs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        LANs = new int[K];
        for (int i = 0; i < K; i++) {
            LANs[i] = Integer.parseInt(br.readLine());
        }
        long high = Arrays.stream(LANs)
                .min()
                .orElse(LANs[0]);

        System.out.print(search(1, high, N));
    }

    // low -> 랜선의 최소 길이
    // high -> 랜선의 최대 길이
    // key -> 희망하는 랜선 조각 개수
    private static long search(long low, long high, int key) {
        while (low <= high) {
            long mid = (low + high) / 2;
            int count = calculateCount((int) mid);

            if (count >= key) { // 랜선 조각이 목표 개수(11)에 다다랐더라도, 계속해서 low 를 올린다.
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return high;
    }

    private static int calculateCount(int LAN) {
        return (int) Arrays.stream(LANs)
                .map(number -> number / LAN)
                .sum();
    }
}
