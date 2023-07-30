package baekjoon.set_and_map;

import java.io.*;
import java.util.HashSet;

/*
  - 주어진 문자열 S의 <서로 다른> 부분 문자열 개수를 구하자.

  1. 문자열 S를 받고 S의 길이를 구한다.
  2. 문자열 S를 이중 반복문을 돌려서 j의 한도 n이 1씩 커지게끔 설정한다.
  3. n이 s의 길이가 될 때까지 돌리고 그 과정에서 만약 해당 회차의 부분
    문자열이 이미 Set 안에 포함되어 있다면 count를 증가시키지 않는다.
 */

public class Problem_11478 {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();

    String s = br.readLine();
    int len = s.length();
    int count = 0, n = 0;
    HashSet<String> set = new HashSet<>();

    for (int i = 1; i <= len; i++) {
      while(n + i <= len) {
        String s2 = s.substring(n, n + i);
        if (!set.contains(s2)) {
          set.add(s2);
          count++;
        }
        n++;
      }
      n = 0;
    }

    bw.write(String.valueOf(count));
    bw.close();
  }
}
