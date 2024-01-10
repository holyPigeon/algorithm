package baekjoon.basic1.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem_11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // init
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] time = new int[N];
        for (int i = 0; i < N; i++) {
            time[i] = Integer.parseInt(st.nextToken());
        }

        // logic
        Arrays.sort(time);

        int result = 0;
        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = i; j >= 0; j--) {
                sum += time[j];
            }
            result += sum;
        }

        System.out.println(result);
    }
}
