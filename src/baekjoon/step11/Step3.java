package baekjoon.step11;


import java.io.*;

public class Step3 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int testcase = Integer.parseInt(br.readLine());
    int[][] result = new int[testcase][2];

    Palindrome p1 = new Palindrome();

    for (int i = 0; i < testcase; i++) {
      String s = br.readLine();
      result[i][0] = p1.isPalindrome(s);
      result[i][1] = Palindrome.getCount();
      Palindrome.setCount(0);
    }

    for (int i = 0; i < testcase; i++) {
      bw.write(result[i][0] + " " + result[i][1] + "\n");
    }

    bw.flush();
  }

  static class Palindrome {
    private static int count;

    public static int getCount() {
      return count;
    }

    public static void setCount(int count) {
      Palindrome.count = count;
    }

    public static void addCount() {
      Palindrome.count++;
    }

    public int recursion(String s, int l, int r) {
      addCount();
      if (l >= r) return 1;
      else if (s.charAt(l) != s.charAt(r)) return 0;
      else return recursion(s, l + 1, r - 1);
    }

    public int isPalindrome(String s) {
      return recursion(s, 0, s.length() - 1);
    }
  }



}
