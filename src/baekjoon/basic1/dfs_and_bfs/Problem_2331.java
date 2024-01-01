package baekjoon.basic1.dfs_and_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Problem_2331 {

    static int a;
    static int p;
    static List<Integer> numbers;
    static List<Integer> repeatedNumbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        a = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        numbers = new ArrayList<>();
        repeatedNumbers = new ArrayList<>();

        func(a);

        for (int i = 0; i < repeatedNumbers.size(); i++) {
            numbers.remove(repeatedNumbers.get(i));
        }

        System.out.println(numbers.size());
    }

    public static void func(int x) {
        String input = String.valueOf(x);
        int[] splitNumbers = new int[input.length()];
        for (int i = 0; i < input.length(); i++) {
            splitNumbers[i] = Integer.parseInt(String.valueOf(input.charAt(i)));
        }

        int sum = Arrays.stream(splitNumbers)
                .map(number -> (int)Math.pow(number, p))
                .sum();

        // x: 57 sum: 74 65 61
        // 57 x: 74 sum: 65 61

        if (numbers.contains(x)) {
            if (repeatedNumbers.contains(sum)) {
                return;
            } else {
                repeatedNumbers.add(sum);
            }
            func(sum);
        } else {
            numbers.add(x);
            func(sum);
        }

    }
}
