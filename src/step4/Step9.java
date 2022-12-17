package step4;

import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Step9 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String str1 = br.readLine();
    String str2;
    StringTokenizer st;
    int c1 = Integer.parseInt(str1);
    int c2;
    ArrayList<Integer> score = new ArrayList<>();
    ArrayList<Double> per = new ArrayList<>();
    String[] round = new String[c1];
    int overNum = 0;
    int sum = 0;
    double avg;
    double temp;


    for (int i = 0; i < c1; i++) {
      str2 = br.readLine();
      st = new StringTokenizer(str2, " ");
      c2 = Integer.parseInt(st.nextToken());

      for (int j = 0; j < c2; j++) {
        score.add(Integer.parseInt(st.nextToken()));
        sum += score.get(j);
      }

      avg = (double)sum / c2;

      for (int j = 0; j < c2; j++) {
        if ((double)score.get(j) > avg) {
          overNum++;
        }
      }

      per.add((double)overNum / c2 * 100);

      score.clear();
      overNum = 0;
      sum = 0;

    }

    DecimalFormat df = new DecimalFormat("#0.000");

    for (int i = 0; i < c1; i++) {
      temp = Math.round(per.get(i) * 1000) / 1000.0;
      round[i] = df.format(temp);
    }

    for (int i = 0; i < c1 - 1; i++) {
      bw.write(round[i] + "%\n");
    }

    bw.write(round[c1 - 1] + "%");

    bw.flush();
  }
}

