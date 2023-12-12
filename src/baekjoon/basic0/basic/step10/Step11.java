package baekjoon.basic0.basic.step10;

import java.io.*;
import java.util.*;

class Member {
  private int age;
  private String name;
  private int id;

  public Member(int id, int age, String name) {
    this.id = id;
    this.age = age;
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public void plusId() {
    this.id++;
  }
}

public class Step11 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String str1 = br.readLine();
    int testcase = Integer.parseInt(str1);
    ArrayList<Member> members = new ArrayList<>();

    for (int i = 0; i < testcase; i++) {
      String str2 = br.readLine();
      StringTokenizer st= new StringTokenizer(str2, " ");

      int age = Integer.parseInt(st.nextToken());
      String name = st.nextToken();

      members.add(new Member(i + 1, age, name));

    }

    members.sort((m1, m2) -> {
      if (m1.getAge() == m2.getAge()) {
        return m1.getId() - m2.getId();
      } else {
        return m1.getAge() - m2.getAge();
      }
    });

    for (Member m: members) {
      bw.write(m.getAge() + " " + m.getName() + "\n");
    }

    bw.flush();
  }
}
