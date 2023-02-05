package baekjoon.step7;

import java.io.*;

public class Step6 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String str1 = br.readLine();
    int testCase = Integer.parseInt(str1);
    int sum = 0;

    for (int i = 0; i < testCase; i++) {
      String str2 = br.readLine();
      int k = Integer.parseInt(str2); // k층
      String str3 = br.readLine();
      int n = Integer.parseInt(str3); // n호, n호에는 n명이 산다.

      int[][] room = new int[k+1][14];

      for (int j = 0; j < 14; j++) { // 0층의 i호를 i명이 들어감
        room[0][j] = j + 1;
      }

      for (int l = 1; l <= k; l++) {
        for (int m = 0; m < 14; m++) {
          for (int p = 0; p <= m; p++) {
            sum += room[l-1][p];
          }
          if (m == 0) { // 1호일 때
            room[l][m] = 1;
          } else if (m == 1) { // 2호일 때
            room[l][m] = room[l-1][m] + 1;
          } else {
            room[l][m] = sum;
          }
          sum = 0;
        }
      }

//       각 방의 인원 표시
//      for (int j = k - 1; j >= 0; j--) {
//        for (int m = 0; m < 14; m++) {
//          bw.write(room[j][m] + " ");
//        }
//        bw.write("\n");
//      }
//      bw.write("\n");

      bw.write(room[k][n-1] + "\n");
    }

    bw.flush();
  }
}