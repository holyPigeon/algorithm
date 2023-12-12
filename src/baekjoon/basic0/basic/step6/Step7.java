package baekjoon.basic0.basic.step6;

import java.io.*;
import java.util.StringTokenizer;

public class Step7 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String str1 = br.readLine();
    StringTokenizer st = new StringTokenizer(str1, " ");

    int x = Integer.parseInt(st.nextToken());
    int y = Integer.parseInt(st.nextToken());
    int x1, x10, x100, y1, y10, y100, newX, newY;

    x1 = x % 10;
    x10 = (x % 100 - x1) / 10;
    x100 = (x % 1000 - x10 - x1) / 100;

    y1 = y % 10;
    y10 = (y % 100 - y1) / 10;
    y100 = (y % 1000 - y10 - y1) / 100;

    newX = x1 * 100 + x10 * 10 + x100;
    newY = y1 * 100 + y10 * 10 + y100;

    if (newX >= newY) {
      bw.write(String.valueOf(newX));
    } else {
      bw.write(String.valueOf(newY));
    }


    bw.flush();
  }
}
