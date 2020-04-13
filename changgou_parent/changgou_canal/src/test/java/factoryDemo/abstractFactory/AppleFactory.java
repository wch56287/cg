package factoryDemo.abstractFactory;

import factoryDemo.pojo.IPhone;
import factoryDemo.pojo.PC;
import factoryDemo.pojo.Phone;

/**
 * @Author: WangChunHui
 * @Date: 2020-03-28 01:04
 * @Description:
 */
public class AppleFactory implements AbstractFactory {
    @Override
    public Phone makePhone() {
        return new IPhone();
    }
    @Override
    public PC makePC() {
        return new MAC();
    }
}

