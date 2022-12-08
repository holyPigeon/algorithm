package step1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Step9 {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    String[] str = reader.readLine().split(" ");
    int x0 = Integer.parseInt(str[0]);
    int x1 = Integer.parseInt(str[1]);
    int x2 = Integer.parseInt(str[2]);
    int x3 = Integer.parseInt(str[3]);
    int x4 = Integer.parseInt(str[4]);
    int x5 = Integer.parseInt(str[5]);

    int y0 = 1;
    int y1 = 1;
    int y2 = 2;
    int y3 = 2;
    int y4 = 2;
    int y5 = 8;

    int[] result = new int[6];
    result[0] = y0 - x0;
    result[1] = y1 - x1;
    result[2] = y2 - x2;
    result[3] = y3 - x3;
    result[4] = y4 - x4;
    result[5] = y5 - x5;

    for (int i=0; i<6; i++) {
      System.out.print(result[i] + " ");
    }
  }
}