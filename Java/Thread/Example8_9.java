public class Example8_9 {
  public static void main(String[] args) {
    A a = new A();
    a.thread.start();
  }
}

class A implements Runnable {
  Thread thread;
  int n = 0;
  A() {
    thread = new Thread(this);
  }
  public void run() {
    while (true) {
      n++;
      System.out.println(new java.util.Date());
      try {
        Thread.sleep(1000);
      }
      catch(InterruptedException e) {}
      if (n == 3) {
        thread = new Thread(this);
        thread.start();
      }
    }
  }
}
