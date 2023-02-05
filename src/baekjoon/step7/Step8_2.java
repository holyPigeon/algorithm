package baekjoon.step7;

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Step8_2 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String str = br.readLine();
    StringTokenizer st = new StringTokenizer(str, " ");
    String str1, str2;
    str1 = st.nextToken();
    str2 = st.nextToken();
    BigInteger bigNum1 = new BigInteger(str1);
    BigInteger bigNum2 = new BigInteger(str2);

    bw.write(bigNum1.add(bigNum2) + " ");

    bw.flush();
  }
}