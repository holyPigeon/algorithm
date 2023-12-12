package baekjoon.basic0.basic.step10;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Step3 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    List<Integer> list = new ArrayList<>();

    String str1 = br.readLine();
    StringTokenizer st1 = new StringTokenizer(str1, " ");

    int n = Integer.parseInt(st1.nextToken());
    int k = Integer.parseInt(st1.nextToken());

    String str2 = br.readLine();
    StringTokenizer st2 = new StringTokenizer(str2, " ");

    for (int i = 0; i < n; i++) {
      list.add(Integer.parseInt(st2.nextToken()));
    }

    Collections.sort(list);

    bw.write(list.get(list.size() - k) + "\n");

    bw.flush();
  }
}
