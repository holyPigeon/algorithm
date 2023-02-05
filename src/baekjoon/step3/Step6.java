package baekjoon.step3;

import java.io.*;

public class Step6 {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String countStr = reader.readLine();
    int count = Integer.parseInt(countStr);

    int[] number = new int[count * 2];
    int[] sum = new int[count];

    for (int i = 0; i < count; i++) {
      String[] str = reader.readLine().split(" ");
      number[2 * i] = Integer.parseInt(str[0]);
      number[2 * i + 1] = Integer.parseInt(str[1]);
      sum[i] = number[2 * i] + number[2 * i + 1];
    }

    for (int j = 0; j < count; j++) {
      if (j == (count - 1)) {
        bw.write("Case #" + (j + 1) + ": " + sum[j]);
      } else {
        bw.write("Case #" + (j + 1) + ": " + sum[j] + "\n");
      }

    }

    bw.flush();
  }
}