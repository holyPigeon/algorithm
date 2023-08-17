package baekjoon.basic.step9;

import java.io.*;
import java.util.StringTokenizer;

public class Step2 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int[][] arr = new int[9][9];
    int max, row = 0, col = 0;

    for (int i = 0; i < 9; i++) {
      String str = br.readLine();
      StringTokenizer st = new StringTokenizer(str, " ");
      for (int j = 0; j < 9; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    max = arr[0][0];

    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        if (arr[i][j] >= max) {
          max = arr[i][j];
          row = i + 1;
          col = j + 1;
        }
      }
    }

    bw.write(max + "\n");
    bw.write(row + " " + col);

    bw.flush();
  }
}
