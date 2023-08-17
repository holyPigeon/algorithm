package baekjoon.basic.step4;

import java.io.*;

public class Step1 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String stringX = br.readLine();
    int x = Integer.parseInt(stringX);
    int count = 0;
    int[] array1 = new int[x];

    String[] arrayX = br.readLine().split(" ");

    for (int i = 0; i < array1.length; i++) {
      array1[i] = Integer.parseInt(arrayX[i]);
    }

    String stringY = br.readLine();
    int y = Integer.parseInt(stringY);

    for (int i : array1) {
      if (i == y) {
        count++;
      }
    }

    bw.write(String.valueOf(count));

    bw.flush();
  }
}

