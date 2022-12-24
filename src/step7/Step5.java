package step7;

import java.io.*;
import java.util.StringTokenizer;

public class Step5 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String str1 = br.readLine();
    int testCase = Integer.parseInt(str1);
    int height1, room1, people;
    int height2, room2;
    String[] result = new String[testCase];

    for (int i = 0; i < testCase; i++) {
      String str2 = br.readLine();
      StringTokenizer st = new StringTokenizer(str2, " ");
      height1 = Integer.parseInt(st.nextToken());
      room1 = Integer.parseInt(st.nextToken());
      people = Integer.parseInt(st.nextToken());

      height2 = people % height1; // 1
      room2 = people / height1 + 1; // 3
      if (people % height1 == 0) {
        height2 = height1;
        room2 = people / height1;
      }

      result[i] = height2 + Integer.toString(room2); // 13


      if (room2 < 10) {
        result[i] = height2 + "0" + room2; // 103
      }
    }

    for (int i = 0; i < testCase; i++) {
      if (i == testCase - 1) {
        bw.write(result[i]);
      } else {
        bw.write(result[i] + "\n");
      }
    }
    bw.flush();
  }
}