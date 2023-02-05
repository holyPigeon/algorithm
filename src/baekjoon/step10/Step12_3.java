package baekjoon.step10;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Step12_3 {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int testcase = Integer.parseInt(br.readLine());

    int[] origin = new int[testcase];	// 원본 배열
    int[] sorted = new int[testcase];	// 정렬 할 배열
    HashMap<Integer, Integer> rankingMap = new HashMap<Integer, Integer>();	// rank를 매길 HashMap

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    for(int i = 0; i < testcase; i++) {
      // 정렬할 배열과 원본 배열에 값을 넣어준다.
      sorted[i] = origin[i] = Integer.parseInt(st.nextToken());
    }

    // 정렬 할 배열에 대해 정렬을 수행해준다.
    Arrays.sort(sorted);


    // 정렬 된 배열을 순회하면서 map에 넣어준다.
    int rank = 0;
    for(int v : sorted) {
      /*
       *  이 때 만약 앞선 원소가 이미 순위가 매겨졌다면
       *  중복되면 안되므로, 원소가 중복되지 않을 때만
       *  map에 원소와 그에 대응되는 순위를 넣어준다.
       */
      if(!rankingMap.containsKey(v)) {
        rankingMap.put(v, rank);
        rank++;		// map에 넣고나면 다음 순위를 가리킬 수 있도록 1을 더해준다.
      }
    }

    int[] result = new int[testcase];

    for (int i = 0; i < testcase; i++) {
      result[i] = rankingMap.get(origin[i]);
    }

    for (int r : result) {
      bw.write(r + " ");
    }

    bw.flush();
  }
}
