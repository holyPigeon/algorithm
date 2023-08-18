package baekjoon.advanced2;

import java.io.*;
import java.util.HashSet;

/*
  - 주어진 닉네임 중에서 1회까지는 횟수를 인정하고 이후 중복된 닉네임의 수를 제외하고 곰곰티콘을 친 수를 반환하자.

  1. Set을 만들어서 해당 집합 안에 포함되지 않은 문자열이라면 포함시킨다. + 횟수를 올린다.
  2. 만약 집합에 포함된 중복된 닉네임이라면 그냥 패스한다.
  3. 만약 입력값이 "ENTER"라면 집합은 초기화된다.
 */

public class Problem_25192 {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();

    int n = Integer.parseInt(br.readLine());
    HashSet<String> set = new HashSet<>();
    int result = 0;

    for (int i = 0; i < n; i++) {
      String s = br.readLine();
      if (s.equals("ENTER")) {
        set.clear();
      } else {
        if (!set.contains(s)) {
          set.add(s);
          result++;
        }
      }
    }

    bw.write(String.valueOf(result));
    bw.close();
  }
}
