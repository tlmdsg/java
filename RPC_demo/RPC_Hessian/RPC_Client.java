/**
 * 
 */
package RPC_Hessian;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import com.caucho.hessian.io.HessianInput;
import com.caucho.hessian.io.HessianOutput;

class RPCClient<T> {
	@SuppressWarnings("unchecked")
	public static <T> T getRemoteProxyObj(final Class<?> serviceInterface, final InetSocketAddress addr) {
		// 1.�����صĽӿڵ���ת����JDK�Ķ�̬�����ڶ�̬������ʵ�ֽӿڵ�Զ�̵���
		return (T) Proxy.newProxyInstance(serviceInterface.getClassLoader(), new Class<?>[] { serviceInterface },
				new InvocationHandler() {
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						Socket socket = null;
						HessianOutput output = null;
						HessianInput input = null;
						try {
							// 2.����Socket�ͻ��ˣ�����ָ����ַ����Զ�̷����ṩ��
							socket = new Socket();
							socket.connect(addr);

							long begin = System.currentTimeMillis();
							
							// 3.��Զ�̷����������Ľӿ��ࡢ�������������б�ȱ�����͸������ṩ��
							output = new HessianOutput(socket.getOutputStream());
							output.writeString(serviceInterface.getName());
							output.writeString(method.getName());
							output.writeObject(method.getParameterTypes());
							output.writeObject(args);

							// 4.ͬ�������ȴ�����������Ӧ�𣬻�ȡӦ��󷵻�
							input = new HessianInput(socket.getInputStream());
							Object result = input.readObject();
							// System.out.println("....."+result.getClass().getName());
							
							System.out.println("����ʱΪ��"+(System.currentTimeMillis() - begin)+"ms");
							
							return result;
						} finally {
							if (socket != null)
								socket.close();
							if (output != null)
								output.close();
							if (input != null)
								input.close();
						}
					}
				});
	}
}

/**
 * @author tlm
 *
 */
public class RPC_Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		HelloService service = RPCClient.getRemoteProxyObj(HelloService.class,
				new InetSocketAddress("localhost", 8088));
		System.out.println(service.sayHi("tlm"));
	}

}
