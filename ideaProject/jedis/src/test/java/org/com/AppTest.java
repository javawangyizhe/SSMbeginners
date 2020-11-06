package org.com;

import org.com.pojo.Student;
import org.com.utils.ObjectServia;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Unit test for simple App.
 */
public class AppTest {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    JedisPool jedisPool =(JedisPool)context.getBean("jedisPool");
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {

        Jedis jedis = jedisPool.getResource();
        //jedis.set("student", "zhangsan");
        String student = jedis.get("student");
        System.out.println(student);
        jedis.close();
    }
    /**
     * 对象序列化
     */
    @Test
    public void Test2() throws Exception{
        Jedis jedis = jedisPool.getResource();
        Student student = new Student();
        student.setSname("lisi");
        student.setSaddress("beijing");
        byte[] bytes = ObjectServia.objectToByte(student);
        jedis.set("student1".getBytes(),bytes);
        jedis.close();
    }
    /**
     * 对象反序列化
     */
    @Test
    public void Test3() throws Exception{
        Jedis jedis = jedisPool.getResource();
        byte[] bytes1 = jedis.get("student1".getBytes());
        Student student = ObjectServia.byteToObject(bytes1, Student.class);
        System.out.println(student);
        jedis.close();
    }
}
