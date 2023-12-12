package baekjoon.basic1.data_structure_1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 해결 방안
/*
1. 주어진 문장을 입력받는다.
2. 단어간의 순서는 유지하되, 각 단어를 모두 뒤집어서 다시 출력한다.
    2-1. 개별 단어를 StringTokenizer 를 통해 나눈다.
    2-2. 개별 단어들을 리스트에 저장한다.
    2-3. 해당 리스트를 가져와서 StringBuffer.reverse()를 사용한다.
 */

public class Problem_9093 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());


        for (int i = 0; i < count; i++) {
            List<String> strings = new ArrayList<>(count);
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            while(st.hasMoreTokens()) {
                strings.add(st.nextToken());
            }
            strings.stream()
                    .map(string -> new StringBuilder(string).reverse().toString())
                    .forEach(string -> System.out.print(string + " "));
        }

        br.close();
    }
}
