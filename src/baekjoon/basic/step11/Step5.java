package baekjoon.basic.step11;

import java.io.*;

public class Step5 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    int count = 0;

    while (n >= 3) {
      n /= 3;
      count++;
    }

    bw.write(count + " ");

    bw.flush();
  }
}
