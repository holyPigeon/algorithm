package algorithm.sortAlgorithm;

// 1 10 5 8 7 6 4 3 2 9
// 인덱스 i부터 시작해서 i ~ length 까지 순회하면서 num[i]와 num[i + 1]을 비교하고 오름차순으로 바꾼다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BubbleSort {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int length = st.countTokens();
    int[] num = new int[length];
    int temp;

    for (int i = 0; i < length; i++) {
      num[i] = Integer.parseInt(st.nextToken());
    }

    for (int i = 0; i < length; i++) {
      for (int j = 0; j < length - i; j++) {
        if (j != length - i - 1) {
          if (num[j] > num[j + 1]) {
            temp = num[j];
            num[j] = num[j + 1];
            num[j + 1] = temp;
          }
        }
      }
    }

    for (int i : num) {
      System.out.println(i + " ");
    }

  }
}
