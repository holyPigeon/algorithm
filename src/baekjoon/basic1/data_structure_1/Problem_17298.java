package baekjoon.basic1.data_structure_1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
title: 오큰수를 구하는 것

- 오큰수란 주어진 수열의 원소인 x가 있다고 할 때, x 오른쪽에 있는 수 중에서 x보다 큰 수 중 가장 왼쪽에 있는 수를 뜻한다.
- 수열의 길이가 5라면, 1번째 원소부터 5번째 원소까지의 오큰수를 모두 구하면 된다.
 */

public class Problem_17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int count = Integer.parseInt(br.readLine());
        String[] tokens = br.readLine().split(" ");
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            numbers.add(Integer.parseInt(tokens[i]));
        }

        boolean isBigNumberFound;

        for (int i = 0; i < count; i++) {
            isBigNumberFound = false;
            for (int j = i + 1; j < count; j++) {
                if (isBigNumberFound) {
                    continue;
                }
                if (numbers.get(i) < numbers.get(j)) {
                    sb.append(numbers.get(j)).append(" ");
                    isBigNumberFound = true;
                }
            }
            if (!isBigNumberFound) {
                sb.append(-1).append(" ");
            }
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
