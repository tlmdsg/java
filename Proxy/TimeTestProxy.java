/**
 * 
 */
package TimeTestProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Date;
import java.util.concurrent.TimeUnit;

class TimeProxy implements InvocationHandler {

	private Object proxied;

	public TimeProxy(Object proxied) {
		this.proxied = proxied;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

		System.out.println("start time:" + new Date());
		Object returnobj = method.invoke(proxied, args);
		System.out.println("end time:" + new Date());

		// return returnobj;
		return "failed";
	}

}

interface Inter {
	String doSomething() throws InterruptedException;
}

class Real implements Inter {

	@Override
	public String doSomething() throws InterruptedException {
		System.out.println("this is real obj");
		TimeUnit.SECONDS.sleep(3);
		return "success";
	}

}

/**
 * @author tlm
 */
public class TimeTestProxy {

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		Inter real = new Real();
		Inter proxy = (Inter) Proxy.newProxyInstance(Inter.class.getClassLoader(), new Class<?>[] { Inter.class },
				new TimeProxy(real));
		String string = proxy.doSomething();
		System.out.println(string);
	}

}
