package baekjoon.basic0.advanced2;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

/*
  - 만난 사람들의 기록이 주어지고 이에 따라 마지막에 무지개 댄스를 몇 명이 추고 있는지 구해보자.

  1. HashMap을 <String, Integer> 타입으로 사용해서 춤추는 사람은 1, 안 추는 사람은 0으로 표시한다.
  2. HashMap에서 해당 닉네임을 포함하지 않는다면 포함시킨다. value는 0으로
  3. 만약 해당 닉네임의 값이 1이라면 옆 사람도 1로 만들고, 아니라면 그대로 간다.
 */

public class Problem_26069 {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();

    int n = Integer.parseInt(br.readLine());
    int result = 0;

    HashMap<String, Integer> map = new HashMap<>();

    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      String s1 = st.nextToken();
      String s2 = st.nextToken();
//      if (i == 0) { // i == 0일 때만 s1을 map에 넣는다. 어차피 i > 0 일 때 s1은 재등장한 닉네임이기 때문.
//        if (!map.containsValue(s1)) {
//          map.put(s1, 0);
//        }
//      } else {
//        if (!map.containsValue(s2)) {
//          if (s2.equals("ChongChong")) { // 만약 s2가 "ChongChong"일 경우
//            map.put(s2, 1);
//          }
//          map.put(s2, 0);
//        }
//        if (map.get(s2) == 1) {
//          map.put(s1, 1);
//          result++;
//        } else if (map.get(s1) == 1) {
//          map.put(s2, 1);
//          result++;
//        }
//      }
      if (!map.containsValue(s1)) { // 기존에 s1이 안 나왔을 때
        map.put(s1, 0);
        if (s2.equals("ChongChong")) { // 만약 s2가 "ChongChong"일 경우
          map.put(s2, 1);
          map.put(s1, 1);
          result++;
        } else if (map.get(s1) == 1) {
          map.put(s2, 1);
          result++;
        }
      }
      if (!map.containsValue(s2)) {
        map.put(s2, 0);
        if (s2.equals("ChongChong")) { // 만약 s2가 "ChongChong"일 경우
          map.put(s2, 1);
          map.put(s1, 1);
          result++;
        } else if (map.get(s2) == 1) {
          map.put(s1, 1);
          result++;
        }
      }
    }

    bw.write(String.valueOf(result));
    bw.close();
  }
}
