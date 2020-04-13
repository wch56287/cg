import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: WangChunHui
 * @Date: 2020-03-27 20:35
 * @Description:
 */
class MyNum {
    public volatile Integer num = 0;

    public void changeNumTo20() {
        num = 20;
    }
}


public class VolatileDemo {
    public static void main(String[] args) {
        MyNum myNum = new MyNum();
        new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myNum.changeNumTo20();
        }).start();
        System.out.println("程序到这");
        while (myNum.num == 0) {

        }
        System.out.println("程序结束");

//        CopyOnWriteArrayList;
//        AtomicInteger
    }
}
