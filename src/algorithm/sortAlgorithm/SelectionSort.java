package algorithm.sortAlgorithm;

// 1 10 5 8 7 6 4 3 2 9
// 인덱스 i부터 시작해서 i ~ 마지막 까지 순회하다가 자신보다 작은 숫자가 나오면 바꾸고 종료. 이후 인덱스는 +1 된다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SelectionSort {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int length = st.countTokens();
    int[] num = new int[length];
    int temp;

    for (int i = 0; i < length; i++) {
      num[i] = Integer.parseInt(st.nextToken());
    }

//    min = num[0];
    //

    for (int i = 0; i < length; i++) {
      for (int j = i; j < length; j++) {
        if (num[j] < num[i]) {
          temp = num[i];
          num[i] = num[j];
          num[j] = temp;
        }
      }
    }

    for (int i : num) {
      System.out.println(i + " ");
    }

  }
}
