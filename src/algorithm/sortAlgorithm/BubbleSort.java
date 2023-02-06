package algorithm.sortAlgorithm;

// 1 10 5 8 7 6 4 3 2 9
// 인덱스 i부터 시작해서 i ~ length - i 까지 순회하면서

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
    int min, temp, index;

    for (int i : num) {
      System.out.println(i + " ");
    }

  }
}
