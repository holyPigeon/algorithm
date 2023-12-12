package baekjoon.basic0.practice1;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 수행 시간 최적화
 * -> 매번 구간의 합 연산을 하는 게 아닌, 구간의 합을 미리 구해놓고 필요할 때 꺼내쓰는 방식
 * -> 한 단계 발전, (2,5) 구간합은 인덱스 5까지의 누적합 - 인덱스 1까지의 누적합인 것을 이용하여 계산
 */
public class Problem_11659_2 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    // 입력값 첫쨰줄
    StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
    int len1 = Integer.parseInt(st1.nextToken());
    int len2 = Integer.parseInt(st1.nextToken());

    // 입력값 첫째줄 바탕으로 숫자 배열, 객체 배열 생성 후 값 주입
    int[] arr = new int[len1]; // i까지의 누적합


    StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
    arr[0] = Integer.parseInt(st2.nextToken());
    for (int i = 1; i < len1; i++) {
      arr[i] = arr[i-1] + Integer.parseInt(st2.nextToken());
    }

    // range 객체에 값 채움 -> 바로 x,y 바탕으로 합 연산 시작 -> 바로 sum 출력 후 sum = 0 처리
    int a, b;

    for (int i = 0; i < len2; i++) {
      StringTokenizer st3 = new StringTokenizer(br.readLine(), " ");
      a = Integer.parseInt(st3.nextToken());
      b = Integer.parseInt(st3.nextToken());

      if (a==1) {
        bw.write(arr[b-1] + "\n");
        continue;
      }
      bw.write(arr[b-1] - arr[a-2] + "\n");
    }

    bw.close();
  }
}
