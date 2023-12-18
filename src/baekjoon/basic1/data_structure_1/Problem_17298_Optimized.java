package baekjoon.basic1.data_structure_1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class Problem_17298_Optimized {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int count = Integer.parseInt(br.readLine());
        String[] tokens = br.readLine().split(" ");
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            numbers.add(Integer.parseInt(tokens[i]));
        }

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < count; i++) {
            while (!stack.isEmpty() && numbers.get(stack.peek()) < numbers.get(i)) {
                int index = stack.pop();
                numbers.set(index, numbers.get(i));
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            numbers.set(stack.pop(), -1);
        }

        // 결과 출력
        sb.append(numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" ")));

        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
