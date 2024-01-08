package baekjoon.basic1.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] primeNumbers = new int[n + 1];
        for (int i = m; i <= n; i++) {
            if (primeNumbers[i] == -1) {
                continue;
            }
            primeNumbers[i] = m;
            for (int j = m; j <= n; j++) {
                if ((primeNumbers[j] % primeNumbers[i] == 0) && primeNumbers[j] != primeNumbers[i]) {
                    primeNumbers[j] = -1;
                }
            }
        }

        for (int i = m; i < primeNumbers.length; i++) {
            if (primeNumbers[i] != -1) {
                System.out.println(primeNumbers[i]);
            }
        }
    }
}
