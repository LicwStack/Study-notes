public class Example8_13 {
  public static void main(String[] args) {
    A target = new A();
    Thread thread = new Thread(target);
    thread.setName("张三");
    thread.start();
    while (target.getStop() == false) {}
    System.out.println("我是主线程，负责恢复" + thread.getName() + "线程");
    target.restart();
  }
}

class A implements Runnable {
  int number = 0;
  boolean stop = false;
  boolean getStop() {
    return stop;
  }
  public void run() {
    while (true) {
      number++;
      System.out.println(Thread.currentThread().getName() + "的number=" + number);
      if (number == 3) {
        try {
          System.out.println(Thread.currentThread().getName() + "被挂起");
          stop = true;
          hangUP();
          System.out.println(Thread.currentThread().getName() + "恢复执行");
        }
        catch(Exception e) {}
      }
      try {
        Thread.sleep(1000);
      }
      catch(Exception e) {}
    }
  }
  public synchronized void hangUP() throws InterruptedException {
    wait();
  }
  public synchronized void restart() {
    notifyAll();
  }
}
