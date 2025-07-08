package baekjoon.solutio.home_practice.date_07_07;

import java.io.*;
import java.net.NetPermission;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Problem_20291_S3_TreeMap {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        Map<String, Integer> map = new TreeMap<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), ".");
            String s1 = st.nextToken();
            String s2 = st.nextToken();

            map.put(s2, map.getOrDefault(s2, 0) + 1);
        }

        map.forEach((key, value) -> sb.append(key).append(" ").append(value).append("\n"));
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}
