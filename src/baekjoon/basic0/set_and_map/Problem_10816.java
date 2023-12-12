package baekjoon.basic0.set_and_map;

/*
  - 입력값으로 주어진 숫자를 상근이가 몇 개 가지고 있는 지 출력한다.

  1. 배열을 통해 n 개의 상근이 숫자 저장
  2. 배열을 통해 m 개의 주어진 숫자 저장
  3. for문 돌면서 같은 숫자가 나오면 카운트 배열값 1 상승
 */

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Problem_10816 {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();

    int n = Integer.parseInt(br.readLine());
    HashMap<Integer, Integer> map = new HashMap<>(n);
    StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < n; i++) {
      int k = Integer.parseInt(st1.nextToken());
      map.put(k, map.getOrDefault(k, 0) + 1);
    }

    int m = Integer.parseInt(br.readLine());
    StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < m; i++) {
      int k = Integer.parseInt(st2.nextToken());
      sb.append(map.getOrDefault(k, 0)).append(" ");
    }

    bw.write(sb.toString());
    bw.close();
  }
}
