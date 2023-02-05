package baekjoon.step3;

import java.io.*;

public class Step12 {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    String stringX = reader.readLine();
    int count = 0;
    int x = Integer.parseInt(stringX);
    int x10, x1;
    int y1, y;
    String result;

    int initialX = x;

    do {
      if (x < 10) { // 처음 주어진 수가 10보다 작을 때
        result = Integer.toString(x) + x;
      } else { // 처음 주어진 수가 10보다 클 때
        x1 = x % 10;
        x10 = (x - x1) / 10;
        y = x10 + x1;
        if (y < 10) { // 첫 연산 후 나온 결과물이 10보다 작을 때
          y1 = y;
        } else { // 첫 연산 후 나온 결과물이 10보다 클 때
          y1 = y % 10;
        }
        result = Integer.toString(x1) + y1;
      }
      x = Integer.parseInt(result);
      count++;
    } while(x != initialX);

    bw.write(""+count);


    bw.flush();
  }
}