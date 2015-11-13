public class Example8_1 {
  public static void main(String[] args) {
    WriteWordThread zhang, wang;		//声明
    zhang = new WriteWordThread("张小红");	//新建线程
    wang = new WriteWordThread("JamsKeven");	//新建线程
    zhang.start();				//启动线程
    for (int i=1; i <= 8; i++) {
      System.out.println("我是主线程中的语句");
    }
    wang.start();				//启动线程
  }
}

class WriteWordThread extends Thread {		//Thread的子类负责创建线程对象
  WriteWordThread(String s) {			//构造方法
    setName(s);					//调用Thread类的setName方法为线程起个名字
  }
  public void run() {
    for (int i=1; i <= 8; i++) {
      System.out.println("我是一个线程，我的名字是" + getName());
    }
  }
}
