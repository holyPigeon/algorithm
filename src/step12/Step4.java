package step12;

import java.io.*;
import java.util.StringTokenizer;

public class Step4 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    int[][] originChess = new int[n][m]; // 0 -> black, 1 -> white
    int[][] copiedChess = new int[n][m];
    int[][] counts = new int[n - 7][m - 7];

    for (int i = 0; i < n; i++) {
      String str = br.readLine();
      for (int j = 0; j < m; j++) {
        if (str.charAt(j) == 'B') { // 문자가 B인 경우 0 대입
          originChess[i][j] = 0;
          copiedChess[i][j] = 0;
        } else { // 문자가 W인 경우 1 대입
          originChess[i][j] = 1;
          copiedChess[i][j] = 1;
        }
      }
    }

/*
    for (int i = 0; i < n - 7; i++) {
      for (int j = 0; j < m - 7; j++) {
        rePaint(copiedChess, counts, i, j);
      }
    }
*/
    rePaint(copiedChess, counts, 0, 0);
    printArray(copiedChess, n, m);
  }

  public static void printArray(int[][] arr, int n, int m) {
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (arr[i][j] == 0) {
          System.out.print("B");
        } else {
          System.out.print("W");
        }
      }
      System.out.println();
    }
  }


  /**
   * 선택된 배열을 체스판 배열로 바꾸고 바뀌어진 색의 수를 기록
   * @param selectedArr 주어진 chess 배열에서 선택된 8 X 8 크기의 배열
   * @param counts 바뀐 색의 갯수를 담은 배열
   * @param i 선택된 배열의 시작 인덱스 (2차원)
   * @param j 선택된 배열의 시작 인덱스 (1차원)
   */
  public static void rePaint(int[][] selectedArr, int[][] counts, int i, int j) {
    for (int k = i; k < i + 8; k++) {
      for (int l = j; l < j + 8; l++) {
        if (selectedArr[0][0] == 0) { // 첫 문자가 'B'인 경우
          if (j % 2 == 0) { // j가 짝수인 경우
            if (l % 2 != 0) { // l % 2 이 홀수 -> 선택된 배열의 홀수 인덱스
              if (selectedArr[k][l] == 1) { // 색 변경 후 count 증가
                selectedArr[k][l] = 0;
                counts[i][j]++;
              }
            } else { // l % 2 이 짝수 -> 선택된 배열의 짝수 인덱스
              if (selectedArr[k][l] == 0) { // 색 변경 후 count 증가
                selectedArr[k][l] = 1;
                counts[i][j]++;
              }
            }
          } else { // j가 홀수인 경우
            if (l % 2 == 0) { // l % 2 이 짝수 -> 선택된 배열의 홀수 인덱스
              if (selectedArr[k][l] == 1) { // 색 변경 후 count 증가
                selectedArr[k][l] = 0;
                counts[i][j]++;
              }
            } else { // l % 2 이 홀수 -> 선택된 배열의 짝수 인덱스
              if (selectedArr[k][l] == 0) { // 색 변경 후 count 증가
                selectedArr[k][l] = 1;
                counts[i][j]++;
              }
            }
          }
        } else if (selectedArr[0][0] == 1) { // 첫 문자가 'W'인 경우
          if (j % 2 == 0) { // j가 짝수인 경우
            if (l % 2 != 0) { // l % 2 이 홀수 -> 선택된 배열의 홀수 인덱스
              if (selectedArr[k][l] == 0) { // 색 변경 후 count 증가
                selectedArr[k][l] = 1;
                counts[i][j]++;
              }
            } else { // l % 2 이 짝수 -> 선택된 배열의 짝수 인덱스
              if (selectedArr[k][l] == 1) { // 색 변경 후 count 증가
                selectedArr[k][l] = 0;
                counts[i][j]++;
              }
            }
          } else { // j가 홀수인 경우
            if (l % 2 == 0) { // l % 2 이 짝수 -> 선택된 배열의 홀수 인덱스
              if (selectedArr[k][l] == 0) { // 색 변경 후 count 증가
                selectedArr[k][l] = 1;
                counts[i][j]++;
              }
            } else { // l % 2 이 홀수 -> 선택된 배열의 짝수 인덱스
              if (selectedArr[k][l] == 1) { // 색 변경 후 count 증가
                selectedArr[k][l] = 0;
                counts[i][j]++;
              }
            }
          }
        }
      }
    }
  }
}

// 첫 문자가 'B'인 경우 -> 홀수 인덱스(j가 짝수라면 그대로 -> l%2 != 0(홀수) 이면 홀수)(j가 홀수라면 l%2 == 0 이면 홀수) -> if 해당 값이 B인 경우 -> 변경 X
// 첫 문자가 'B'인 경우 -> 홀수 인덱스 -> if 해당 값이 W인 경우 -> count 증가 후 'B'로 변경
// 첫 문자가 'B'인 경우 -> 짝수 인덱스(j가 짝수라면 그대로 -> l%2 == 0 이면 짝수)(j가 홀수라면 l%2 != 0 이면 짝수) -> if 해당 값이 B인 경우 -> count 증가 후 'W'로 변경
// 첫 문자가 'B'인 경우 -> 짝수 인덱스 -> if 해당 값이 W인 경우 -> 변경 X


// 첫 문자가 'W'인 경우 -> 홀수 인덱스 -> if 해당 값이 B인 경우 -> count 증가 후 'W'로 변경
// 첫 문자가 'W'인 경우 -> 홀수 인덱스 -> if 해당 값이 W인 경우 -> 변경 X
// 첫 문자가 'W'인 경우 -> 짝수 인덱스 -> if 해당 값이 B인 경우 -> 변경 X
// 첫 문자가 'W'인 경우 -> 짝수 인덱스 -> if 해당 값이 W인 경우 -> count 증가 후 'B'로 변경

