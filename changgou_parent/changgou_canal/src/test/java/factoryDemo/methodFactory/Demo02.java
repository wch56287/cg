package factoryDemo.methodFactory;

/**
 * @Author: WangChunHui
 * @Date: 2020-03-28 00:57
 * @Description:
 */
public class Demo02 {
    public static void main(String[] arg) {
        AbstractFactory miFactory = new XiaoMiFactory();
        AbstractFactory appleFactory = new AppleFactory();
        miFactory.makePhone();            // make xiaomi phone!
        appleFactory.makePhone();        // make iphone!
    }
}