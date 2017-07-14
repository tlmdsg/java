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
			System.out.println("��******�������ѿ������ȴ����Կͻ��˵�����");
			Socket socket = serverSocket.accept();
			System.out.println("�յ�����" + socket.getInetAddress().getHostAddress() + "����������");

			InputStream inputStream = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(inputStream, "gbk");
			BufferedReader in = new BufferedReader(isr);

			String info;
			while((info=in.readLine())!=null){//ѭ����ȡ�ͻ��˵���Ϣ
				System.out.println("���Ƿ��������ͻ���˵��"+info);
			}
			// �ر�������
			socket.shutdownInput();

			OutputStream outputStream = socket.getOutputStream();
			OutputStreamWriter osWriter = new OutputStreamWriter(outputStream, "gbk");
			PrintWriter out = new PrintWriter(osWriter); 
			out.write("��ӭ��½.");
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
