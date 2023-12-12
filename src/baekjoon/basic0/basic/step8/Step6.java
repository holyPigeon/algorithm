package baekjoon.basic0.basic.step8;

import java.io.*;
import java.util.ArrayList;

public class Step6 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String str1 = br.readLine();
    int testCase = Integer.parseInt(str1);


    for (int i = 0; i < testCase; i++) {
      String str2 = br.readLine();
      int n = Integer.parseInt(str2);
      int temp, min = -1, minIndex = 0;
      ArrayList<Integer> list = new ArrayList<>();

      for (int j = 2; j < n; j++) {
        if(check_prime(j)) {
          list.add(j);
        }
      }

//      for (int j = 0; j < list.size(); j++) {
//        bw.write(list.get(j) + " ");
//      }

      int[][] result = new int[list.size()][2];
      int[] diff = new int[list.size()];
      //

//      bw.write("\n\n\n");

      for (int j = 0; j < list.size(); j++) {
        temp = n - list.get(j); // temp = 8 - 7 = 1
//        bw.write("temp: " + temp + ", n: " + n + ", list.get(j): " + list.get(j) + " ");
//        bw.write("\n");
        if (check_prime(temp)) {
          result[j][0] = temp; // result[0][0] = 1; / 3 / 5 / 7
          result[j][1] = list.get(j); // result[0][1] = 7; / 5 / 3 / 1
        }

        if (result[j][0] == 0 || result[j][1] == 0) {
          diff[j] = -1;
        } else {
          diff[j] = Math.abs(result[j][0] - result[j][1]);
          min = diff[j];
        }
//        bw.write(result[j][0] + " " + result[j][1] + " " + diff[j] + "\n");
      }

      for (int j = 0; j < list.size(); j++) {
        if (min != -1) {
          if (diff[j] >= 0) {
            if (diff[j] <= min) {
              min = diff[j];
              minIndex = j;
//              bw.write("minIndex: " + minIndex + ", min: " + min + " / ");
            }
          }
        }

      }

//      bw.write("\n\n\n");
//      bw.write("minIndex: " + minIndex + "\n");
      bw.write(result[minIndex][0] + " " + result[minIndex][1] + "\n");
    }
    bw.flush();
  }

  static boolean check_prime(int number) {

    // 0 과 1 은 소수가 아니므로 종료
    if (number < 2) {
      return false;
    } else if (number == 2) {
      return true;
    } else {
      for (int i = 2; i <= Math.sqrt(number); i++) {

        // 소수가 아닐경우 종료
        if (number % i == 0) {
          return false;
        }
      }
      // 위 반복문에서 약수를 갖고 있지 않는경우 소수다.
      return true;
    }
  }
}
