package baekjoon.basic0.set_and_map;

/*
 - 상근이가 가지고 있는 N개의 숫자카드 중에서 주어진 정수 M개 중 포함된 게 있는지 없는지 판별하자

 1. 먼저 상근이가 가진 정수들을 Set에다가 넣는다.
 2. 주어진 정수들을 M만큼 반복하면서 Set안의 원소들과 일치하는지 확인한다.
 3. 만약 일치한다면 일치 배열값을 1로 만들고 탈출한다.

 */

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Problem_10815 {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    // 입력값 저장
    int n = Integer.parseInt(br.readLine());
    HashSet<Integer> nSet = new HashSet<>(n);
    StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < n; i++) {
      nSet.add(Integer.parseInt(st1.nextToken()));
    }

    int m = Integer.parseInt(br.readLine());
    int[] mArray = new int[m];
    StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < m; i++) {
      mArray[i] = Integer.parseInt(st2.nextToken());
    }

    // 정수 포함여부 확인
    int[] isContain = new int[m];

    for (int i = 0; i < m; i++) {
      if (nSet.contains(mArray[i])) {
        isContain[i] = 1;
      } else {
        isContain[i] = 0;
      }
    }

    // 츌력
    for (int i = 0; i < m; i++) {
      bw.write(isContain[i] + " ");
    }
    bw.close();
  }
}
