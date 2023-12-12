package baekjoon.basic0.practice1;

import java.io.*;
import java.util.StringTokenizer;

public class Problem_12891_2 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

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

    int[] actual = new int[]{0, 0, 0, 0};
    int count = 0;

    /*
      로직
     */

    // 첫 인덱스일 때
    for (int i = 0; i < len2; i++) {
      if (str[i] == 'A') actual[0]++;
      if (str[i] == 'C') actual[1]++;
      if (str[i] == 'G') actual[2]++;
      if (str[i] == 'T') actual[3]++;
    }

    if (actual[0] >= condition[0] && actual[1] >= condition[1] && actual[2] >= condition[2] && actual[3] >= condition[3]) {
      count++;
    }

    // 첫 인덱스에서 얻은 actual 배열 값을 바탕으로 옆으로 이동
    for (int i = 0; i < len1 - len2; i++) { // i = 0 ~ 2

      if (i + len2 == len1) {
        continue;
      }
      System.out.print("문자열 -> ");
      for (int j = i + 1; j < i + len2 + 1; j++) {
        System.out.print(str[j]);
      }
      System.out.println();
      if (str[i] == 'A') actual[0]--;
      if (str[i] == 'C') actual[1]--;
      if (str[i] == 'G') actual[2]--;
      if (str[i] == 'T') actual[3]--;

      if (str[i + len2] == 'A') actual[0]++;
      if (str[i + len2] == 'C') actual[1]++;
      if (str[i + len2] == 'G') actual[2]++;
      if (str[i + len2] == 'T') actual[3]++;

      System.out.println("count -> " + count);

      if (actual[0] >= condition[0] && actual[1] >= condition[1] && actual[2] >= condition[2] && actual[3] >= condition[3]) {
        count++;
      }
    }


    bw.write(String.valueOf(count));
    bw.close();


  }
}
