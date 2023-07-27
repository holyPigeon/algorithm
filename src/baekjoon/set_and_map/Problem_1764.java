package baekjoon.set_and_map;

import java.io.*;
import java.util.*;

/*
  - n개의 이름 명단과 m개의 이름 명단 둘 다에 속하는 개수와 이름들을 출력한다.

  1. 집합에 n개 명단을 넣는다.
  2. m개 명단을 받으면서 n개 명단에 포함되어 있는지 확인, 포함되어 있다면 결과 리스트에 추가한다.
 */

public class Problem_1764 {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    HashSet<String> set = new HashSet<>(n);
    for (int i = 0; i < n; i++) {
      set.add(br.readLine());
    }

    List<String> result = new ArrayList<>();
    for (int i = 0; i < m; i++) {
      String s = br.readLine();
      if(set.contains(s)) {
        result.add(s);
      }
    }

    Collections.sort(result);

    int size = result.size();
    sb.append(size).append("\n");
    if (size != 0) {
      for (int i = 0; i < size; i++) {
        sb.append(result.get(i)).append("\n");
      }
    }

    bw.write(sb.toString());
    bw.close();
  }
}
