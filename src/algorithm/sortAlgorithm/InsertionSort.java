package algorithm.sortAlgorithm;

// 1 10 5 8 7 6 4 3 2 9
// 인덱스 0 ~ i까지를 정렬된 숫자군으로 정함
// 0 ~ i까지 순회하면서 이미 정렬된 숫자군에서 아직 정렬되지 않은 i + 1번째의 숫자를 비교해가면서 정렬함

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class InsertionSort {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int length = st.countTokens();
    int[] num = new int[length];
    int temp;

    // 배열에 삽입
    for (int i = 0; i < length; i++) {
      num[i] = Integer.parseInt(st.nextToken());
    }

    // 삽입 정렬
    int j;

    for (int i = 0; i < length - 1; i++) { // 비교할 정렬 안 된 숫자
      j = i;
      while(num[j] > num[j + 1]) {
        temp = num[j];
        num[j] = num[j + 1];
        num[j + 1] = temp;
        j--;
      }
    }
    
    // 배열 출력
    for (int i : num) {
      System.out.print(i + " ");
    }
  }
}
