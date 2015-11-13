class TargetObject implements Runnable {
  private int number = 0;
  public void setNumber(int n) {
    number = n;
  }
  public void run() {
    while (true) {
      if (Thread.currentThread().getName().equals("add")) {
        number++;
        System.out.printf("%d\n", number);
      }
      if (Thread.currentThread().getName().equals("sub")) {
        number--;
        System.out.printf("%12d\n", number);
      }
      try {
        Thread.sleep(1000);
      }
      catch(InterruptedException e) {}
    }
  }
}

public class Example8_6 {
  public static void main(String[] args) {
    Thread threadA, threadB, threadC, threadD;
    TargetObject a1 = new TargetObject();
    TargetObject a2 = new TargetObject();
    threadA = new Thread(a1);
    threadB = new Thread(a1);
    a1.setNumber(10);
    threadA.setName("add");
    threadB.setName("add");
    threadC = new Thread(a2);
    threadD = new Thread(a2);
    a2.setNumber(-10);
    threadC.setName("sub");
    threadD.setName("sub");
    threadA.start();
    threadB.start();
    threadC.start();
    threadD.start();
  }
}
