

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @Author: WangChunHui
 * @Date: 2020-03-25 01:29
 * @Description:
 */

class MyResource implements Runnable{

//    Map<String, java.lang.Object> map = new Hashtable<>();
    Map<String, java.lang.Object> map = new HashMap<>();

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            map.put(UUID.randomUUID().toString(),i);
            System.out.println(map);
        }
    }
}

public class HashMapTest {
    public static void main(String[] args) {

//        HashMap<String, String> hashMap = new HashMap<>();
//
//        Hashtable<String, String> hashtable = new Hashtable<>();
//
//        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();

//        System.out.println("111111");

        MyResource myResource = new MyResource();

        new Thread(myResource).start();
        new Thread(myResource).start();
    }
}
