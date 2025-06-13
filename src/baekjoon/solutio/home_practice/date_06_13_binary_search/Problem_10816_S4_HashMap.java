package baekjoon.solutio.home_practice.date_06_13_binary_search;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Problem_10816_S4_HashMap {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int number = Integer.parseInt(st1.nextToken());
            map.put(number, map.getOrDefault(number, 0) + 1);
        }

        int N = Integer.parseInt(br.readLine());
        int[] myCards = new int[N];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            myCards[i] = Integer.parseInt(st2.nextToken());
            sb.append(map.getOrDefault(myCards[i], 0));
            sb.append(" ");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}
