package baekjoon.basic0.advanced2;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Problem_26069_2 {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();

    int n = Integer.parseInt(br.readLine());

    HashSet<String> set = new HashSet<>();
    set.add("ChongChong");

    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      String s1 = st.nextToken();
      String s2 = st.nextToken();

      if (set.contains(s1) || set.contains(s2)) {
        set.add(s1);
        set.add(s2);
      }
    }

    bw.write(String.valueOf(set.size()));
    bw.close();
  }
}
