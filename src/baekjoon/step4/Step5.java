package baekjoon.step4;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Step5 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    int[] array1 = new int[30];
    int x;
    ArrayList<Integer> array2 = new ArrayList<>();

    Arrays.fill(array1, 0);

    for (int i = 0; i < 28; i++) {
      String stringX = br.readLine();
      x = Integer.parseInt(stringX);

      array1[x - 1] = 1;
    }

    for (int i = 0; i < 30; i++) {
      if (array1[i] == 0) {
        array2.add(i + 1);
      }
    }

    bw.write(array2.get(0) + "\n" + array2.get(1));

    bw.flush();
  }
}

