package baekjoon.basic0.stack_queue_deck;

import java.io.*;
import java.util.*;

/*
  - 풍선을 터뜨리면 숫자가 나오는데 그 숫자만큼 이동해서 또 그 풍선을 터뜨리자!

  1. 각 풍선에는 -n 이상, n 이하의 수가 들어있다. 따라서 풍선을 터뜨린다면 왼쪽으로 갈 수도 있고 오른쪽으로 갈 수도 있다.
  2. 제일 처음에는 1번 풍선을 터뜨린다.
  3. 만약 + 가 나와 오른쪽으로 간다면 -> value번 만큼 맨 앞의 수를 poll 한다음 맨 뒤로 offer하는데 맨 첫 번째 풍선은 그냥 poll만 한다.
  4. 만약 - 가 나와 왼쪽으로 간다면 -> k번 만큼 맨 뒤의 수를 poll 한다음 맨 앞으로 offer하는데 맨 첫 번째 풍선은 그냥 poll만 한다. - 가 나온다면 다음에는 처음에 맨 뒤 풍선으로 인덱스가 간다.
  5. 앞뒤로 poll과 offer을 모두 진행해야 하므로 큐가 아닌 덱을 사용하는 게 맞다.
*/

public class Problem_2346 {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();

    int n = Integer.parseInt(br.readLine());
    int moveNum = 0, sequence = 1;
    int index = 0; // 만약 index가 덱의 맨 처음을 가리킨다면 0, 마지막을 가리킨다면 1
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    Deque<Integer> deque = new LinkedList<>();
    for (int i = 0; i < n; i++) {
      deque.offerLast(i + 1);
    }

    Deque<Integer> value = new LinkedList<>();
    for (int i = 0; i < n; i++) {
      value.offerLast(Integer.parseInt(st.nextToken()));
    }

    for (int i = 0; i < n - 1; i++) {
      if (i == 0) {
        sb.append(1).append(" ");
        moveNum = value.peekFirst();
        StringTokenizer st2 = new StringTokenizer(move(deque, value, sequence, index, moveNum), " ");
        sb.append(st2.nextToken()).append(" ");
        moveNum = Integer.parseInt(st2.nextToken());
        index = Integer.parseInt(st2.nextToken());
      } else {
        StringTokenizer st2 = new StringTokenizer(move(deque, value, sequence, index, moveNum), " ");
        sb.append(st2.nextToken()).append(" ");
        moveNum = Integer.parseInt(st2.nextToken());
        index = Integer.parseInt(st2.nextToken());
      }
    }

    bw.write(sb.toString());
    bw.close();
  }

  static String move(Deque<Integer> deque, Deque<Integer> value, int sequence, int index, int moveNum) {

    if (moveNum > 0) { // 풍선에서 나온 수가 양수일 때
      if (index == 0) { // 인덱스가 덱의 맨 앞에 있을 때
        deque.pollFirst();
        moveNum = value.pollFirst(); // 풍선에서 나온 수를 저장한다.

        for (int i = 0; i < moveNum - 1; i++) { // 풍선에서 나온 수만큼 이동한다.
          deque.offerLast(deque.pollFirst());
          value.offerLast(value.pollFirst());
        }
        sequence = deque.peekFirst(); // 풍선을 터뜨리고 나온 수만큼 이동한다.
        index = 0;

        return sequence + " " + moveNum + " " + index;
      } else {
        deque.pollLast();
        moveNum = value.pollLast(); // 풍선에서 나온 수를 저장한다.

        for (int i = 0; i < moveNum - 1; i++) { // 풍선에서 나온 수만큼 이동한다.
          deque.offerLast(deque.pollFirst());
          value.offerLast(value.pollFirst());
        }
        sequence = deque.peekFirst(); // 풍선을 터뜨리고 나온 수만큼 이동한다.
        index = 0;

        return sequence + " " + moveNum + " " + index;
      }

    } else { // 풍선에서 나온 수가 음수일 때
      if (index == 0) { // 인덱스가 덱의 맨 앞에 있을 때
        deque.pollFirst();
        moveNum = value.pollFirst(); // 풍선에서 나온 수를 저장한다.

        for (int i = 0; i < Math.abs(moveNum) - 1; i++) {
          deque.offerFirst(deque.pollLast());
          value.offerFirst(value.pollLast());
        }
        sequence = deque.peekLast(); // 풍선을 터뜨리고 나온 수만큼 이동한다.
        index = 1;

        return sequence + " " + moveNum + " " + index;
      } else { // 인덱스가 덱의 맨 뒤에 있을 때
        deque.pollLast();
        moveNum = value.pollLast(); // 풍선에서 나온 수를 저장한다.

        for (int i = 0; i < Math.abs(moveNum) - 1; i++) { // 풍선에서 나온 수만큼 이동한다.
          deque.offerFirst(deque.pollLast());
          value.offerFirst(value.pollLast());
        }
        sequence = deque.peekLast(); // 풍선을 터뜨리고 나온 수만큼 이동한다.
        index = 1;

        return sequence + " " + moveNum + " " + index;
      }

    }
  }
}

