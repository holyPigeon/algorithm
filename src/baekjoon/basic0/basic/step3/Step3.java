package baekjoon.basic0.basic.step3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Step3 {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


    String str = reader.readLine();
    int x = Integer.parseInt(str);
    int sum = 0;

    for (int i = 1; i <= x; i++) {
      sum += i;
    }

    System.out.println(sum);
  }
}