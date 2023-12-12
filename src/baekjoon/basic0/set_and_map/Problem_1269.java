package baekjoon.basic0.set_and_map;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

/*
  - 두 집합의 대칭차집합의 원소 개수를 구한다.

  1. 첫째 집합을 m번 반복문 돌려서 포함하고 있는 요소를 제거한다.
  2. 둘쨰 집합을 n번 반복문 돌려서 포함하고 있는 요소를 제거한다.
  3. 첫쨰 집합에 .addAll(둘쨰집합) 연산해서 둘을 합친다.
  4. 합친 집합 result의 size를 출력한다.
 */

public class Problem_1269 {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    HashSet<Integer> set1 = new HashSet<>(n);
    HashSet<Integer> set2 = new HashSet<>(n);

    StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < n; i++) {
      set1.add(Integer.parseInt(st2.nextToken()));
    }
    StringTokenizer st3 = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < m; i++) {
      set2.add(Integer.parseInt(st3.nextToken()));
    }

    HashSet<Integer> originSet1 = new HashSet<>(set1);

    for (Integer k2 : set2) {
      set1.remove(k2);
    }

    for (Integer k1 : originSet1) {
      set2.remove(k1);
    }

    set1.addAll(set2);
    bw.write(String.valueOf(set1.size()));
    bw.close();
  }
}
