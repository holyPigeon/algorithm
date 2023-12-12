package baekjoon.basic0.practice1;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 클래스 활용
 */
public class Problem_11659 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    // 입력값 첫쨰줄
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int len1 = Integer.parseInt(st.nextToken());
    int len2 = Integer.parseInt(st.nextToken());

    // 입력값 첫째줄 바탕으로 숫자 배열, 객체 배열 생성 후 값 주입
    int[] arr1 = new int[len1];
    Range[] arr2 = new Range[len2];

    StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < len1; i++) {
      arr1[i] = Integer.parseInt(st2.nextToken());
    }

    // range 객체에 값 채움 -> 바로 x,y 바탕으로 합 연산 시작 -> 바로 sum 출력 후 sum = 0 처리
    int a, b, sum = 0;
    int[] result = new int[len2];

    for (int i = 0; i < len2; i++) {
      StringTokenizer st3 = new StringTokenizer(br.readLine(), " ");
      int x = Integer.parseInt(st3.nextToken());
      int y = Integer.parseInt(st3.nextToken());
      arr2[i] = new Range(x, y);

      a = arr2[i].x;
      b = arr2[i].y;
      for (int j = a - 1; j <= b - 1; j++) {
        sum += arr1[j];
      }
      bw.write(sum + "\n");
      sum = 0;
    }

    bw.close();
  }

  public static class Range {

    int x;
    int y;

    public Range(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}
