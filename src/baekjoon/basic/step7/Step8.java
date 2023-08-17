package baekjoon.basic.step7;

import java.io.*;
import java.util.StringTokenizer;

// 설탕 N 킬로그램 배달
// 3kg 봉지 / 5kg 봉지

public class Step8 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String str = br.readLine();
    StringTokenizer st = new StringTokenizer(str, " ");
    String num1, num2;
    num1 = st.nextToken();
    num2 = st.nextToken();
    int resultLen = Math.max(num1.length(), num2.length()) + 1;

    int[] num3 = new int[resultLen];
    int[] num4 = new int[resultLen];


    int[] result = new int[resultLen];

    num3[0] = 0;
    num4[0] = 0;

    for (int i = 1; i < resultLen; i++) {
       num3[i] = Character.getNumericValue(num1.charAt(i - 1));
    }
    for (int i = 1; i < resultLen; i++) {
       num4[i] = Character.getNumericValue(num2.charAt(i - 1));
    }

//    for (int i = resultLen - 1; i >= 0; i--) {
//
//      bw.write(num3[i] + "");
//    }


//    for (int i = 0; i < resultLen; i++) {
//      bw.write(num3[i] + "");
//    }
//    bw.write("\n");
//    for (int i = 0; i < resultLen; i++) {
//      bw.write(num4[i] + "");
//    }
//    bw.write("\n");


    bw.flush();
  }
}