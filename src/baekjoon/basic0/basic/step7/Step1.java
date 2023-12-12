package baekjoon.basic0.basic.step7;

import java.io.*;
import java.util.StringTokenizer;

// 해당 알파벳이 최소 한 번 이상은 나와야 함
// 해당 알파벳이 나오고 다른 알파벳이 나왔다가 처음 그 알파벳이 다시 한 번 등장해야 함
// 해당 알파벳과 다음 인덱스 알파벳이 다르면 26개 자리 중 해당 인덱스에 끝났다고 체크, 이후 등장했을 때 isEnd[i] = 1 이면 sum에 포함 X

public class Step1 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String str1 = br.readLine();
    StringTokenizer st = new StringTokenizer(str1, " ");

    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(st.nextToken());
    int x = 0; // 물건 개수
    int pass = 0;

    if (b >= c) {
      pass = 1;
      x = -1;
    }

    if (pass == 0) {
      x = a / (c - b) + 1;
    }


    bw.write(String.valueOf(x));

    bw.flush();
  }
}
