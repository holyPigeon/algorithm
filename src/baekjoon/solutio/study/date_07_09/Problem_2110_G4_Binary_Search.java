package baekjoon.solutio.study.date_07_09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem_2110_G4_Binary_Search {
    static int N, C;
    static long[] houses;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        houses = new long[N];
        C = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            houses[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(houses);

        long min = 0;
        long max = Arrays.stream(houses)
                .max()
                .orElse(houses[0]) + 1;

        System.out.println(upperBound(min, max) - 1);
    }

    private static long upperBound(long low, long high) {
        long mid;
        int key = C;

        while (low < high) {
            mid = (low + high) / 2;

            if (count(mid) >= key) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return high;
    }

    private static int count(long mid) {
        int count = 1;
        int lastIdx = 0;

        for (int i = 0; i < houses.length; i++) {
            if (houses[i] - houses[lastIdx] >= mid) {
                count++;
                lastIdx = i;
            }
        }

        return count;
    }
}
