/**
 * 
 */
package NIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author tlm
 *
 */
public class Server {
	
	private static ExecutorService executor = Executors.newFixedThreadPool(3);
	//private static ByteBuffer bb = ByteBuffer.allocateDirect(1024);
	
	private static class Task implements Runnable{
		
		private SocketChannel sc ;
		private ByteBuffer rec = ByteBuffer.allocateDirect(1024);
		private ByteBuffer sent = ByteBuffer.allocateDirect(1024);
		
		public Task(SocketChannel sc) {
			this.sc = sc;
		}
		
		@Override
		public void run() {
			try {
				System.out.println("连接建立");
				
				sc.read(rec);
				rec.flip();
				byte[] bytes = new byte[1024];
				rec.get(bytes,0,rec.remaining());
				String recs = new String(bytes);
				System.out.println(recs);
				System.out.println("读出成功");
				
				String sends = "我是服务器，你好。";
				sent.put(sends.getBytes());
				sent.rewind();
				sc.write(sent);
				System.out.println("写入成功");
				
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				
			}
			System.out.println("");
		}
		
	}
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		ServerSocketChannel ssc = ServerSocketChannel.open();
		ServerSocket serverSocket = ssc.socket();
		serverSocket.bind(new InetSocketAddress("localhost", 8089));
		while (true) {
			SocketChannel sc = ssc.accept();
			Runnable task = new Task(sc);
			executor.submit(task);
		}
	}

}
