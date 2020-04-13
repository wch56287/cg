package factoryDemo.abstractFactory;

/**
 * @Author: WangChunHui
 * @Date: 2020-03-28 01:05
 * @Description:
 */
public class Demo03 {
    public static void main(String[] arg) {
        AbstractFactory miFactory = new XiaoMiFactory();
        AbstractFactory appleFactory = new AppleFactory();
        miFactory.makePhone();            // make xiaomi phone!
        miFactory.makePC();                // make xiaomi PC!
        appleFactory.makePhone();        // make iphone!
        appleFactory.makePC();            // make MAC!
    }
}
