package algorithm.assignment;

import java.io.*;

public class problem_3_1 {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int num = Integer.parseInt(br.readLine());
    int temp = num;
    int n1 = 1;
    int n2 = 2;
    int n3 = 3;
    int n1Count = num / n1;
    int n2Count = num / n2;
    int n3Count = num / n3;
    int count = 0;

  if (n1Count != 0) {

      for (int i = 0; i < n1Count; i++) {
        temp =- n1;
      }
      if (temp == 0) {
        count++;
      }
    }
  if (n2Count != 0) {

      for (int i = 0; i < n2Count; i++) {
        temp =- n2;
      }
      if (temp == 0) {
        count++;
      }
    }
  }

  }
