package baekjoon.solutio.study.date_07_06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_1940_S4_Two_Pointer {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];
        int M = Integer.parseInt(br.readLine());;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            int x = numbers[i];
            for (int j = i + 1; j < N; j++) {
                int y = numbers[j];
                if (x + y == M) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
