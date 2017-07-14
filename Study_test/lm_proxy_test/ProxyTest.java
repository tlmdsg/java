package lm_proxy_test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.TimeUnit;

class MyInvocationHandler implements InvocationHandler {

	private Object proxied;

	public MyInvocationHandler() {
	}

	public MyInvocationHandler(Object proxied) {
		this.proxied = proxied;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("start time: " + System.currentTimeMillis());
		Object result = method.invoke(proxied, args);
		System.out.println("end time: " + System.currentTimeMillis());

		return result;
		// return null;
	}

}

interface Interface {
	String sayHi(String name, String greeting) throws InterruptedException;
}

class impl implements Interface {

	@Override
	public String sayHi(String name, String greeting) throws InterruptedException {
		System.out.println("This is implement.");
		TimeUnit.SECONDS.sleep(3);
		return name + greeting;
	}

}

public class ProxyTest {

	public static void main(String[] args) throws InterruptedException {
		Interface real = new impl();
		Interface proxy = (Interface) Proxy.newProxyInstance(real.getClass().getClassLoader(),
				real.getClass().getInterfaces(), new MyInvocationHandler(real));
		System.out.println(proxy.sayHi("ÀèÃ÷É£", "ÄãºÃ"));
	}

}
