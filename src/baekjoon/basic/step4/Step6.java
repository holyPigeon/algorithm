package baekjoon.basic.step4;

import java.io.*;

public class Step6 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    int[] array1 = new int[10];
    int[] array2 = new int[10];
    int x;
    int sum = 0;

    for (int i = 0; i < 10; i++) {
      String stringX = br.readLine();
      x = Integer.parseInt(stringX);
      array1[i] = x;
    }

    for (int i = 0; i < 10; i++) {
      array2[i] = array1[i] % 42;
    }

    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 10; j++) {
        if (i != j) {
          if (array2[j] != -1) {
            if (array2[i] == array2[j]) {
              array2[j] = -1;
            }
          }
        }
      }
    }

    for (int i = 0; i < 10; i++) {
      if (array2[i] != -1) {
        sum++;
      }
    }

    bw.write(String.valueOf(sum));

    bw.flush();
  }
}

