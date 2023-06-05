package algorithm.assignment;

import java.io.*;

public class problem_3_3 {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int k = Integer.parseInt(br.readLine());

    int index = 7;
    int[] num = {1, 4, 7, 13, 28, 52, 91, 365};

    while(true) {
      if (k / num[index] != 0) {
        System.out.println("before -> " + k);
        k = (k % num[index]);
        System.out.println("after -> " + k);
      }
      index--;
    }
  }
}
