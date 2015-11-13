public class Example8_15 {
  public static void main(String[] args) {
    Company a = new Company();
    a.employee.start();
  }
}

class Company implements Runnable {
  Thread boss, employee;
  String[] content = {"今天晚上，", "大家不要", "回去的太早，", "还有工作", "需要大家做！"};
  Company() {
    employee = new Thread(this);
    boss = new Thread(this);
    boss.setName("老板");
  }
  public void run() {
    if (Thread.currentThread() == employee) {
      System.out.println("我等" + boss.getName() + "说完再说话");
      boss.start();
      while (boss.isAlive() == false) {}
      try {
        boss.join();
      }
      catch(InterruptedException e) {}
      System.out.printf("\n我开始说话：\"我明白你的意思了，谢谢\"\n");
    }
    else if (Thread.currentThread() == boss) {
      System.out.println(boss.getName() + "说：");
      for (int i = 0; i < content.length; i++) {
        System.out.print(content[i]);
        try {
         Thread.sleep(1000);
        }
        catch(InterruptedException e) {}
      }
    }
  }
}
