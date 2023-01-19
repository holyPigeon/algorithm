package step11;

import java.io.*;

public class Step1 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());

    bw.write(Integer.toString(factorial(n)));

    bw.flush();
  }

  public static int factorial(int n) {
    if (n > 0) {
      return n * factorial(n-1);
    } else {
      return 1;
    }

  }
}
