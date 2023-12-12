package baekjoon.basic0.math;

import java.io.*;

public class problem_10988 {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String s = br.readLine();
    int result = 1;
    int c = 0;

    for (int i = 0; i < s.length() - 1; i++) {
      c = s.charAt(i);

      if (c != s.charAt(s.length() - 1 - i)) {
        result = 0;
        break;
      }
    }

    bw.write(String.valueOf(result));

    bw.flush();
  }
}
