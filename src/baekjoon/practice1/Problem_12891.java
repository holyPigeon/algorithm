package baekjoon.practice1;

import java.io.*;
import java.util.StringTokenizer;

public class Problem_12891 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    // 코드 실행 전 시간 측정
    long startTime = System.currentTimeMillis();

    /*
      입력
     */
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int len1 = Integer.parseInt(st.nextToken());
    int len2 = Integer.parseInt(st.nextToken());

    char[] str = br.readLine().toCharArray();

    StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
    int[] condition = new int[4];
    for (int i = 0; i < 4; i++) {
      condition[i] = Integer.parseInt(st2.nextToken());
    }

    int[] actual;
    int pass;
    int aPass, cPass, gPass, tPass;
    int count = 0;

    /*
      로직
     */

    // s1 문자열을 len2 만큼 반복문을 돌림 -> 돌리면서 시작 인덱스 1씩 증가
    for (int i = 0; i <= len1 - len2; i++) {
      actual = new int[]{0, 0, 0, 0};
      pass = 0;
      aPass = 0;
      cPass = 0;
      gPass = 0;
      tPass = 0;
      for (int j = i; j < i + len2; j++) {
        // 해당 부분 문자열에 조건 개수만큼의 문자가 있는지 검사
        System.out.print(str[j]);
        if (str[j] == 'A') actual[0]++;
        if (str[j] == 'C') actual[1]++;
        if (str[j] == 'G') actual[2]++;
        if (str[j] == 'T') actual[3]++;

        if (actual[0] >= condition[0] && aPass == 0) {
          aPass = 1;
        }
        if (actual[1] >= condition[1] && cPass == 0) {
          cPass = 1;
        }
        if (actual[2] >= condition[2] && gPass == 0) {
          gPass = 1;
        }
        if (actual[3] >= condition[3] && tPass == 0) {
          tPass = 1;
        }

        if (aPass == 1 && cPass == 1 && gPass == 1 && tPass == 1) {
          pass = 1;
          break;
        }
//        System.out.println("aPass = " + aPass);
//        System.out.println("cPass = " + cPass);
//        System.out.println("gPass = " + gPass);
//        System.out.println("tPass = " + tPass);
      }

//      System.out.println();
//      System.out.println("A actual = " + actual[0] + " A condition = " + condition[0]);
//      System.out.println("C count = " + actual[1] + " C condition = " + condition[1]);
//      System.out.println("G count = " + actual[2] + " G condition = " + condition[2]);
//      System.out.println("T count = " + actual[3] + " T condition = " + condition[3]);
      if (pass == 1) {
        count++;
      }
//      System.out.println("pass -> " + pass);
      System.out.println();
    }
    // 코드 실행 후 시간 측정
    long endTime = System.currentTimeMillis();
    long executionTime = endTime - startTime;
    System.out.println("프로그램 실행 시간: " + executionTime + "ms");

    bw.write(String.valueOf(count));
    bw.close();


  }
}
