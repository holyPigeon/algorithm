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

        // init
        int[] primeNumbers = new int[n + 1];
        for (int i = 0; i < primeNumbers.length; i++) {
            primeNumbers[i] = i;
        }

        // logic
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (primeNumbers[i] == 0) {
                continue;
            }
            primeNumbers[i] = i;
            for (int j = i + i; j <= n; j = j + i) {
                    primeNumbers[j] = 0;
            }
        }

        for (int i = m; i < primeNumbers.length; i++) {
            if (primeNumbers[i] != 0) {
                System.out.println(primeNumbers[i]);
            }
        }
    }
}
