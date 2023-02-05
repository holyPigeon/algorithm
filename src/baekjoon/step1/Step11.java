package baekjoon.step1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Step11 {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    String str1 = reader.readLine();
    int x = Integer.parseInt(str1);
    String str2 = reader.readLine();
    int y = Integer.parseInt(str2);

    int x1 = x % 10;
    int x10 = x % 100 -x1;
    int x100 = x % 1000 -x10 - x1;

    int y1 = y % 10;
    int y10 = y % 100 -y1;
    int y100 = y % 1000 -y10 -y1;

    int result3 = x1 * y1 + x10 * y1 + x100 * y1;
    int result4 = (x1 * y10 + x10 * y10 + x100 * y10) / 10;
    int result5 = (x1 * y100 + x10 * y100 + x100 * y100) / 100;
    int result6 = result3 + 10 * result4 + 100 * result5;

    System.out.println(result3);
    System.out.println(result4);
    System.out.println(result5);
    System.out.println(result6);
  }
}