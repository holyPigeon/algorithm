package baekjoon.basic.step9;

import java.io.*;
import java.util.StringTokenizer;

public class Step3 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String str1 = br.readLine();
    int testCase = Integer.parseInt(str1);
    int[][] background = new int[101][101];
    int[][] arr = new int[testCase][2];
    int[] area = new int[testCase + 1];
    int minus = 0, sum = 100 * testCase;

    for (int i = 0; i < testCase; i++) {
      String str2 = br.readLine();
      StringTokenizer st = new StringTokenizer(str2, " ");
      arr[i][0] = Integer.parseInt(st.nextToken());
      arr[i][1] = Integer.parseInt(st.nextToken());
    }

    for (int i = 0; i < testCase; i++) {
      for (int j = arr[i][1]; j < arr[i][1] + 10; j++) {
        for (int k = arr[i][0]; k < arr[i][0] + 10; k++) {
          background[j][k]++;
        }
      }
    }

    for (int i = 0; i < 101; i++) {
      for (int j = 0; j < 101; j++) {
        if (background[i][j] != 0 && background[i][j] != 1) {
          area[background[i][j]]++;
        }
      }
    }

    for (int i = 1; i <= testCase; i++) {
      if (i == 1) {
        continue;
      }
      minus += area[i] * (i - 1);
    }

    sum -= minus;

    bw.write(Integer.toString(sum));

    bw.flush();
  }
}
