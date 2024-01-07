package baekjoon.basic1.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int count = 0;

        int[] unit = new int[n];
        for (int i = 0; i < n; i++) {
            unit[i] = Integer.parseInt(br.readLine());
        }

        while (k != 0) {
            int selectedUnit = unit[0];
            for (int i = n - 1; i >= 0; i--) {
                if (unit[i] <= k) {
                    selectedUnit = unit[i];
                    break;
                }
            }
            count += k / selectedUnit;
            k = k % selectedUnit;
        }

        System.out.println(count);
    }
}
