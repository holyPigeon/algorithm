package baekjoon.solutio.home_practice.date_07_07;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class Problem_4358_S2_TreeMap {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String input;
        Map<String, Integer> map = new TreeMap<>();

        while ((input = br.readLine()) != null ) {
            map.put(input, map.getOrDefault(input, 0) + 1);
        }

        map.forEach((key, value) -> {
            sb.append(key).append(" ").append(calculateRateByKey(map, key)).append("\n");
        });
        bw.write(sb.toString());

        br.close();
        bw.close();
    }

    private static String calculateRateByKey(Map<String, Integer> map, String key) {
        int sum = map.values()
                .stream()
                .mapToInt(Integer::intValue)
                .sum();
        int count = map.get(key);
        double rate = (double) count / sum * 100;

        return String.format("%.4f", rate);
    }
}
