package step1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Step7 {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    String text1 = reader.readLine();
    String text2 = "??!";

    String result = text1.concat(text2);
    System.out.println(result);
  }
}