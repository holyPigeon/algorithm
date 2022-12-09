package step3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Step2 {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


    String str = reader.readLine();
    int x, y;
    int[] result = new int[Integer.parseInt(str)];
    for (int i = 0; i < Integer.parseInt(str); i++) {
      String[] str1 = reader.readLine().split(" ");
      x = Integer.parseInt(str1[0]);
      y = Integer.parseInt(str1[1]);
      result[i] = x + y;
    }

    for (int i = 0; i < Integer.parseInt(str); i++) {
      System.out.println(result[i]);
    }
  }
}