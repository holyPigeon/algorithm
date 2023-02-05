package baekjoon.step8;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Step1 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String str1 = br.readLine();
    int testCase = Integer.parseInt(str1);
    String str2 = br.readLine();
    StringTokenizer st = new StringTokenizer(str2, " ");
    int[] primeNum = new int[testCase];
    int[] check = new int[testCase];
    Arrays.fill(check, 1);
    int sum = 0;

    for (int i = 0; i < testCase; i++) {
      primeNum[i] = Integer.parseInt(st.nextToken());
      if (primeNum[i] == 1) {
        check[i] = 0;
      }
      for (int j = 2; j < primeNum[i]; j++) {
        if (primeNum[i] % j == 0) {
          check[i] = 0;
          break;
        }
      }
    }

    for (int i = 0; i < testCase; i++) {
      if (check[i] == 1) {
        sum++;
      }
    }

    bw.write(String.valueOf(sum));


    bw.flush();
  }
}