package step8;

import java.io.*;

public class Step1_2 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String str = br.readLine();

    int i;
    int num = Integer.parseInt(str);

    for (i = 2; i < num; i++) {
      if (num % i == 0) {
        break;
      }
    }

    if (num == i) {
      bw.write(i + " " + num + "은 소수가 맞음");
    } else {
      bw.write(i + " " + num + "은 소수가 아님");
    }

    bw.flush();
  }
}