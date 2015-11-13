public class Example8_11 {
  public static void main(String[] args) {
    String accountantName = "会计", cashierName = "出纳";
    Bank bank = new Bank(accountantName, cashierName);
    Thread accountant, cashier;
    accountant = new Thread(bank);
    cashier = new Thread(bank);
    accountant.setName(accountantName);
    cashier.setName(cashierName);
    accountant.start();
    cashier.start();
  }
}

class Bank implements Runnable {
  int money = 300;
  String accountantName, cashierName;
  public Bank(String s1, String s2) {
    accountantName = s1;
    cashierName = s2;
  }
  public void run() {
    saveOrTake(30);
  }
  public synchronized void saveOrTake(int number) {
    if (Thread.currentThread().getName().equals(accountantName)) {
      for (int i = 1; i <= 3; i++) {
        money = money + number;
        try {
          Thread.sleep(1000);
        }
        catch(InterruptedException e) {}
        System.out.println("我是" + accountantName + "目前账上有" + money +  "万");
      }
    }
    else if (Thread.currentThread().getName().equals(cashierName)) {
      for (int i = 1; i <= 2; i++) {
        money = money -number/2;
        try {
          Thread.sleep(1000);
        }
        catch(InterruptedException e) {}
        System.out.println("我是" + cashierName + "目前账上有" + money + "万");
      }
    }
  }
}
