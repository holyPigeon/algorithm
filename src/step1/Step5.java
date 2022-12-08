package step1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Step5 {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    String[] str = reader.readLine().split(" ");
    double x1 = Double.parseDouble(str[0]);
    double x2 = Double.parseDouble(str[1]);

    System.out.println(x1 / x2);
  }
}