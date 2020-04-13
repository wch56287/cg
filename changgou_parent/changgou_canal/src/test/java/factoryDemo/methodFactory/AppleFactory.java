package factoryDemo.methodFactory;

import factoryDemo.pojo.IPhone;
import factoryDemo.pojo.Phone;

/**
 * @Author: WangChunHui
 * @Date: 2020-03-28 00:57
 * @Description:
 */
public class AppleFactory implements AbstractFactory {
    @Override
    public Phone makePhone() {
        return new IPhone();
    }
}