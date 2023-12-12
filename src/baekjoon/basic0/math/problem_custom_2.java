package baekjoon.basic0.math;

import java.io.*;
import java.util.*;

public class problem_custom_2 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int num = Integer.parseInt(br.readLine());
    int minDistance;
    int minIndex = 0;


    // 현재 은찬이의 위치
    Position myPosition = new Position(2, 1);
    // treasure 클래스 타입의 배열을 num 크기만큼 선언
    Treasure[] treasures = new Treasure[num];

    // treasure 타입의 배열에 입력값을 채운 객체를 생성하여 주입
    for (int i = 0; i < num; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      treasures[i] = new Treasure(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
    }

    // minDistance를 treasures[0]가지의 거리로 초기화
    minDistance = getDistance(myPosition.x, myPosition.y, treasures[0].x, treasures[0].y);

    // 각 보물들 사이이 거리를 비교하여 거리가 3 이하인 보물 중 가장 가까운 보물을 찾는다.
    for (int i = 0; i < num; i++) {
      int distance = getDistance(myPosition.x, myPosition.y, treasures[i].x, treasures[i].y);
        if (distance <= 3 && distance < minDistance) {
          minDistance = distance;
          minIndex = i;
        }
    }

    /**
     * 만약 거리가 같은 경우
     */
//    Map<Treasure, Integer> sameDistanceTreasures = new HashMap<>();
//    List<Treasure> treasureSet = new ArrayList<>();
//
//    for (int i = 0; i < num; i++) {
//      int distance = getDistance(myPosition.x, myPosition.y, treasures[i].x, treasures[i].y);
//      if (distance == minDistance) {
//        sameDistanceTreasures.put(treasures[i], i);
//        treasureSet.add(treasures[i]);
//      }
//    }
//
//    if (sameDistanceTreasures.size() != 1) {
//      int maxValue = treasureSet.get(0).value;
//
//      for (int i = 0; i < sameDistanceTreasures.size(); i++) {
//        if (treasureSet.get(i).value > maxValue) {
//          maxValue = treasureSet.get(i).value;
//          minIndex = sameDistanceTreasures.get(treasureSet.get(i));
//        }
//      }
//    }



    StringBuilder sb = new StringBuilder()
        .append(treasures[minIndex].x)
        .append(" ")
        .append(treasures[minIndex].y)
        .append(" ")
        .append(treasures[minIndex].value);

    bw.write(String.valueOf(sb));

    br.close();
    bw.close();
  }

  // 보물의 위치 좌표와 가치를 나타내는 클래스
  static class Treasure {
    // 필드 변수 선언
    int x;
    int y;
    int value;

    // 생성자 선언
    public Treasure(int x, int y, int value) {
      this.x = x;
      this.y = y;
      this.value = value;
    }
  }

  // 은찬이의 위치를 나타내는 클래스
  static class Position {

    int x;
    int y;

    public Position(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  public static int getDistance(int x1, int y1, int x2, int y2) {
    // 햔재 은찬이의 위치로부터 보물까지의 거리
    return Math.abs(x1 - x2) + Math.abs(y1 - y2);
  }
}

//3
//    2 2 3
//    2 4 4
//    3 1 4
//
//    2 1