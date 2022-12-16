package step4;

import java.io.*;

public class Step4 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    int[] array1 = new int[9];
    int index = 1;

    for (int i = 0; i < 9; i++) {
      String string1 = br.readLine();
      array1[i] = Integer.parseInt(string1);
    }

    int max = array1[0];

    for (int i = 0; i < 9; i++) {
      if (array1[i] > max) {
        max = array1[i];
        index = i + 1;
      }
    }

    bw.write(max + "\n");
    bw.write(String.valueOf(index));

    bw.flush();
  }
}

