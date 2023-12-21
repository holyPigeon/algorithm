package baekjoon.basic1.data_structure_1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Problem_11656 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        List<Object> list = new ArrayList<>();
        String input = br.readLine();

        for (int i = 0; i < input.length(); i++) {
            list.add(input.substring(i, input.length()));
        }

        list.stream()
                .sorted()
                .forEach(System.out::println);
    }
}
