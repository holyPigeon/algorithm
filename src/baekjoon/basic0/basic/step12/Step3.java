package step12;

import java.io.*;
import java.util.StringTokenizer;

public class Step3 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int testcase = Integer.parseInt(br.readLine());
    int[][] arr = new int[testcase][2];
    int[] rank = new int[testcase];
    int priorityB = 0, count = 0;


    for (int i = 0; i < testcase; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      arr[i][0] = Integer.parseInt(st.nextToken());
      arr[i][1] = Integer.parseInt(st.nextToken());
    }

    for (int i = 0; i < testcase; i++) {
      for (int j = 0; j < testcase; j++) {

        if (arr[i][0] - arr[j][0] < 0) { // B의 몸무게가 더 큰 경우
          priorityB++;
        }

        if (arr[i][1] - arr[j][1] < 0) { // A의 키가 더 큰 경우
          priorityB++;
        }

        if (priorityB == 2) {
          count++;
        }

        priorityB = 0;
      }
      rank[i] = count + 1;
      count = 0;
    }

    for (int i : rank) {
      System.out.print(i + " ");
    }
  }
}
