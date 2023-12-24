package baekjoon.basic1.brute_force;

import java.io.*;

/*
title: 제각기 다른 색의 사탕들로 차있는 N X N 배열에서 인접한 서로 다른 색의 사탕 2개를 자리 체인지하고 연속 부분을 제거한다.
이 때 제거할 수 있는 부분의 최대 길이를 구한다.

CCP
CCP
PPC

CCP
CCC
PPP

- 가로로 사탕을 바꾸는 행위는, 인접한 열 인덱스를 조작한다. -> j
- 세로로 사탕을 바꾸는 행위는, 인접한 행 인덱스를 조작한다. -> i

- 만약 가로로 연속되는 부분이 나왔다? -> 열 인덱스가 이어진 것
    - 이어졌는지 어떻게 판별하는가 -> 연속 부분 변수 초기값을 1로 정하고, array[i-1]의 색이 array[i]의 색과 같다면 1 추가시킨다.
- 만약 세로로 연속되는 부분이 나왔다? -> 행 인덱스가 이어진 것

- 인접한 사탕을 바꾼다면, N * N 배열에서 한 열 또는 행에서 N - 1번 바꾸기 가능 -> 바꾸는 작업의 경우의 수는 (N - 1)(N - 1)
 */

public class Problem_3085 {

    static int count;
    static char[][] array;
    static int max = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        count = Integer.parseInt(br.readLine());
        array = new char[count][count];

        // 배열 세팅
        for (int i = 0; i < count; i++) {
            char[] candies = br.readLine().toCharArray();
            for (int j = 0; j < count; j++) {
                array[i][j] = candies[j];
            }
        }

        // 자리를 모두 바꿔보며 결과값 도출

        // 행 바꿔보기
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count - 1; j++) {
                switchRowCandies(i, j);
                search();
                switchRowCandies(i, j);
            }
        }

        // 열 바꿔보기
        for (int i = 0; i < count - 1; i++) {
            for (int j = 0; j < count; j++) {
                switchColumnCandies(i, j);
                search();
                switchColumnCandies(i, j);
            }
        }

        bw.write(String.valueOf(max));
        bw.close();
        br.close();

    }

    private static void switchRowCandies(int i, int j) {
        char temp = array[i][j];
        array[i][j] = array[i][j + 1];
        array[i][j + 1] = temp;
    }

    private static void switchColumnCandies(int i, int j) {
        char temp = array[i][j];
        array[i][j] = array[i + 1][j];
        array[i + 1][j] = temp;
    }

    private static void search() {
        // N 행 연속구간 조사
        for (int i = 0; i < count; i++) {
            int rowMax = 1;
            for (int j = 0; j < count - 1; j++) {
                if (array[i][j] == array[i][j + 1]) { // 연속된 사탕의 색이 같으면 최댓값 증가
                    rowMax++;
                    max = Math.max(rowMax, max);
                } else {
                    rowMax = 1;
                }
            }

        }
        // N 열 연속구간 조사
        for (int i = 0; i < count; i++) {
            int colMax = 1;
            for (int j = 0; j < count - 1; j++) {
                if (array[j][i] == array[j + 1][i]) { // 연속된 사탕의 색이 같으면 최댓값 증가
                    colMax++;
                    max = Math.max(colMax, max);
                } else {
                    colMax = 1;
                }
            }

        }
    }
}
