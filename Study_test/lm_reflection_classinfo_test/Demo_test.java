package lm_reflection_classinfo_test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Demo_test {

	public static void main(String[] args) {
		Classinfo ci = new Classinfo(String.class);
		// Classinfo ci = new Classinfo(123);
		
		 ci.printClassMethodInfo();
		 System.out.println("==========");
		 ci.printClassFieldInfo();


		// ����ʱʹ����ͷ���
		try {
			Class box = Class.forName("lm_treeset_test.Box");
			System.out.println("���ҵ�");
			Object obj = box.newInstance();
			//ʹ��invoke���з��䷽���Ĳ���
			Method method = box.getDeclaredMethod("sum", int[].class);
			System.out.println(method.invoke(obj,new int[]{5,2,3}));
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

	}

}
