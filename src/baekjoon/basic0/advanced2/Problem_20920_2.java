package baekjoon.basic0.advanced2;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Problem_20920_2 {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    // 입력값 받기
    HashMap<String, Integer> map = new HashMap<>(); // 단어와 해당 단어의 빈도수
    for (int i = 0; i < n; i++) {
      String s = br.readLine();
      if (s.length() >= m) {
        // 만약 map에 해당 문자열이 들어있다면 -> 해당 문자열 key의 value값이 반환되고 그것에 +1된 값이 새로 주입된다.
        // 만약 map에 해당 문자열이 들어있지 않다면 -> key: 해당 문자열, value: 0 + 1의 값이 새로 주입된다.
        map.put(s, map.getOrDefault(s, 0) + 1);
      }
    }

    List<String> words = map.keySet().stream().collect(Collectors.toList());

    List<String> result = words.stream().sorted((w1, w2) -> {
      int count1 = map.get(w1);
      int count2 = map.get(w2);

      if (count1 != count2) {
        return Integer.compare(count2, count1);
      } else {
        int lengthCompare = Integer.compare(w2.length(), w1.length());
        if (lengthCompare != 0) {
          return lengthCompare;
        } else {
          return w1.compareTo(w2);
        }
      }
    }).collect(Collectors.toList());

    for (int i = 0; i < result.size(); i++) {
      sb.append(result.get(i)).append("\n");
    }

    bw.write(sb.toString());
    bw.close();
  }
}
