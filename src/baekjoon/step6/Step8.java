package baekjoon.step6;

import java.io.*;

public class Step8 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String str1 = br.readLine();
    int len = str1.length();
    char[] alpha = new char[len];
    int sum = 0;

    for (int i = 0; i < len; i++) {
      alpha[i] = str1.charAt(i);
    }

    for (int i = 0; i < len; i++) {
      if (alpha[i] == 'A' || alpha[i] == 'B' || alpha[i] == 'C') {
        sum += 3;
      } else if (alpha[i] == 'D' || alpha[i] == 'E' || alpha[i] == 'F') {
        sum += 4;
      } else if (alpha[i] == 'G' || alpha[i] == 'H' || alpha[i] == 'I') {
        sum += 5;
      } else if (alpha[i] == 'J' || alpha[i] == 'K' || alpha[i] == 'L') {
        sum += 6;
      } else if (alpha[i] == 'M' || alpha[i] == 'N' || alpha[i] == 'O') {
        sum += 7;
      } else if (alpha[i] == 'P' || alpha[i] == 'Q' || alpha[i] == 'R' || alpha[i] == 'S') {
        sum += 8;
      } else if (alpha[i] == 'T' || alpha[i] == 'U' || alpha[i] == 'V') {
        sum += 9;
      } else if (alpha[i] == 'W' || alpha[i] == 'X' || alpha[i] == 'Y' || alpha[i] == 'Z') {
        sum += 10;
      }
    }

    bw.write(String.valueOf(sum));

    bw.flush();
  }
}
