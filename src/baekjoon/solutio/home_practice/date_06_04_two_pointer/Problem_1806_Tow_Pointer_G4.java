package baekjoon.solutio.home_practice.date_06_04_two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_1806_Tow_Pointer_G4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] numbers = new int[N + 1];
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st1.nextToken());
        }

        int left = 0;
        int right = 0;
        int minimumLength = N + 1;
        int sum = 0;
        while (left <= right && right <= N) {
            if (sum < S) {
                sum += numbers[right++];
            } else {
                minimumLength = Math.min(right - left, minimumLength);
                sum -= numbers[left++];
            }
        }

        if (minimumLength == N + 1) {
            System.out.println(0);
        } else {
            System.out.println(minimumLength);
        }
    }
}
