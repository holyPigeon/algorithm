package baekjoon.practice1;

import java.io.*;
import java.util.StringTokenizer;

public class Problem_1940 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int a = Integer.parseInt(br.readLine());
    int b = Integer.parseInt(br.readLine());
    int count = 0;
    int[] arr = new int[a];

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < a; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    for (int i = 0; i < a; i++) {
      for (int j = i + 1; j < a; j++) {
        if (arr[i] + arr[j] == b) {
          count++;
        }
      }
    }

    bw.write(String.valueOf(count));
    bw.close();

  }
}
