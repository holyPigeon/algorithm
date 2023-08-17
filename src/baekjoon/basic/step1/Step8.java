package baekjoon.basic.step1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Step8 {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    int y = Integer.parseInt(reader.readLine());
    int x = 543;

    int result = y - x;
    System.out.println(result);
  }
}