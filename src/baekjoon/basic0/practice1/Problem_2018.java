package baekjoon.basic0.practice1;

import java.io.*;

/**
 * 접근 방법:
 * 수의 분할인데 분할되는 숫자가 연속되야 함.
 * 빼는 수를 1씩 늘려서 0보다 같거나 클 떄까지 뺴보고 0이되면 카운트++ 0을 넘어서 마이너스가 되버리면 패스
 */
public class Problem_2018 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    int temp = n;
    int a; // n에서 빼는 숫자
    int count = 0;

    for (int i = 1; i <= n; i++) {
      // 빼는 수의 시작점을 1씩 늘린다.
      // 만약 2가 시작점일 때 15가 0이 되지 않고 그보다 마이너스가 되어버린다면
      // 다시 반복문을 돌려 a를 1씩 올리고 3이 시작점일 때를 시도해본다.
      a = i;
      while(temp >= 0) {
        System.out.println("===========");
        System.out.println("temp = " + temp + " / a = " + a);
        temp = temp - a;
        System.out.println("temp = temp - a = " + temp);
        // 15 = 15-1 = 14
        // 14 = 14-2 = 12
        // 12 = 12-3 = 9
        // 9 = 9-4 = 5
        // 5 = 5-5 = 0

        if (temp == 0) {
          count++;
          System.out.println("Break!");
          break;
        }
        a++;
      }
      temp = n;
    }

    bw.write("count = " + count);
    bw.close();
  }
}