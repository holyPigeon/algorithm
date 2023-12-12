package baekjoon.basic0.basic.step10;

import java.io.*;

public class Step5 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int[] arr = new int[10001];

    String str1 = br.readLine();
    int testcase = Integer.parseInt(str1);

    for (int i = 0; i < testcase; i++) {
      String str2 = br.readLine();
      int num = Integer.parseInt(str2);
      arr[num]++;
    }

    for (int i = 1; i <= 10000; i++) {
      for (int j = 0; j <= arr[i]; j++) {
        if (j == 0) {
          continue;
        }
        bw.write(i + "\n");
      }
    }

    bw.flush();
  }
}
