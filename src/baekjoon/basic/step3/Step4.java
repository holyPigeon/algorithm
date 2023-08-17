package baekjoon.basic.step3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Step4 {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    String str1 = reader.readLine();
    int totalPrice = Integer.parseInt(str1);
    String str2 = reader.readLine();
    int totalCount = Integer.parseInt(str2);

    int[] price = new int[totalCount * 2];
    int[] sum = new int[totalCount];
    int totalSum = 0;
    String isSame;

    for (int i = 0; i < totalCount; i++) {
      String[] str = reader.readLine().split(" ");
      price[2 * i] = Integer.parseInt(str[0]);
      price[2 * i + 1] = Integer.parseInt(str[1]);
      sum[i] = price[2 * i] * price[2 * i + 1];
      totalSum += sum[i];
    }

    if ( totalPrice == totalSum ) {
      isSame = "Yes";
    } else {
      isSame = "No";
    }



    System.out.println(isSame);
  }
}