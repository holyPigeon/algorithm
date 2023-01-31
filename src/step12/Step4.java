package step12;

import java.io.*;
import java.util.StringTokenizer;

public class Step4 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    char[][] chess = new char[n][m];
    int[][] counts = new int[n - 7][m - 7];

    for (int i = 0; i < n; i++) {
      String str = br.readLine();
      for (int j = 0; j < m; j++) {
        chess[i][j] = str.charAt(j);
      }
    }

    for (int i = 0; i < n - 7; i++) {
      for (int j = 0; j < m - 7; j++) {
        if (chess[i][j] == 'B') {
          for (int k = i; k < i + 8; k++) {
            for (int l = j; l < j + 8; l++) {
              // 알맞게 색칠.
            }
          }
        }
      }
    }

    printArray(chess, n, m);
  }

  public static void printArray(char[][] arr, int n, int m) {
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        System.out.print(arr[i][j]);
      }
      System.out.println();
    }
  }

  public static void rePaint(char[][]arr) {

  }
}
