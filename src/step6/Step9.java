package step6;

import java.io.*;

// 연속된 글자가 한 글자인 경우
// 1. j로 끝남
// 2. = 또는 - 로 끝남
// 3. d로 시작해서 중간에 알파벳 하나 들어가고 =로 끝남

public class Step9 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String str1 = br.readLine();
    int len = str1.length();
    int alphaStack = 0;
    int dStack = 0;
    int jStack = 0;
    int sum = 0;

    for (int i = 0; i < len; i++) {
      if ((int)str1.charAt(i) == 100) { // d가 나온 경우
        if (dStack == 1) { // d가 연속 2 번 나온 경우
          dStack = 0;
        }
          dStack++;
          sum++;
      } else if ((int)str1.charAt(i) == 106) { // j가 나온 경우
          if (alphaStack == 0) {
            if (jStack == 1) { // j가 연속 2 번 나옴
              jStack = 0;
            } else if (jStack == 0) { // j가 첫 글자로 나옴
              jStack++;
              sum++;
            }
          } else if (alphaStack == 1) {
            alphaStack = 0;
            jStack = 0;
          }
      } else if ((int)str1.charAt(i) >= 97 && (int)str1.charAt(i) <= 122) { // d를 제외한 알파벳
        if (dStack == 1) {
          dStack = 2;
        } else if (alphaStack == 0) { // d를 제외한 알파벳이 처음 나온 경우
          alphaStack++;
          sum++;
        } else if (alphaStack == 1) { // d를 제외한 알파벳이 두 번 연속 나온 경우
          sum++;
        }
      } else if (str1.charAt(i) == '=' || str1.charAt(i) == '-') { // = 이나 -
        if (dStack == 1) {
          dStack = 0; // 1개 합산, 초기화
        } else if (dStack == 2) {
          dStack = 0;
        } else if (alphaStack == 1) {
          alphaStack = 0;
        }
      }
    }

    bw.write(String.valueOf(sum));


    bw.flush();
  }
}
