import java.util.concurrent.*;

/**
 * @Author: WangChunHui
 * @Date: 2020-03-27 20:23
 * @Description:
 */
public class SingletonTest {


    private SingletonTest() {
    }

    private volatile static SingletonTest singleton = null;

    public static SingletonTest singleton001() {
        if (singleton == null) {
            synchronized (SingletonTest.class) {
                if (singleton == null) {
                    singleton = new SingletonTest();
                }
            }
        }
        return singleton;
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        for (int i = 0; i < 10; i++) {
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    System.out.println(singleton001());
//                }
//            }).start();
//        }

        FutureTask<String> futureTask = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "111";
            }
        });

        futureTask.run();

        String s = futureTask.get();

        System.out.println(s);


//        ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(1);
//        threadPool.execute(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(1);
//            }
//        });
//
//        threadPool.shutdown();
    }
}
