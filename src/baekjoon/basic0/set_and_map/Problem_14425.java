package baekjoon.basic0.set_and_map;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

/*
  - 기존에 있는 문자열 집합 S에 주어진 문자열이 포함되어 있는지 판별한다.

  1. 먼저 주어진 집합 S에 문자열들을 추가한다.
  2. for문을 통해 다음 줄부터 판별할 문자열들을 입력으로 받으면서 동시에 S에 포함되어 있는지 판별한다.
  3. 만약 포함되어 있다면 count++; 한다.
 */
public class Problem_14425 {
  public static void main(String[] args) throws IOException {

    // 입력값 입력
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    HashSet<String> set = new HashSet<>(n);
    int count = 0;

    for (int i = 0; i < n; i++) {
      set.add(br.readLine());
    }

    // 판별
    for (int i = 0; i < m; i++) {
      if (set.contains(br.readLine())) {
        count++;
      }
    }

    bw.write(String.valueOf(count));
    bw.close();
  }
}
