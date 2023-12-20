package baekjoon.basic1.data_structure_1;

import java.io.*;

public class Problem_11655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String input = br.readLine();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (Character.isLowerCase(ch)) {
                sb.append((char)((ch - 'a' + 13) % 26 + 'a'));
            } else if (Character.isUpperCase(ch)) {
                sb.append((char) ((ch - 'A' + 13) % 26 + 'A'));
            } else {
                sb.append(ch);
            }
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
