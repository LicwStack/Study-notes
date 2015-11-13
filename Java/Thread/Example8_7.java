public class Example8_7 {
  public static void main(String[] args) {
    String s1 = "会计", s2 = "出纳";
    Bank bank = new Bank(s1, s2);
    bank.setMoney(120);
    bank.zhang.start();
    bank.cheng.start();
  }
}

class Bank implements Runnable {
  private int money = 0;
  String name1, name2;
  Thread zhang, cheng;
  Bank(String s1, String s2) {
    name1 = s1;
    name2 = s2;
    zhang = new Thread(this);
    cheng = new Thread(this);
    zhang.setName(s1);
    cheng.setName(s2);
  }
  public void setMoney(int mount) {
    money =mount;
  }
  public void run() {
    while (true) {
      money = money - 10;
      if (Thread.currentThread() == zhang) {
        System.out.println("我是" + name1 + "现在有" + money + "元");
        if (money <= 100) {
          System.out.println(name1 + "进入死亡状态");
          return;
        }
      }
      else if (Thread.currentThread() == cheng) {
        System.out.println("我是" + name2 + "现在有" + money + "元");
        if (money <= 60) {
          System.out.println(name2 + "进入死亡状态");
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
