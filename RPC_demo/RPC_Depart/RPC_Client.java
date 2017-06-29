/**
 * 
 */
package RPC_Depart;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.net.Socket;


class RPCClient<T> {
    @SuppressWarnings("unchecked")
	public static <T> T getRemoteProxyObj(final Class<?> serviceInterface, final InetSocketAddress addr) {
        // 1.�����صĽӿڵ���ת����JDK�Ķ�̬�����ڶ�̬������ʵ�ֽӿڵ�Զ�̵���
        return (T) Proxy.newProxyInstance(serviceInterface.getClassLoader(), new Class<?>[]{serviceInterface},
                new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Socket socket = null;
                        ObjectOutputStream output = null;
                        ObjectInputStream input = null;
                        try {
                            // 2.����Socket�ͻ��ˣ�����ָ����ַ����Զ�̷����ṩ��
                            socket = new Socket();
                            socket.connect(addr);

                            // 3.��Զ�̷����������Ľӿ��ࡢ�������������б�ȱ�����͸������ṩ��
                            output = new ObjectOutputStream(socket.getOutputStream());
                            output.writeUTF(serviceInterface.getName());
                            output.writeUTF(method.getName());
                            output.writeObject(method.getParameterTypes());
                            output.writeObject(args);

                            // 4.ͬ�������ȴ�����������Ӧ�𣬻�ȡӦ��󷵻�
                            input = new ObjectInputStream(socket.getInputStream());
                            Object result = input.readObject();
                            //System.out.println("....."+result.getClass().getName());
                            return result;
                        } finally {
                            if (socket != null) socket.close();
                            if (output != null) output.close();
                            if (input != null) input.close();
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
		 
	        HelloService service = RPCClient.getRemoteProxyObj(HelloService.class, new InetSocketAddress("localhost", 8088));
	        System.out.println(service.sayHi("tlm"));
	}

}
