package factoryDemo.methodFactory;


import factoryDemo.pojo.MiPhone;
import factoryDemo.pojo.Phone;

/**
 * @Author: WangChunHui
 * @Date: 2020-03-28 00:53
 * @Description:
 */
public class XiaoMiFactory implements AbstractFactory{
    @Override
    public Phone makePhone() {
        return new MiPhone();
    }
}