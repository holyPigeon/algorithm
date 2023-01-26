package step12;

import java.io.*;

public class Step2_2 {
  public static void main(String[] args) throws IOException {
    long start = System.currentTimeMillis();

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int find = 0;
    int input = Integer.parseInt(br.readLine());

    int n = 0;

    /*while(find == 0) {
      n++;

      if (constructer(n) == input) {
        find = 1;
      }
    }*/

    for (int i = 0; i < input; i++) {
      if (constructer(i) == input) {
        n = i;
        break;
      }
    }

    bw.write(String.valueOf(n));

    long end = System.currentTimeMillis();
    System.out.println("SDB에서 노드생성까지의 실행시간 : " + (end - start)/1000.0);

    bw.flush();
    bw.close();
  }

  static int constructer(int n) {
    int origin = n, sum = 0;

    while(n > 0) {
      sum += n % 10;
      n /= 10;
    }

    sum += origin;

    return sum;
  }
}
