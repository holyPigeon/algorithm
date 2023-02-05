package baekjoon.step2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Step6 {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    String[] str1 = reader.readLine().split(" ");
    int x = Integer.parseInt(str1[0]);
    int y = Integer.parseInt(str1[1]);

    String str2 = reader.readLine();
    int z = Integer.parseInt(str2);
    int z1, z2;

    z1 = (z / 60);
    z2 = z % 60;

    x += z1;
    y += z2;

    if (y >= 60) {
      x += 1;
      y = y - 60;
    }

    if (x >= 24) {
      x = x - 24;
    }

    System.out.println(x + " " + y);
  }
}