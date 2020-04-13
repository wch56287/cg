package factoryDemo.abstractFactory;

import factoryDemo.pojo.PC;

/**
 * @Author: WangChunHui
 * @Date: 2020-03-28 01:03
 * @Description:
 */
public class MAC implements PC {
    public MAC() {
        this.make();
    }
    @Override
    public void make() {
        // TODO Auto-generated method stub
        System.out.println("make MAC!");
    }
}