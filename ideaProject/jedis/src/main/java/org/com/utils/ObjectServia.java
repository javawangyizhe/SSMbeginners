package org.com.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectServia {
    /**
     * 对象序列化
     */
    public static byte[] objectToByte(Object obj) throws Exception{

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(obj);
        byte[] bytes = baos.toByteArray();
        oos.close();
        baos.close();
        return bytes;
    }
    /**
     * 对象反序列化
     */
    public static <T> T byteToObject(byte[] bytes,Class<T> clz) throws Exception{
        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        ObjectInputStream ois = new ObjectInputStream(bais);
        T t = (T)ois.readObject();
        ois.close();
        bais.close();
        return t;
    }
}
