package baekjoon.step8;

import java.io.*;
import java.util.ArrayList;

public class Step2 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String str1 = br.readLine();
    int n1 = Integer.parseInt(str1);
    String str2 = br.readLine();
    int n2 = Integer.parseInt(str2);

    ArrayList<Integer> primeNum = new ArrayList<>();
    int sum = 0, min, j;

    for (int i = n1; i <= n2; i++) {
      for (j = 2; j < i; j++) {
        if (i % j == 0) {
          break;
        }
      }

      if (i == j) {
        primeNum.add(i);
      }
    }

    if (primeNum.isEmpty()) {
      bw.write("-1");
    } else {
      min = primeNum.get(0);

      for (Integer i : primeNum) {
        if (i < min) {
          min = i;
        }
        sum += i;
      }

      bw.write(sum + "\n");
      bw.write(min + "\n");
    }

    bw.flush();
  }
}