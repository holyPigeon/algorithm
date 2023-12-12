package baekjoon.basic0.basic.step2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Step4 {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    String str1 = reader.readLine();
    String str2 = reader.readLine();

    int x = Integer.parseInt(str1);
    int y = Integer.parseInt(str2);

    if (x > 0 && y > 0) {
      System.out.println("1");
    } else if (x < 0 && y > 0) {
      System.out.println("2");
    } else if (x < 0 && y < 0) {
      System.out.println("3");
    } else if (x > 0 && y < 0) {
      System.out.println("4");
    }
  }
}