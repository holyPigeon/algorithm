package baekjoon.basic1.data_structure_1;

import java.io.*;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/*
- title: 요세푸스 문제에 따라 주어진 번호의 제거 순서를 출력한다.
- ex). 1 2 3 4 5 6 7 / 7 3 -> 2 3 4 5 6 7 1 -> 3 4 5 6 7 1 2 -> 4 5 6 7 1 2 3
- 4 5 6 7 1 2 (3)
- 7 1 2 4 5 (6)
- 4 5 7 1 (2)
- 1 4 5 (7)
- 1 4 (5) if size < 3
- 4 (1)
- (4)
 */

public class Problem_1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String[] tokens = br.readLine().split(" ");
        int n = Integer.parseInt(tokens[0]);
        int k = Integer.parseInt(tokens[1]);

        List<Integer> result = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            deque.offerFirst(i);
        }

        while (deque.size() > 0) {
            for (int i = 0; i < k - 1; i++) {
                deque.offerFirst(deque.pollLast());
            }
            result.add(deque.pollLast());
        }

        String resultString = result.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", ", "<", ">"));

        bw.write(resultString);
        bw.close();
        br.close();

    }
}
