package step2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Step3 {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    String[] str = reader.readLine().split(" ");
    int x = Integer.parseInt(str[0]);

    if ((x % 4 == 0)) {
      if ((x % 100 != 0) || (x % 400 == 0)) {
        System.out.println("1");
      } else {
        System.out.println("0");
      }
    } else {
      System.out.println("0");
    }
  }
}