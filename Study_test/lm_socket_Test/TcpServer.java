package lm_socket_Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {

	public static void main(String[] args) {
		try {
			ServerSocket serverSocket = new ServerSocket(8889);
			System.out.println("！******服务器已开启，等待来自客户端的连接");
			Socket socket = serverSocket.accept();
			System.out.println("收到来自" + socket.getInetAddress().getHostAddress() + "的连接请求");

			InputStream inputStream = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(inputStream, "gbk");
			BufferedReader in = new BufferedReader(isr);

			String info;
			while((info=in.readLine())!=null){//循环读取客户端的信息
				System.out.println("我是服务器，客户端说："+info);
			}
			// 关闭输入流
			socket.shutdownInput();

			OutputStream outputStream = socket.getOutputStream();
			OutputStreamWriter osWriter = new OutputStreamWriter(outputStream, "gbk");
			PrintWriter out = new PrintWriter(osWriter); 
			out.write("欢迎登陆.");
			out.flush();
			
			
			out.close();
			osWriter.close();
			outputStream.close();

			in.close();
			isr.close();
			inputStream.close();
			socket.close();
			serverSocket.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
