package lm_reflection_classinfo_test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

//该类封装了传入类或对象的类信息
public class Classinfo {
	Class cla;

	public Classinfo(Object obj) {
		if (obj instanceof Class) {
			System.out.println("这是一个Class对象（类）");
			cla = (Class) obj;
		} else {
			System.out.println("这是一个普通的类的对象");
			this.cla = obj.getClass();
		}
	}

	public String getCla() {
		return cla.getName();
	}
	
	//打印类的方法信息
	public void printClassMethodInfo() {
		System.out.println("类名" + cla.getName());
		System.out.println("\n方法如下：");
		Method[] mts = cla.getDeclaredMethods();
		System.out.println(mts.length);
		for (Method method : mts) {
			System.out.print(method.getName() + "(");
			Class<?>[] paras = method.getParameterTypes();
			for (Class<?> class1 : paras) {
				System.out.print(class1.getSimpleName() + ",");
			}
			System.out.println(")");
		}

	}

	//打印类的变量信息
	public void printClassFieldInfo() {
		System.out.println("类名" + cla.getName());
		System.out.println("变量如下：");
		Field[] fi = cla.getDeclaredFields();
		for (Field field : fi) {
			System.out.print(field.getName() + ",");
		}
		System.out.println("");
	}
}
