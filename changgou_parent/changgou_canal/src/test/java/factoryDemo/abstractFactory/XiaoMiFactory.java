package factoryDemo.abstractFactory;

import factoryDemo.pojo.MiPhone;
import factoryDemo.pojo.PC;
import factoryDemo.pojo.Phone;

/**
 * @Author: WangChunHui
 * @Date: 2020-03-28 01:04
 * @Description:
 */
public class XiaoMiFactory implements AbstractFactory{
    @Override
    public Phone makePhone() {
        return new MiPhone();
    }
    @Override
    public PC makePC() {
        return new MiPC();
    }
}
