public class Example8_2 {
  public static void main(String[] args) {
    WriteWordThread zhang, wang;		//声明
    zhang = new WriteWordThread("张小红", 200);	//新建线程
    wang = new WriteWordThread("JamsKeven", 100);	//新建线程
    zhang.start();				//启动线程
    wang.start();				//启动线程
  }
}

class WriteWordThread extends Thread {		//Thread的子类负责创建线程对象
  int n = 0;					//成员变量
  WriteWordThread(String s, int n) {			//构造方法
    setName(s);					//调用Thread类的setName方法为线程起个名字
    this.n = n;					//使用this区分成员变量与局部变量
  }
  public void run() {
    for (int i=1; i <= 8; i++) {
      System.out.println("我是一个线程，我的名字是" + getName());
      try {
        sleep(n);
      }
      catch(InterruptedException e) {}
    }
  }
}
