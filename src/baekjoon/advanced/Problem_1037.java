package baekjoon.advanced;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Problem_1037 {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();

    int n = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    ArrayList<Integer> list = new ArrayList<>();

    int min = 0, max = 0;

    for (int i = 0; i < n; i++) {
      list.add(Integer.parseInt(st.nextToken()));
      if (i == 0) {
        min = list.get(0);
        max = list.get(0);
      } else {
        if (list.get(i) < min) {
          min = list.get(i);
        }
        if (list.get(i) > max) {
          max = list.get(i);
        }
      }
    }
    sb.append(min * max);
    bw.write(sb.toString());
    bw.close();
  }
}
