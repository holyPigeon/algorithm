package step3;

import java.io.*;
import java.util.ArrayList;

public class Step11 {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    ArrayList<Integer> sum = new ArrayList<>();

    int currentSum;
    int count = 0;
    String x;

    while((x = reader.readLine()) != null && !x.isEmpty()) {
      String[] str = x.split(" ");
//      if (str[0].equals(null)) {
//        break;
//      }
      currentSum = Integer.parseInt(str[0]) + Integer.parseInt(str[1]);
      sum.add(currentSum);
      count++;
    }

    for (int i = 0; i < count; i++) {
      if (i == (count - 1)) {
        bw.write(Integer.toString(sum.get(i)));
      } else {
        bw.write(sum.get(i) + "\n");
      }
    }

    bw.flush();
  }
}