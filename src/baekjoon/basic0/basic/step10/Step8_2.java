package baekjoon.basic0.basic.step10;

import java.io.*;
import java.util.*;

public class Step8_2 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String str1 = br.readLine();
    int testcase = Integer.parseInt(str1);

    int[][] point = new int[testcase][2];

    for (int i = 0; i < testcase; i++) {
      String str2 = br.readLine();
      StringTokenizer st = new StringTokenizer(str2, " ");

      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());

      point[i][0] = x;
      point[i][1] = y;
    }

    Arrays.sort(point, (p1, p2) -> {
      if (p1[0] == p2[0]) {
        return p1[1] - p2[1];
      } else {
        return p1[0] - p2[0];
      }
    });

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < point.length; i++) {
      sb.append(point[i][0] + " " + point[i][1]).append('\n');
    }

    bw.write(sb + "\n");

    bw.flush();
  }
}
