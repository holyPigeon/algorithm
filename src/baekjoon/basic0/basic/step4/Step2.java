package baekjoon.basic0.basic.step4;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Step2 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String string1 = br.readLine();
    StringTokenizer st1 = new StringTokenizer(string1, " ");
    int n = Integer.parseInt(st1.nextToken());
    int x = Integer.parseInt(st1.nextToken());


    String string2 = br.readLine();
    StringTokenizer st2 = new StringTokenizer(string2, " ");
    String[] array1 = new String[n];
    ArrayList<String> array2 = new ArrayList<>();


    for (int i = 0; i < n; i++) {
      array1[i] = st2.nextToken();
    }

    for (String i: array1) {
      if (Integer.parseInt(i) < x) {
        array2.add(i);
      }
    }

    String result = String.join(" ", array2);

    bw.write(result);

    bw.flush();
  }
}

