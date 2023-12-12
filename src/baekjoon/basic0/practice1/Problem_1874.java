package baekjoon.basic0.practice1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Problem_1874 {

  public static void main(String[] args) throws IOException {

    /*
    입력
     */
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    List<Integer> input = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    List<Integer> output = new ArrayList<>();
    List<String> execute = new ArrayList<>();
    int pass = 1;
    for (int i = 1; i <= n; i++) {
      output.add(Integer.parseInt(br.readLine()));
    }

    /*
    로직
     */

    // input을 하나씩 쌓아 i를
    // 근데 쌓다가 input의 top이 output의 bottom (인덱스 j)인 아이랑 눈이 마주치면? 값이 같으면?
    // 바로 그 값을 빼서 list에 넣어버려
    // 4 3 6 8 7 5 2 1

    int j = 0;
    for (int i = 0; i < n; i++) {

      input.add(i + 1);
      execute.add("+");
      while (j < n && peek(input) == output.get(j)) {
        list.add(pop(input));
        execute.add("-");
        j++;
      }
    }
    if (list.size() == output.size()) {
      for (int i = 0; i < n; i++) {
        if (!list.get(i).equals(output.get(i))) {
          pass = 0;
          break;
        }
      }
    } else {
      pass = 0;
    }

    if (pass == 1) {
      for (String e : execute) {
        bw.write(e + "\n");
      }
    } else {
      bw.write("NO");
    }

    bw.close();
  }

  public static Integer pop(List<Integer> list) {

    int n = list.get(list.size() - 1);
    list.remove(list.size() - 1);

    return n;
  }

  public static int peek(List<Integer> list) {

    if (list.size() == 0) {
      return -1;
    } else {
      return list.get(list.size() - 1);
    }

  }
}

