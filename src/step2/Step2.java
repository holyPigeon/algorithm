package step2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Step2 {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    String[] str = reader.readLine().split(" ");
    int x = Integer.parseInt(str[0]);

    if (x <= 100 & x >= 90) {
      System.out.println("A");
    } else if ( x >= 80) {
      System.out.println("B");
    } else if ( x >= 70) {
      System.out.println("C");
    } else if ( x >= 60) {
      System.out.println("D");
    } else {
      System.out.println("F");
    }
  }
}