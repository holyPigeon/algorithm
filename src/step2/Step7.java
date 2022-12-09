package step2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Step7 {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    String[] str = reader.readLine().split(" ");
    int x = Integer.parseInt(str[0]);
    int y = Integer.parseInt(str[1]);
    int z = Integer.parseInt(str[2]);

    int money = 0;

    if ((x == y) && (y == z)) {
      money = 10000 + x * 1000;
    } else if ((x == y) || (y == z) || (z == x)) {
      if (x == y) {
        money = 1000 + x * 100;
      } else if (y == z) {
        money = 1000 + y * 100;
      } else if (z == x) {
        money = 1000 + z * 100;
      }
    } else {
      if ((x > y) && ( x > z)) {
        money = x * 100;
      } else if ((y > x) && (y > z)) {
        money = y * 100;
      } else {
        money = z * 100;
      }
    }
    System.out.println(money);
  }
}