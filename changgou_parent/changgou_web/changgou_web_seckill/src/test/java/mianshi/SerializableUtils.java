package mianshi;

/**
 * @Author: WangChunHui
 * @Date: 2020-03-28 23:25
 * @Description:
 */

import java.io.*;

import java.lang.reflect.InvocationTargetException;

import java.lang.reflect.Method;


/**
 *  * JDK自带序列化操作
 * <p>
 *  *
 * <p>
 *  * @author tobiasy
 * <p>
 *  
 */

public class SerializableUtils {
    /**
     *      * 序列化 将对象存储到文件中
     * <p>
     *      *
     * <p>
     *      * @param obj  序列化对象，必须实现可序列化接口
     * <p>
     *      * @param path 序列化路径
     * <p>
     *      * @return
     * <p>
     *      
     */
    public static boolean write(Object obj, String path) {
        boolean f;
        File file = getFile(path);
        OutputStream out = null;
        ObjectOutputStream objout = null;
        try {
            out = new FileOutputStream(file);
            objout = new ObjectOutputStream(out);
            objout.writeObject(obj);
            f = true;
        } catch (IOException e) {
            f = false;
            e.printStackTrace();
        } finally {
            close(objout);
            close(out);
        }
        return f;
    }

    /**
     *      * 反序列化 读取存入文件中的对象
     * <p>
     *      *
     * <p>
     *      * @param pathname 反序列化路径
     * <p>
     *      * @return
     * <p>
     *      
     */

    public static Object read(String pathname) {
        Object obj = null;
        File file = new File(pathname);
        InputStream in = null;
        ObjectInputStream objin = null;
        try {
            in = new FileInputStream(file);
            objin = new ObjectInputStream(in);
            obj = objin.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (EOFException e) {
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            close(objin);
            close(in);
        }
        return obj;
    }

    public static File getFile(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file;
    }

    /**
     *      * 流的关闭操作
     * <p>
     *      *
     * <p>
     *      * @param obj 流对象
     * <p>
     *      
     */

    public static void close(Object obj) {
        if (obj != null) {
            try {
                invoke(obj, "close");
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     *      * 执行一个无参方法
     * <p>
     *      *
     * <p>
     *      * @param obj        操作对象
     * <p>
     *      * @param methodName 属性名
     * <p>
     *      * @return Object
     * <p>
     *      * @throws RuntimeException
     * <p>
     *      
     */
    public static Object invoke(Object obj, String methodName) throws RuntimeException {
        if (obj == null || methodName == null) {
            return null;
        }
        Object value = null;
        try {
            Method getMethod = obj.getClass().getMethod(methodName);
            if (getMethod == null) {
                return null;
            }
            getMethod.setAccessible(true);
            value = getMethod.invoke(obj);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return value;
    }
}

