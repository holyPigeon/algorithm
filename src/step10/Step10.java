package step10;

import java.io.*;
import java.util.*;

public class Step10 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String str1 = br.readLine();
    int testcase = Integer.parseInt(str1);
    ArrayList<String> words = new ArrayList<>();


    for (int i = 0; i < testcase; i++) {
      String str2 = br.readLine();
      words.add(str2);
    }

    words.sort(null);

    words.sort((String s1, String s2) -> {
      if (s1.length() == s2.length()) {
        return 0;
      } else {
        return s1.length() - s2.length();
      }
    });

    List<String> result = words.stream().distinct().toList();

    for (String s : result) {
      bw.write(s + "\n");
    }

    bw.flush();
  }
}
