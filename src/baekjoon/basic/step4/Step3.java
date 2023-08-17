package baekjoon.basic.step4;

import java.io.*;
import java.util.StringTokenizer;

public class Step3 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String string1 = br.readLine();
    int n = Integer.parseInt(string1);

    String string2 = br.readLine();
    StringTokenizer st1 = new StringTokenizer(string2, " ");
    String[] array1 = new String[n];

    for (int i = 0; i < n; i++) {
      array1[i] = st1.nextToken();
    }

    int min = Integer.parseInt(array1[0]);
    int max = Integer.parseInt(array1[0]);

    for (String i: array1) {
      if (Integer.parseInt(i) < min) {
        min = Integer.parseInt(i);
      }
      if (Integer.parseInt(i) > max) {
        max = Integer.parseInt(i);
      }
    }

    bw.write(min + " " + max);

    bw.flush();
  }
}

