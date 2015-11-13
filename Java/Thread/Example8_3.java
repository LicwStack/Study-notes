public class Example8_3 {
  public static void main(String[] args) {
    Left left = new Left();
    Right right = new Right();
    left.start();
    right.start();
    while (true) {
      if (left.n == 8 || right.n == 8)
        System.exit(0);
    }
  }
}

class Left extends Thread {
  int n = 0;
  public void run() {
    while (true) {
      n++;
      System.out.printf("\n%s", "我在左面写字");
      try {
        sleep((int)(Math.random()*100) + 100);
      }
      catch(InterruptedException e) {}
    }
  }
}

class Right extends Thread {
  int n = 0;
  public void run() {
    while (true) {
      n++;
      System.out.printf("\n%40s", "我在右面写字");
      try {
        sleep((int)(Math.random()*100) + 100);
      }
      catch(InterruptedException e) {}
    }
  }
}
