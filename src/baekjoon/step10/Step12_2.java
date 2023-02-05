package baekjoon.step10;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Step12_2 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String str1 = br.readLine();
    int testcase = Integer.parseInt(str1);
    int[] origin = new int[testcase];
    int[] sorted = new int[testcase];
    int[] result = new int[testcase];
    int rank = 0;
    int[][] sortedMap = new int[testcase][2]; // index 0 -> rank / index 1 -> sorted[i]

    String str2 = br.readLine();
    StringTokenizer st = new StringTokenizer(str2, " ");

    for (int i = 0; i < testcase; i++) {
      origin[i] = Integer.parseInt(st.nextToken());
      sorted[i] = origin[i];
    }
    Arrays.sort(sorted);

    for (int i = 0; i < testcase; i++) {
      sortedMap[i][0] = rank;
      sortedMap[i][1] = sorted[i];
      if (i < testcase - 1) {
        if (sorted[i] != sorted[i + 1]) rank++;
      }
    }

 /*   for (int i = 0; i < testcase; i++) {
      bw.write("rank = " + sortedMap[i][0] + " / sorted[i] = " + sortedMap[i][1] + "\n");
    }*/

    for (int i = 0; i < testcase; i++) {
      for (int j = 0; j < testcase; j++) {
        if (sortedMap[i][1] == origin[j]) {
          result[j] = sortedMap[i][0];
        }
      }
    }

    for (int r : result) {
      bw.write(r + " ");
    }

    bw.flush();
  }
}
