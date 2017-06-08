/**
 * 
 */
package RPC;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

interface HelloService {

    String sayHi(String name);

}

class HelloServiceImpl implements HelloService {

    public String sayHi(String name) {
        return "Hi, " + name;
    }

}

interface Server {
    public void stop();

    public void start() throws IOException;

    public void register(Class serviceInterface, Class impl);

    public boolean isRunning();

    public int getPort();
}

class ServiceCenter implements Server {
    private static ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    private static final HashMap<String, Class> serviceRegistry = new HashMap<String, Class>();

    private static boolean isRunning = false;

    private static int port;

    public ServiceCenter(int port) {
        this.port = port;
    }

    public void stop() {
        isRunning = false;
        executor.shutdown();
    }

    public void start() throws IOException {
        ServerSocket server = new ServerSocket();
        server.bind(new InetSocketAddress(port));
        System.out.println("start server");
        try {
            while (true) {
                // 1.�����ͻ��˵�TCP���ӣ��ӵ�TCP���Ӻ����װ��task�����̳߳�ִ��
                executor.execute(new ServiceTask(server.accept()));
            }
        } finally {
            server.close();
        }
    }

    public void register(Class serviceInterface, Class impl) {
    	System.out.println("regist service:"+serviceInterface.getName());
        serviceRegistry.put(serviceInterface.getName(), impl);
    }

    public boolean isRunning() {
        return isRunning;
    }

    public int getPort() {
        return port;
    }

    private static class ServiceTask implements Runnable {
        Socket clent = null;

        public ServiceTask(Socket client) {
            this.clent = client;
        }

        public void run() {
            ObjectInputStream input = null;
            ObjectOutputStream output = null;
            try {
                // 2.���ͻ��˷��͵����������л��ɶ��󣬷�����÷���ʵ���ߣ���ȡִ�н��
                input = new ObjectInputStream(clent.getInputStream());
                String serviceName = input.readUTF();
                String methodName = input.readUTF();
                Class<?>[] parameterTypes = (Class<?>[]) input.readObject();
                Object[] arguments = (Object[]) input.readObject();
                Class serviceClass = serviceRegistry.get(serviceName);
                if (serviceClass == null) {
                    throw new ClassNotFoundException(serviceName + " not found");
                }
                Method method = serviceClass.getMethod(methodName, parameterTypes);
                Object result = method.invoke(serviceClass.newInstance(), arguments);

                // 3.��ִ�н�������л���ͨ��socket���͸��ͻ���
                output = new ObjectOutputStream(clent.getOutputStream());
                output.writeObject(result);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (output != null) {
                    try {
                        output.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (input != null) {
                    try {
                        input.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (clent != null) {
                    try {
                        clent.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
    }
}

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
                            return input.readObject();
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
public class RPCTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 new Thread(new Runnable() {
	            public void run() {
	                try {
	                    Server serviceServer = new ServiceCenter(8088);
	                    serviceServer.register(HelloService.class, HelloServiceImpl.class);
	                    serviceServer.start();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	        }).start();
	        HelloService service = RPCClient.getRemoteProxyObj(HelloService.class, new InetSocketAddress("localhost", 8088));
	        System.out.println(service.sayHi("tlm"));
	}

}
