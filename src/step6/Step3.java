package step6;

import java.io.*;
import java.util.Arrays;

public class Step3 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int[] result = new int[26];
    Arrays.fill(result, -1);
    String str1 = br.readLine();


    for (int i = 0; i < str1.length(); i++) { // 97 ~ 122 A ~ Z
      for (int j = 0; j < 26; j++) {
        if ((int)str1.charAt(i) == j + 97) {
          if (result[j] == -1) {
            result[j] = i;
            break;
          }
        }
      }
    }

    for(int i = 0; i < 26; i++) {
      bw.write(result[i] + " ");
    }

    bw.flush();
  }
}
