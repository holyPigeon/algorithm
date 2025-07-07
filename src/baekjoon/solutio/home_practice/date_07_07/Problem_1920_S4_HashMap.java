package baekjoon.solutio.home_practice.date_07_07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Problem_1920_S4_HashMap {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<Integer, Integer> numbers = new HashMap<>();

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(st1.nextToken());
            numbers.put(number, numbers.getOrDefault(number, 0) + 1);
        }

        int M = Integer.parseInt(br.readLine());

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int key = Integer.parseInt(st2.nextToken());
            if (numbers.containsKey(key)) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }


    }
}
