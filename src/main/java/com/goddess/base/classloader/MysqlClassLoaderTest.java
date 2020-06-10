package com.goddess.base.classloader;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * 数据库驱动的加载问题
 *
 * @author qinshengke
 * @since 2020/1/3
 */
public class MysqlClassLoaderTest {

    public static void main(String[] args) {

        ClassLoader parent = MysqlClassLoaderTest.class.getClassLoader().getParent();

        System.out.println(parent); // 扩展类加载器

        // 重要
        ServiceLoader<Driver> load = ServiceLoader.load(Driver.class);
        Iterator<Driver> iterator = load.iterator();

        while (iterator.hasNext()) {
            Driver next = iterator.next();
            System.out.println("Driver: " + next.getClass() + ", classLoader:" + next.getClass().getClassLoader());
        }
        System.out.println(Thread.currentThread().getContextClassLoader());
        System.out.println(ServiceLoader.class.getClassLoader());

    }

    /**
     * 研究一下mysql驱动器的加载过程
     *
     * @throws Exception
     */
    private void connectSql() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("", "", "");


    }

}
