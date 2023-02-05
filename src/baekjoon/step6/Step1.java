package baekjoon.step6;

import java.io.*;

public class Step1 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String str1 = br.readLine();
    int num = str1.charAt(0);

    bw.write(String.valueOf(num));

    bw.flush();
  }
}
