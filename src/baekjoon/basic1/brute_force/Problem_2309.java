package baekjoon.basic1.brute_force;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
title: 일곱 난쟁이의 키가 9개 주어지는데, 이 중에서 합이 100인 조합을 찾아 오름차순 정렬로 출력한다.
 */

public class Problem_2309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        List<Integer> heights = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            heights.add(Integer.parseInt(br.readLine()));
        }

        int sum = heights.stream()
                .mapToInt(Integer::intValue)
                .sum();

        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {
                int x = heights.get(i);
                int y = heights.get(j);
                if (sum - x - y == 100) {
                    heights.set(i, 0);
                    heights.set(j, 0);

                    heights.remove(Integer.valueOf(0));
                    heights.remove(Integer.valueOf(0));

                    heights.stream()
                            .sorted()
                            .forEach(System.out::println);
                    return;
                }
            }
        }
    }
}
