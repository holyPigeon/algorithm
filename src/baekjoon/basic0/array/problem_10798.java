package baekjoon.basic0.array;

import java.io.*;

public class problem_10798 {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String s = br.readLine();
    int size = Integer.parseInt(s);
    int[] arr = new int[size];

    for (int i = 0; i < size; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    for (int i = 0; i < size; i++) {
      divide(arr[i]);
    }
  }

  public static void divide(int num) { // 124

    int num1 = num / 25; // 4
    int num2 = (num - 25 * num1) / 10; // 24 / 10
    int num3 = (num - 25 * num1 - 10 * num2) / 5;
    int num4 = (num - 25 * num1 - 10 * num2 - 5 * num3);

    System.out.println(num1 + " " + num2 + " " + num3 + " " + num4);
  }
}
