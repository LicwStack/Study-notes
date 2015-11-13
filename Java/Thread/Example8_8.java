public class Example8_8 {
  public static void main(String[] args) {
    String s1 = "张三", s2 = "Jam.Keven";
    Move move = new Move(s1, s2);
    Thread zhang, keven;
    zhang = new Thread(move);
    keven = new Thread(move);
    zhang.setName(s1);
    keven.setName(s2);
    zhang.start();
    keven.start();
  }
}

class Move implements Runnable {
  String s1, s2;
  Move(String s1, String s2) {
    this.s1 = s1;
    this.s2 = s2;
  }
  public void run() {
    int i = 0;
    while (true) {
      if (Thread.currentThread().getName().equals(s1)) {
        i = i + 1;
        System.out.println(s1 + "线程的局部变量：" + i);
        if (i >= 4) {
          System.out.println(s1 + "线程进入死亡状态");
          return;
        }
      }
      else if (Thread.currentThread().getName().equals(s2)) {
        i = i - 1;
        System.out.println(s2 + "线程的局部变量：" + i);
        if (i <= -4) {
          System.out.println(s2 + "线程进入死亡状态");
          return;
        }
      }
      try {
        Thread.sleep(800);
      }
      catch(InterruptedException e) {}
    }
  }
}
