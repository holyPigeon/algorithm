package baekjoon.basic0.basic.step10;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;

public class Step7 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String str1 = br.readLine();
    int num = Integer.parseInt(str1);
    ArrayList<Integer> arr = new ArrayList<>();

    while(num > 0) {
      arr.add(num % 10);
      num /= 10;
    }

    arr.sort(Comparator.reverseOrder());

    for (int i: arr) {
      bw.write(Integer.toString(i));
    }

    bw.flush();
  }
}
