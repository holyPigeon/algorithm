//package baekjoon.study;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class Problem_1780 {
//    public static void main(String[] args) throws IOException {
//        // input
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//        int[][] paper = new int[n][n];
//
//        for (int i = 0; i < n; i++) {
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            for (int j = 0; j < n; j++) {
//                paper[i][j] = Integer.parseInt(st.nextToken());
//            }
//        }
//
//        // logic
//
//    }
//
//    private static void divide(int[][] array) {
//        int length = array.length;
//
//        for (int i = 0; i < length; i++) {
//            int[][] dividedArray = new int[length / 3][length / 3];
//
//            for (int i = 0; i < length; i++) {
//                for (int j = 0; j < length; j++) {
//
//                }
//            }
//        }
//
//    }
//
//    private static int[][] getSubArrays(int[][] originalArray) {
//        // 3x3 부분 배열 추출
//        int length = originalArray.length;
//        int subLength = length / 3;
//        int[][] subMatrix = null;
//        for (int blockRow = 0; blockRow < length; blockRow += subLength) {  // 블록 행 이동 (0, 3, 6)
//            for (int blockCol = 0; blockCol < length; blockCol += subLength) { // 블록 열 이동 (0, 3, 6)
//                subMatrix = new int[subLength][subLength];
//
//                // 3x3 부분 배열 생성
//                for (int i = 0; i < 3; i++) {
//                    for (int j = 0; j < 3; j++) {
//                        subMatrix[i][j] = originalArray[blockRow + i][blockCol + j];
//                    }
//                }
//            }
//        }
//
//        return subMatrix;
//    }
//}
