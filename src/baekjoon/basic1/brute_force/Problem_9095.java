package baekjoon.basic1.brute_force;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
theme: 수의 분할 구현하기

- 1부터 n - 1까지 여러가지 조합을 이용해 어떻게 n을 만들 수 있는지 생각해본다.
    - 예를 들어, 1만을 이용해 4를 만드려면 1+1+1+1이 필요하다.
    - 예를 들어, 1과 2를 이용해 4를 만드려면, 2가 한 번 들어갈 경우, 2 + 1 + 1, 1 + 2 + 1, 1 + 1 + 2가 필요
    -
 */

public class Problem_9095 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int count = Integer.parseInt(br.readLine());

        int[] memo = new int[11];
        memo[0] = 0;
        memo[1] = 1;
        memo[2] = 2;
        memo[3] = 4;

        for (int i = 4; i < 11; i++) {
            memo[i] = memo[i - 1] + memo[i - 2] + memo[i - 3];
        }

        for (int i = 0; i < count; i++) {
            System.out.println(memo[Integer.parseInt(br.readLine())]);
        }
    }
}
