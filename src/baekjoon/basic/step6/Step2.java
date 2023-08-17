package baekjoon.basic.step6;

import java.io.*;

public class Step2 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String stringN = br.readLine();
    int n = Integer.parseInt(stringN);
    char[] charNum = new char[n];
    int sum = 0;

    String stringNum = br.readLine();

    for (int i = 0; i < n; i++) {
      charNum[i] = stringNum.charAt(i);
      sum += Character.getNumericValue(charNum[i]);
    }

    bw.write(String.valueOf(sum));

    bw.flush();
  }
}
