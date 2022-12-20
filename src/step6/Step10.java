package step6;

import java.io.*;
import java.util.Arrays;

// 해당 알파벳이 최소 한 번 이상은 나와야 함
// 해당 알파벳이 나오고 다른 알파벳이 나왔다가 처음 그 알파벳이 다시 한 번 등장해야 함
// 해당 알파벳과 다음 인덱스 알파벳이 다르면 26개 자리 중 해당 인덱스에 끝났다고 체크, 이후 등장했을 때 isEnd[i] = 1 이면 sum에 포함 X

public class Step10 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int[] isEnd = new int[26];
    int fail = 0;
    int sum = 0;

    String str1 = br.readLine();
    int len = Integer.parseInt(str1);

    for (int i = 0; i < len; i++) {
      String str2 = br.readLine();
      int wordLen = str2.length();

      for (int j = 0; j < wordLen; j++) {
        if (j > 0) {
          if (str2.charAt(j) != str2.charAt(j - 1)) { // 현재 인덱스 알파벳과 전 인덱스 알파벳이 다를 때
            if (isEnd[(int) str2.charAt(j) - 97] == 1) { // 현재 인덱스 알파벳이 이미 나온 알파벳일 때
              fail = 1;
            }
            isEnd[(int) str2.charAt(j - 1) - 97] = 1; //
          }
        }
      }
      Arrays.fill(isEnd, 0);
      if (fail != 1) {
        sum++;
      }
    }

    bw.write(String.valueOf(sum));

    bw.flush();
  }
}
