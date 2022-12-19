package step6;

import java.io.*;

public class Step5 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String word = br.readLine();
    int len = word.length();
    int[] alpha = new int[26];

    for (int i = 0; i < len; i++) { // 대문자 65~90, 소문자 97~122
      for (int j = 0; j < 26; j++) {
        if ((int) word.charAt(i) == j + 65 || (int) word.charAt(i) == j + 97) {
          alpha[j]++;
        }
      }
    }

    int most = alpha[0];
    int mostIndex = 0;
    int mostCount = 0;

    for (int i = 0; i < 26; i++) {
      if (alpha[i] > most) {
        most = alpha[i];
        mostIndex = i;
      }
    }

    for (int i = 0; i < 26; i++) {
      if (alpha[i] == most) {
        mostCount++;
      }
    }

    if (mostCount > 1) {
      bw.write("?");
    } else {
      bw.write((char) (mostIndex + 65));
    }

    bw.flush();
  }
}
