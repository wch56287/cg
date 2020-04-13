/**
 * ‎Hangzhou Lejian Technology Co., Ltd.
 * Copyright (c) 2019 All Rights Reserved.
 */
package mianshi;
/**
 * 用户注册入口
 *
 * @author Your Name
 */

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 *  * 用户手机号注册校验
 * <p>
 *  *
 * <p>
 *  * @author tobiasy
 * <p>
 *  
 */

public class Test2 {

    /**
     *      * 缓存地址
     * <p>
     *      
     */

    private static final String FILE_PATH = "D:\\test\\data.txt";

    public static void main(String[] args) {
        /**
         * TODO 请从这里开始补充代码
         *
         * 测试1：138 1234 1234
         *	结果：通过此手机号注册成功
         *
         * 测试2：13812345abc
         *	结果：通知本手机号无法注册，提示为非法手机号
         *
         * 测试3：13812345678
         *	结果：通知此手机号注册成功
         *
         * 测试4：138 1234 5678
         *	结果：提示此手机号已经被其他用户注册
         *
         * 测试5：98765432101
         *	结果：此手机号码为中国大陆非法手机号码
         */

        String phoneNum1 = "138 1234 1234";

        String phoneNum2 = "13812345abc";

        String phoneNum3 = "13812345678";

        String phoneNum4 = "138 1234 5678";

        String phoneNum5 = "98765432101";

        start(phoneNum1);

    }

    /**
     *      * 启动方法
     * <p>
     *      * @param phone
     * <p>
     *      
     */

    private static void start(String phone) {
        if (check(phone)) {
            register(format(phone));
        } else {
            err("非法手机号码！");
        }
        out(String.format("已注册账号：%s", getRegisterPhoneNums()));
    }


    private static void err(Object o) {
        System.err.println(o);
    }

    private static void out(Object o) {
        System.out.println(o);
    }

    /**
     *      * 创建文件
     * <p>
     *      * @return
     * <p>
     *      
     */

    private static boolean createFile() {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            try {
                File parentFile = file.getParentFile();
                if (!parentFile.exists()) {
                    parentFile.mkdirs();

                }
                file.createNewFile();
            } catch (IOException e) {
                return false;
            }
        }
        return true;
    }

    /**
     *      * 反序列化
     * <p>
     *      * @return
     * <p>
     *      
     */

    private static Object getRegisterPhoneNums() {
        return SerializableUtils.read(FILE_PATH);
    }

    /**
     *      * 格式化手机号码
     * <p>
     *      * @param phoneNum
     * <p>
     *      * @return
     * <p>
     *      
     */

    private static String format(String phoneNum) {
        return phoneNum.replaceAll("( )\\1*", "");
    }

    /**
     *      * 注册
     * <p>
     *      * @param phoneNum
     * <p>
     *      
     */

    public static void register(String phoneNum) {
        try {
            if (!createFile()) {
                err("缓存文件地址错误！");
            } else {
                List<String> data;
                Object object = SerializableUtils.read(FILE_PATH);
                if (object != null) {
                    data = (List<String>) object;
                    boolean contains = data.contains(phoneNum);
                    if (contains) {
                        err("该手机号已被注册！");
                    } else {
                        data.add(phoneNum);
                        out("注册成功！");
                    }
                } else {
                    data = new ArrayList<>();
                    data.add(phoneNum);
                    out("注册成功！");
                }
                SerializableUtils.write(data, FILE_PATH);
            }
        } catch (Exception e) {
            err("序列化异常！");
        }

    }

    /**
     *      * 校验手机号码是否正确
     * <p>
     *      * @param phoneNum
     * <p>
     *      * @return
     * <p>
     *      
     */
    private static boolean check(String phoneNum) {
        return phoneNum.matches("1(3[0-9]|5[189]|8[6789])( )?[0-9]{4}( )?[0-9]{4}");
    }

}
