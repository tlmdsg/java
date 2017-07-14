package com.lm.mySpring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Person implements ApplicationContextAware, BeanNameAware, InitializingBean, DisposableBean {
	private String dosenotExist;
	private Axe axe;
	private String beanName;
	private ApplicationContext applicationContext;

	public Person() {
		System.out.println("构造bean实例");
	}

	public void useAxe() {
		System.out.println("beanName:" + beanName);
		System.out.println("applicationContext:" + applicationContext.isSingleton(beanName));
		System.out.println(this == applicationContext.getBean(beanName));
		System.out.println("我要用斧子砍柴");
		axe.chop();
	}

	public void setAxe(Axe axe) {
		System.out.println("正在注入依赖关系");
		this.axe = axe;
	}

	public void setBeanName(String name) {
		System.out.println("执行BeanNameAware接口的setBeanName方法获取bean的ID值");
		this.beanName = name;
	}

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("执行ApplicationContextAware接口的setApplicationContext方法获取spring容器");
		this.applicationContext = applicationContext;
	}

	public void afterPropertiesSet() throws Exception {
		System.out.println("完成依赖关系注入后执行的InitializingBean接口的afterPropertiesSet方法");
	}

	public void init() {
		System.out.println("完成依赖关系注入后执行的init方法");
	}

	public void destroy() throws Exception {
		System.out.println("执行关闭前的DisposableBean接口的destroy方法");
	}

	public void close() {
		System.out.println("执行关闭前的close方法");
	}

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		Person person = context.getBean("person", Person.class);
		person.useAxe();
		((AbstractApplicationContext) context).registerShutdownHook();
	}
}
