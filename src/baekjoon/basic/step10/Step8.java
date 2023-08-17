package baekjoon.basic.step10;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

class PairXComparator implements Comparator<Pair> {
  @Override
  public int compare(Pair a, Pair b) {
    if (a.getX() == b.getX()) {
      return a.getX() - b.getX();
    } else {
      return a.getX() - b.getX();
    }
    /*if (a.getX() > b.getX()) {
      return 1;
    } else if (a.getX() < b.getX()) {
      return -1;
    }
    return 0;*/
  }
}

class PairYComparator implements Comparator<Pair> {

  @Override
  public int compare(Pair a, Pair b) {
    if (a.getY() == b.getY()) {
      return a.getY() - b.getY();
    } else {
      return a.getY() - b.getY();
    }
    /*if (a.getY() > b.getY()) {
      return 1;
    } else if (a.getY() < b.getY()) {
      return -1;
    }
    return 0;*/
  }
}

class Pair {
  Pair(int x, int y) {
    this.x = x;
    this.y = y;
  }
  int x;

  public int getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  int y;

  public int getY() {
    return y;
  }

  public void setY(int y) {
    this.y = y;
  }
}

public class Step8 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String str1 = br.readLine();
    int testcase = Integer.parseInt(str1);

    ArrayList<Pair> pairs = new ArrayList<>();

    for (int i = 0; i < testcase; i++) {
      String str2 = br.readLine();
      StringTokenizer st = new StringTokenizer(str2, " ");

      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());

      pairs.add(new Pair(x, y));
    }

    Collections.sort(pairs, new PairXComparator());
    Collections.sort(pairs, new PairYComparator());

    StringBuilder sb = new StringBuilder();


    for (Pair p: pairs) {
      sb.append(p.getX() + " " + p.getY()).append('\n');
    }

    bw.write(sb + "\n");

    bw.flush();
  }
}
