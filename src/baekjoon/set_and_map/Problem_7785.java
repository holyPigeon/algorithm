package baekjoon.set_and_map;

import java.io.*;
import java.util.Comparator;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.util.stream.Collectors;

/*
  - 입력에 따라 집합에서 문자열을 추가, 또는 제거하여 마지막에 집합에 남은 문자열을 출력하기

  1. 첫째줄에서 n을 입력으로 받아들인다.
  2. n만큼 반복문을 돌려서 StringTokenizer의 두 번째 토큰이 enter인 경우 첫 번째 토큰 문자열을 집합에 추가하고, leave라면 삭제한다.
 */

public class Problem_7785 {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    TreeSet<String> set = new TreeSet<>(Comparator.reverseOrder());

    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      String name = st.nextToken();
      if (st.nextToken().equals("enter")) {
        set.add(name);
      } else {
        set.remove(name);
      }
    }

    for (String s : set) {
      bw.write(s + "\n");
    }
    bw.close();
  }
}
