package baekjoon.basic0.basic.step1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Step10 {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    String[] str = reader.readLine().split(" ");
    int a = Integer.parseInt(str[0]);
    int b = Integer.parseInt(str[1]);
    int c = Integer.parseInt(str[2]);

    int[] result;
    result = new int[4];
    result[0] = (a+b)%c;
    result[1] = ((a%c) + (b%c))%c;
    result[2] = (a*b)%c;
    result[3] = ((a%c) * (b%c))%c;

    for (int i=0; i<4; i++) {
      System.out.println(result[i]);
    }
  }
}