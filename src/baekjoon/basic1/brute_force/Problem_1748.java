package baekjoon.basic1.brute_force;

import java.io.*;

/*
solution: 각 자리수를 계산할 때, 메모리 및 시간적으로 가장 효율적인 방법은 i가 0이 될 때까지 10으로 나누고 누적된 횟수를 반환하는 것이다.
 */

public class Problem_1748 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int count = Integer.parseInt(br.readLine());
        int result = 0;

        for (int i = 1; i <= count; i++) {
            result += getDigit(i);
        }

        System.out.println(result);
    }

    public static int getDigit(int i) {
        int digit = 0;
        while(i > 0) {
            i /= 10;
            digit++;
        }

        return digit;
    }
}
