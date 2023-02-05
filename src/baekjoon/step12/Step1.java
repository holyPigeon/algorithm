package baekjoon.step12;

import java.io.*;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Step1 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int cardNumber = Integer.parseInt(st.nextToken());
    int suggested = Integer.parseInt(st.nextToken());

    int num1, num2, num3;
    int[] arr = new int[cardNumber];
    boolean[] visited = new boolean[arr.length];
    ArrayList<String> tokens = new ArrayList<>();

    StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");

    for (int i = 0; i < cardNumber; i++) {
      arr[i] = Integer.parseInt(st2.nextToken());
    }

    comb1(arr, visited, 0, 3, tokens);

    int[] sum = new int[tokens.size()];
    int[] min = new int[tokens.size()];


    for (int i = 0; i < tokens.size(); i++) {
      StringTokenizer st3 = new StringTokenizer(tokens.get(i), " ");
      num1 = Integer.parseInt(st3.nextToken());
      num2 = Integer.parseInt(st3.nextToken());
      num3 = Integer.parseInt(st3.nextToken());
      sum[i] = num1 + num2 + num3;
      min[i] = suggested - sum[i];
    }

    int minimum2 = 0;
    int index = 0;

    for (int i = 0; i < tokens.size(); i++) {
      if (min[i] >= 0) {
        minimum2 = min[i];
        break;
      }
    }

    for (int i = 0; i < tokens.size(); i++) {
      if (min[i] >= 0) {
        if (min[i] <= minimum2) {
          minimum2 = min[i];
          index = i;
        }
      }
    }

    bw.write(sum[index] + " ");

//    for (int i = 0; i < splitSpace.countTokens(); i++) {
//      chosen[i] = Integer.parseInt(splitSpace.nextToken());
//    }
//
//    comb1(arr, visited, 0, 3);

//    for (String token : tokens) {
//      System.out.println(token + "hi");
//    }
//

    bw.flush();
    bw.close();
  }

  static void comb1(int[] arr, boolean[] visited, int start, int r, ArrayList l) {
    if (r == 0) {
      l.add(print1(arr, visited));
    } else {
      for (int i = start; i < arr.length; i++) {
        visited[i] = true;
        comb1(arr, visited, i + 1, r - 1, l);
        visited[i] = false;
      }
    }
  }

  static String print1(int[] arr, boolean[] visited) {
    String result = "";

    for (int i = 0; i < arr.length; i++) {
      if (visited[i] == true) result += arr[i] + " ";
    }
    return result;
  }

  /*static void comb2(int[] arr, boolean[] visited, int start, int r) {
    if (r == 0) {
      print2(arr, visited);
      System.out.println("hihi");
    } else {
      for (int i = start; i < arr.length; i++) {
        visited[i] = true;
        comb2(arr, visited, i + 1, r - 1);
        visited[i] = false;
      }
    }
  }

  static void print2(int[] arr, boolean[] visited) {
    for (int i = 0; i < arr.length; i++) {
      if (visited[i] == true)
        System.out.print(arr[i] + " ");
    }
    System.out.println();
  }*/
}
