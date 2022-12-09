package step3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Step1 {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    String str = reader.readLine();
    int x = Integer.parseInt(str);


    for (int i = 1; i <= 9; i++) {
      System.out.println(x + " * " + i + " = " + x * i);
    }
  }
}