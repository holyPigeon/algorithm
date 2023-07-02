package baekjoon.practice1;

import java.io.*;

public class Problem_2444 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());

    for (int i = 0; i < n - 1; i++) {
      for (int j = 0; j < n - i - 1; j++) {
        bw.write(" ");
      }
      for (int j = 0; j < i * 2 + 1; j++) {
        bw.write("*");
      }
      bw.write("\n");
    }

    for (int i = 0; i < 2 * n - 1; i++) {
      bw.write("*");
    }
    bw.write("\n");

    for (int i = n - 2; i >= 0; i--) {
      for (int j = 0; j < n - i - 1; j++) {
        bw.write(" ");
      }
      for (int j = 0; j < i * 2 + 1; j++) {
        bw.write("*");
      }
      bw.write("\n");
    }

    bw.close();
  }
}
