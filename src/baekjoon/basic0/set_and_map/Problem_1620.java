package baekjoon.basic0.set_and_map;

import java.io.*;
import java.util.*;

/*
  - 도감 번호를 보면 포켓몬 이름을, 포켓몬 이름을 보면 도감 번호가 나와야 함 -> HashMap 사용

  1. n번의 for문을 돌려서 입력값을 HashMap에 key 1번부터 저장
  2. m번의 for문을 돌려서 입력값이 숫자라면 해당하는 value 출력, 문자열이라면 해당하는 key 출력
 */
public class Problem_1620 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    HashMap<String, Integer> map = new HashMap<>();
    String[] strArray = new String[n];
    for (int i = 0; i < n; i++) {
      String s = br.readLine();
      map.put(s, i + 1);
      strArray[i] = s;
    }

    for (int i = 0; i < m; i++) {
      String s = br.readLine();
      if (isInteger(s)) {
        sb.append(strArray[Integer.parseInt(s) - 1]);
      } else {
        sb.append(map.get(s));
      }
      sb.append("\n");
    }

    bw.write(sb.toString());
    bw.close();
  }

  public static boolean isInteger(String str) {
    try {
      Integer.parseInt(str);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }
}

