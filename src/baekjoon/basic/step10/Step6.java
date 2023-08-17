package baekjoon.basic.step10;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Step6 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String str1 = br.readLine();
    int testcase = Integer.parseInt(str1);
    ArrayList<Integer> arr = new ArrayList<>();

    for (int i = 0; i < testcase; i++) {
      String str2 = br.readLine();
      int num = Integer.parseInt(str2);
      arr.add(num);
    }

    Collections.sort(arr);

    int avg, mid, most, range, sum = 0;
    int[] mostCnt = new int[8001];
    int mostIndex = 0, mostMax = mostCnt[0], mostDuplicate = 0;
    ArrayList<Integer> mostArr = new ArrayList<>();

    for (int i: arr) {
      sum += i;
    }

    avg = (int)(Math.floor(((double)sum / testcase) + 0.5));

    mid = arr.get(testcase / 2);

    for (int i: arr) {
      for (int j = 0; j <= 8000; j++) {
        if (i == j - 4000) {
          mostCnt[j]++;
        }
      }
    }

    for (int i = 0; i <= 8000; i++) {
      if (mostCnt[i] > mostMax) {
        mostMax = mostCnt[i];
        mostIndex = i;
      }
    }

    for (int i = 0; i <= 8000; i++) {
      if (mostCnt[i] == mostMax) {
        mostArr.add(i - 4000);
        mostDuplicate++;
      }
    }

    if (mostDuplicate > 1) {
      Collections.sort(mostArr);
      most = mostArr.get(1);
    } else {
      most = mostIndex - 4000;
    }

    range = arr.get(testcase - 1) - arr.get(0);

    bw.write(avg + "\n");
    bw.write(mid + "\n");
    bw.write(most + "\n");
    bw.write(range + "\n");

    bw.flush();
  }
}
