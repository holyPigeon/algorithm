package step7;

import java.io.*;

// 1 6 12 18 24 육각형 개수
// 1 2 8 20 38 처음 다음 띄 진입 방 번호
// 6 12 18 간격

public class Step2 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String str = br.readLine();
    int num = Integer.parseInt(str);
    int x = 1;
    int result = num;

    while (result > 1) {
      result -= 6 * x;
      bw.write("result: " + result + ", x: " + x + ", num: " + num + "\n");
      x++;
    }

    bw.write(String.valueOf(x));

    bw.flush();
  }
}
