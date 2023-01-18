package step10;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

// 시간 초과(2초)

public class Step12 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String str1 = br.readLine();
    int testcase = Integer.parseInt(str1);
    Number[] numbers = new Number[testcase];

    String str2 = br.readLine();
    StringTokenizer st = new StringTokenizer(str2, " ");

    for (int i = 0; i < testcase; i++) {
      numbers[i] = new Number(Integer.parseInt(st.nextToken()));
    }

    for (int i = 0; i < testcase; i++) {
      ArrayList<Integer> biggerThanINum = new ArrayList<>();
      for (int j = 0; j < testcase; j++) {
        if (numbers[i].getPoint() > numbers[j].getPoint() && numbers[i].getPoint() != numbers[j].getPoint()) {
          biggerThanINum.add(numbers[j].getPoint()); // i보다 큰 j 숫자들의 리스트
        }
      }
      numbers[i].memory = biggerThanINum.stream().distinct().collect(Collectors.toList());// 큰 숫자들 중에서 중복된 숫자를 제거 후 memory 리스트에 저장
    }

    for (Number n : numbers) {
      bw.write(n.memory.size() + " ");
    }

    bw.flush();
  }

  static class Number {
    private int point;

    private List<Integer> memory;

    public Number(int point) {
      this.point = point;

      memory = new ArrayList<>();
    }

    public int getPoint() {
      return point;
    }

    public void setPoint(int point) {
      this.point = point;
    }
  }
}
