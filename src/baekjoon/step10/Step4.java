package baekjoon.step10;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Step4 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    List<Integer> list = new ArrayList<>();

    String str1 = br.readLine();
    int testcase = Integer.parseInt(str1);

    for (int i = 0; i < testcase; i++) {
      String str2 = br.readLine();
      list.add(Integer.parseInt(str2));
    }

    Collections.sort(list);

    for (int i: list) {
      bw.write(i + "\n");
    }

    bw.flush();
  }
}
