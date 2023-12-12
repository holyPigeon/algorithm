package baekjoon.basic0.basic.step6;

import java.io.*;
import java.util.StringTokenizer;

public class Step6 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String str1 = br.readLine();

    StringTokenizer st = new StringTokenizer(str1, " ");
    int n = st.countTokens();

    bw.write(String.valueOf(n));

    bw.flush();
  }
}
