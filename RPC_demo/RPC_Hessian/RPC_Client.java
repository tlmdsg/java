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
		// 1.将本地的接口调用转换成JDK的动态代理，在动态代理中实现接口的远程调用
		return (T) Proxy.newProxyInstance(serviceInterface.getClassLoader(), new Class<?>[] { serviceInterface },
				new InvocationHandler() {
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						Socket socket = null;
						HessianOutput output = null;
						HessianInput input = null;
						try {
							// 2.创建Socket客户端，根据指定地址连接远程服务提供者
							socket = new Socket();
							socket.connect(addr);

							long begin = System.currentTimeMillis();
							
							// 3.将远程服务调用所需的接口类、方法名、参数列表等编码后发送给服务提供者
							output = new HessianOutput(socket.getOutputStream());
							output.writeString(serviceInterface.getName());
							output.writeString(method.getName());
							output.writeObject(method.getParameterTypes());
							output.writeObject(args);

							// 4.同步阻塞等待服务器返回应答，获取应答后返回
							input = new HessianInput(socket.getInputStream());
							Object result = input.readObject();
							// System.out.println("....."+result.getClass().getName());
							
							System.out.println("总用时为："+(System.currentTimeMillis() - begin)+"ms");
							
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
