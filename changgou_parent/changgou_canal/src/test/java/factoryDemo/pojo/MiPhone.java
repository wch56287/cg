package factoryDemo.pojo;

/**
 * @Author: WangChunHui
 * @Date: 2020-03-28 00:46
 * @Description:
 */
public class MiPhone implements Phone {
    public MiPhone() {
        this.make();
    }
    @Override
    public void make() {
        // TODO Auto-generated method stub
        System.out.println("make xiaomi phone!");
    }
}
