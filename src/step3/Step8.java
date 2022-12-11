package step3;

import java.io.*;

public class Step8 {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String countStr = reader.readLine();
    int count = Integer.parseInt(countStr);

    for (int i = 1; i <= count; i++) {
      for (int j = 0; j < i; j++){
          bw.write("*");
      }
      if (i != count) {
        bw.write("\n");
      }

    }

    bw.flush();
  }
}