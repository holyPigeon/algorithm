package baekjoon.basic1.data_structure_1;

import java.io.*;
import java.util.ArrayList;

public class Problem_10808 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String input = br.readLine();
        ArrayList<Integer> list = new ArrayList<>();


        for (int i = 0; i < 26; i++) {
            list.add(0);
            for (int j = 0; j < input.length(); j++) {
                if ((int)input.charAt(j) == i + 97) {
                    list.set(i, list.get(i) + 1);
                }
            }
        }

        list.forEach(number -> System.out.print(number + " "));
    }
}
