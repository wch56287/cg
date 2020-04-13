package factoryDemo.simpleFactory;

import factoryDemo.pojo.IPhone;
import factoryDemo.pojo.MiPhone;
import factoryDemo.pojo.Phone;

/**
 * @Author: WangChunHui
 * @Date: 2020-03-28 00:47
 * @Description:
 */
public class PhoneFactory {
    public Phone makePhone(String phoneType) {
        if(phoneType.equalsIgnoreCase("MiPhone")){
            return new MiPhone();
        }
        else if(phoneType.equalsIgnoreCase("iPhone")) {
            return new IPhone();
        }
        return null;
    }
}
