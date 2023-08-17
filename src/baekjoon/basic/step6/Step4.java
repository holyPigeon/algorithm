package baekjoon.basic.step6;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Step4 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String str1 = br.readLine();
    int testCase = Integer.parseInt(str1);
    String[] result = new String[testCase];

    Arrays.fill(result, "");

    for (int i = 0; i < testCase; i++) {

      String str2 = br.readLine();
      StringTokenizer st = new StringTokenizer(str2, " ");
      int repeatNum = Integer.parseInt(st.nextToken());
      String originStr = st.nextToken();
      int len = originStr.length();
      char[] str = new char[len];

      for (int j = 0; j < len; j++) {
        str[j] = originStr.charAt(j);
        for (int k = 0; k < repeatNum; k++) {
          result[i] += str[j];
        }
      }
    }

    for (int i = 0; i < testCase; i++) {
      bw.write(result[i] + "\n");
    }

    bw.flush();
  }
}
