package baekjoon.basic.step4;

import java.io.*;
import java.util.StringTokenizer;

public class Step7 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String str1 = br.readLine();
    int n = Integer.parseInt(str1);
    double[] scores = new double[n];
    double sum = 0;
    double avg;

    String str2 = br.readLine();
    StringTokenizer st = new StringTokenizer(str2, " ");

    for (int i = 0; i < n; i++) {
      scores[i] = Double.parseDouble(st.nextToken());
    }

    double maxScore = scores[0];

    for (double i: scores) {
      if (i > maxScore) {
        maxScore = i;
      }
    }

    for (int i = 0; i < n; i++) {
      scores[i] = scores[i] / maxScore * 100;
      sum += scores[i];
    }

    avg = sum / n;

    bw.write(String.valueOf(avg));

    bw.flush();
  }
}

