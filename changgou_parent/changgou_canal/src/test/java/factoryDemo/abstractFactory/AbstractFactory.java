package factoryDemo.abstractFactory;

import factoryDemo.pojo.PC;
import factoryDemo.pojo.Phone;

/**
 * @Author: WangChunHui
 * @Date: 2020-03-28 01:03
 * @Description:
 */
public interface AbstractFactory {
    Phone makePhone();
    PC makePC();
}