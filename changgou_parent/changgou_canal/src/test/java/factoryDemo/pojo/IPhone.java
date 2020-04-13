package factoryDemo.pojo;

/**
 * @Author: WangChunHui
 * @Date: 2020-03-28 00:47
 * @Description:
 */
public class IPhone implements Phone {
    public IPhone() {
        this.make();
    }
    @Override
    public void make() {
        // TODO Auto-generated method stub
        System.out.println("make iphone!");
    }
}

