/**
 * @Author: WangChunHui
 * @Date: 2020-03-27 18:48
 * @Description:
 */
public class Singleton {
    //把Singleton的无参构造私有化，禁止外界new
    private Singleton() {
    }
    //在类的内部定义一个本类类型的成员常量,加volatile，禁止指令重排
    private static volatile Singleton singleton;

    public static Singleton getSingleton() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(getSingleton());
                }
            }).start();
        }
    }
}
