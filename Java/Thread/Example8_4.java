public class Example8_4 {
  public static void main(String[] args) {
    Left targetOfLeft = new Left();
    Thread left = new Thread(targetOfLeft);
    Right targetOfRight = new Right();
    Thread right = new Thread(targetOfRight);
    left.start();
    right.start();
    while (true) {
      if (targetOfLeft.n == 8 || targetOfRight.n == 8)
        System.exit(0);
    }
  }
}

class Left implements Runnable {
  int n = 0;
  public void run() {
    while (true) {
      n++;
      System.out.printf("\n%s", "我在左面写字");
      try {
        Thread.sleep((int)(Math.random()*100) + 100);
      }
      catch(InterruptedException e) {}
    }
  }
}

class Right implements Runnable {
  int n = 0;
  public void run() {
    while (true) {
      n++;
      System.out.printf("\n%40s", "我在右面写字");
      try {
        Thread.sleep((int)(Math.random()*100) + 100);
      }
      catch(InterruptedException e) {}
    }
  }
}
