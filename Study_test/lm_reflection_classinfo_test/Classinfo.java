package lm_reflection_classinfo_test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

//�����װ�˴��������������Ϣ
public class Classinfo {
	Class cla;

	public Classinfo(Object obj) {
		if (obj instanceof Class) {
			System.out.println("����һ��Class�����ࣩ");
			cla = (Class) obj;
		} else {
			System.out.println("����һ����ͨ����Ķ���");
			this.cla = obj.getClass();
		}
	}

	public String getCla() {
		return cla.getName();
	}
	
	//��ӡ��ķ�����Ϣ
	public void printClassMethodInfo() {
		System.out.println("����" + cla.getName());
		System.out.println("\n�������£�");
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

	//��ӡ��ı�����Ϣ
	public void printClassFieldInfo() {
		System.out.println("����" + cla.getName());
		System.out.println("�������£�");
		Field[] fi = cla.getDeclaredFields();
		for (Field field : fi) {
			System.out.print(field.getName() + ",");
		}
		System.out.println("");
	}
}
