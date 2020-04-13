package factoryDemo.simpleFactory;

import factoryDemo.pojo.IPhone;
import factoryDemo.pojo.Phone;

/**
 * @Author: WangChunHui
 * @Date: 2020-03-28 00:47
 * @Description:
 */
public class Demo01 {
    public static void main(String[] arg) {
        PhoneFactory factory = new PhoneFactory();
        Phone miPhone = factory.makePhone("MiPhone");            // make xiaomi phone!
        IPhone iPhone = (IPhone)factory.makePhone("iPhone");    // make iphone!
//        System.out.println(miPhone);
//        System.out.println(iPhone);
    }
}
