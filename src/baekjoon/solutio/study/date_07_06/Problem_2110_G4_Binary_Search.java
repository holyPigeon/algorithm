package baekjoon.solutio.study.date_07_06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem_2110_G4_Binary_Search {
    static long[] houses;
    static int N, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        houses = new long[N];
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

    // 최대 인접 거리를 찾아야 하기 때문에 upper bound 사용
    private static long upperBound(long low, long high) {
        long mid;

        while (low < high) {
            mid = (low + high) / 2;

            if (availableCount(mid) >= C) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return high;
    }

    // 인접 거리 조건에 따른 공유기 설치 가능 개수를 구함
    private static int availableCount(long mid) {
        int count = 1;
        long lastX = houses[0]; // 일단 제일 첫 번째 좌표에 공유기 설치

        for (int i = 0; i < houses.length; i++) {
            long x = houses[i];

            // 조건보다 넓은 간격을 가진 집이라면 공유기 설치
            if (x - lastX >= mid) {
                lastX = x;
                count++;
            }
        }

        return count;
    }
}
