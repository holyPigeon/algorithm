package baekjoon.basic1.data_structure_1;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
title: 주어진 문자열을 각 단어 단위로 뒤집어서 출력한다.

 - 일반적인 단어로만 이루어진 문자열은 공백을 기준으로 나누어서 뒤집는다.
 - "<" 또는 ">"가 들어간 일반적이지 않은 문자열이 있다.
    - 이 경우에는 "<"로 시작해서 ">"로 끝나는 뒤집지 않고 그대로 둔다.

 - 따라서 주어진 문자열이 "<"과 ">"를 포함하는지 확인하고, 만약 포함한다면
 */

public class Problem_17413 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String input = br.readLine();
        String result = "";

        if (!input.contains("<") && !input.contains(">")) {
            String[] tokens = input.split(" ");
            result = Arrays.stream(tokens)
                    .map(string -> new StringBuilder(string).reverse().toString())
                    .collect(Collectors.joining(" "));
        } else {
            // input 전처리
            List<String> subStrings = new ArrayList<>();
            int startIndex = 0, endIndex = 0;
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == '<') {
                    startIndex = i;
                    if (input.charAt(i) == '>') {
                        endIndex = i;
                        subStrings.add(input.substring(startIndex, endIndex));
                    }
                }
            }
        }

        bw.write(result);
        bw.close();
        br.close();
    }
}
