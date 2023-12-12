package baekjoon.basic0.advanced2;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Problem_20920 {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    // 입력값 받기
    ArrayList<Word> words = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      String s = br.readLine();
      if (s.length() >= m) {
        if (!words.contains(s)) {
          words.add(new Word(s, 1));
        } else {
          for (int j = 0; j < words.size(); j++) {
            if (words.get(j).getName().equals(s)) {
              words.get(j).increaseCount();
            }
          }
        }
      }
    }

    // 우선순위 적용하기
    List<Word> result = words.stream().sorted((w1, w2) -> {
      int countCompare = Integer.compare(w2.getCount(), w1.getCount());
      if (countCompare != 0) {

        return countCompare;
      } else {
        int lengthCompare = Integer.compare(w2.getLength(), w1.getLength());
        if (lengthCompare != 0) {

          return lengthCompare;
        } else {

          return w1.getName().compareTo(w2.getName());
        }
      }
    }).collect(Collectors.toList());

    for (int i = 0; i < result.size(); i++) {
      sb.append(result.get(i).getName()).append("\n");
    }

    bw.write(sb.toString());
    bw.close();
  }

  static class Word {

    private String name;

    private int count;
    
    private int length;

    public Word(String name, int count) {
      this.name = name;
      this.count = count;
      this.length = name.length();
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public int getCount() {
      return count;
    }

    public void setCount(int count) {
      this.count = count;
    }

    // 메소드
    public void increaseCount() {
      this.count++;
    }

    public int getLength() {
      return length;
    }

    public void setLength(int length) {
      this.length = length;
    }
  }
}
