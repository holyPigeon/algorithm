package baekjoon.step9;

import java.io.*;
import java.util.StringTokenizer;

public class Step1 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String str1 = br.readLine();
    StringTokenizer st1 = new StringTokenizer(str1, " ");
    int n = Integer.parseInt(st1.nextToken());
    int m = Integer.parseInt(st1.nextToken());
    int[][] arr1 = new int [n][m];
    int[][] arr2 = new int [n][m];
    int[][] sum = new int [n][m];


    for (int i = 0; i < n; i++) {
      String str2 = br.readLine();
      StringTokenizer st2 = new StringTokenizer(str2, " ");
      for (int j = 0; j < m; j++) {
        arr1[i][j] = Integer.parseInt(st2.nextToken());
      }
    }

    for (int i = 0; i < n; i++) {
      String str2 = br.readLine();
      StringTokenizer st2 = new StringTokenizer(str2, " ");
      for (int j = 0; j < m; j++) {
        arr2[i][j] = Integer.parseInt(st2.nextToken());
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        sum[i][j] = arr1[i][j] + arr2[i][j];
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        bw.write(sum[i][j] + " ");
      }
      bw.write("\n");
    }

    bw.flush();
  }
}
