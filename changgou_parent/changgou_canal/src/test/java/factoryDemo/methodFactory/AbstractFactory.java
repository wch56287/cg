package factoryDemo.methodFactory;

import factoryDemo.pojo.Phone;

/**
 * @Author: WangChunHui
 * @Date: 2020-03-28 00:52
 * @Description:
 */
public interface AbstractFactory {
    Phone makePhone();
}