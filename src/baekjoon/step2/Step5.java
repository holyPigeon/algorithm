package baekjoon.step2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Step5 {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    String[] str = reader.readLine().split(" ");
    int x = Integer.parseInt(str[0]);
    int y = Integer.parseInt(str[1]);

    if (y-45 < 0) {
      if (x == 0) {
        x = 23;
      } else {
        x -= 1;
      }
      y = 60 - (45 - y);
    } else {
      y -= 45;
    }
    System.out.println(x + " " + y);
  }
}