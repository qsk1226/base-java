package com.goddess.base.annotation;

import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * .
 *
 * @author qinshengke
 * @since 2021/1/22
 **/
public class AnnotationTest {

	public static void main(String[] args) throws Exception{
		Class<BleachTest> bleachTestClass = BleachTest.class;

		Annotation[] annotations = bleachTestClass.getAnnotations();

		Constructor<?>[] constructors = bleachTestClass.getConstructors();

		Method[] methods = bleachTestClass.getMethods();
		Method sayHello = bleachTestClass.getMethod("sayHello", String.class);

		Field[] declaredFields = bleachTestClass.getDeclaredFields();

	}

}
