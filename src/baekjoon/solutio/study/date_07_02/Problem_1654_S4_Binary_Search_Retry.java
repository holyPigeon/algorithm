package baekjoon.solutio.study.date_07_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem_1654_S4_Binary_Search_Retry {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        long[] LANs = new long[K];
        for (int i = 0; i < K; i++) {
            LANs[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(LANs);

        long min = 1;
        long max = Arrays.stream(LANs)
                .max()
                .orElse(LANs[0]) + 1;

        long result = search(LANs, min, max, N);
        System.out.println(result - 1);
    }

    private static long search(long[] LANs, long low, long high, int N) {
        long mid;

        while (low < high) {
            mid = (low + high) / 2;
            long divide = divide(LANs, mid);
            if (divide < N) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return high;
    }

    private static long divide(long[] LANs, long x) {
        return Arrays.stream(LANs)
                .map(LAN -> LAN / x)
                .sum();
    }
}
