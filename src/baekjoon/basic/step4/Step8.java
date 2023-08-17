package baekjoon.basic.step4;

import java.io.*;

public class Step8 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String stringN = br.readLine();
    int n = Integer.parseInt(stringN);
    int stack = 0;
    int score = 0;
    int[] sum = new int[n];
    int len;

    String str1;

    for (int i = 0; i < n; i++) {
      str1 = br.readLine();
      len = str1.length();
      for (int j = 0; j < len; j++) {
        if (str1.charAt(j) == 'O') {
          score = 1 + stack;
          stack++;
        } else if (str1.charAt(j) == 'X') {
          score = 0;
          stack = 0;
        }
        sum[i] += score;
      }
      score = 0;
      stack = 0;
    }

    for (int i = 0; i < n - 1; i++){
        bw.write(sum[i] + "\n");
    }
    bw.write(String.valueOf(sum[n - 1]));

    bw.flush();
  }
}

