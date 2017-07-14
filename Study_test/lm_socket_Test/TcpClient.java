package lm_socket_Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpClient {

	public static void main(String[] args) {
		try {
			Socket socket = new Socket("localhost",8889);
			OutputStream outputStream = socket.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(outputStream, "gbk");
			PrintWriter out = new PrintWriter(osw);

			out.println("�û���:������;����:dsg");
			out.flush();
			// �ر������
			socket.shutdownOutput();

			InputStream inputStream = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(inputStream, "gbk");
			BufferedReader in = new BufferedReader(isr);

			String info;
			while ((info = in.readLine()) != null) {
				System.out.println("���ǿͻ��ˣ�������˵��" + info);
			}
			socket.shutdownInput();

			in.close();
			isr.close();
			inputStream.close();

			out.close();
			osw.close();
			outputStream.close();
			socket.close();

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
