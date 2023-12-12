package baekjoon.basic0.basic.step10;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Step2 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    List<Integer> list = new ArrayList<>();
    long sum = 0, avg;

    for (int i = 0; i < 5; i++) {
      String str1 = br.readLine();
      list.add(Integer.parseInt(str1));
    }

    Collections.sort(list);

    for (int i: list) {
      sum += i;
    }

    avg = sum / 5;

    bw.write(avg + "\n");
    bw.write(list.get(2) + "\n");

    bw.flush();
  }
}
