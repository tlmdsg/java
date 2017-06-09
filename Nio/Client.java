/**
 * 
 */
package NIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @author tlm
 *
 */
public class Client {
	
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		SocketChannel sc = SocketChannel.open(new InetSocketAddress("localhost", 8089));
		System.out.println("���ӽ���");
		
		ByteBuffer sent = ByteBuffer.allocateDirect(1024);
		ByteBuffer rec = ByteBuffer.allocateDirect(1024);
		
		sc.write((ByteBuffer)sent.put("������������".getBytes()).flip());
		System.out.println("д��ɹ�");
		
		sc.read(rec);
		rec.flip();
		byte[] bytes = new byte[1024] ;
		rec.get(bytes, 0, rec.remaining());
		System.out.println(new String(bytes));
		
		sc.close();
	}

}
