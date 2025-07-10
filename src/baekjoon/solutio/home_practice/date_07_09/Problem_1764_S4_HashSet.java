package baekjoon.solutio.home_practice.date_07_09;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Problem_1764_S4_HashSet {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> set1 = new HashSet<>();
        Set<String> result = new TreeSet<>();

        for (int i = 0; i < N; i++) {
            String input1 = br.readLine();
            set1.add(input1);
        }

        for (int i = 0; i < M; i++) {
            String input2 = br.readLine();
            if (set1.contains(input2)) {
                result.add(input2);
            }
        }

        sb.append(result.size()).append("\n");
        result.forEach(x -> sb.append(x).append("\n"));
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}
