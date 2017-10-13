package com.lm.webserver;

import java.net.Socket;
import java.net.ServerSocket;
import java.net.InetAddress;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.io.File;

public class HttpServer {

	/**
	 * WEB_ROOT��HTML�������ļ���ŵ�Ŀ¼. �����WEB_ROOTΪ����Ŀ¼�µ�webrootĿ¼
	 */
	public static final String WEB_ROOT = System.getProperty("user.dir") + File.separator + "webroot";
//	static {
//		System.out.println(WEB_ROOT);
//	}

	// �رշ�������
	private static final String SHUTDOWN_COMMAND = "/SHUTDOWN";

	public static void main(String[] args) {
		HttpServer server = new HttpServer();
		// �ȴ���������
		server.await();
	}

	public void await() {
		ServerSocket serverSocket = null;
		int port = 8080;
		try {
			// �������׽��ֶ���
			serverSocket = new ServerSocket(port, 1, InetAddress.getByName("127.0.0.1"));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}

		// ѭ���ȴ�һ������
		while (true) {
			Socket socket = null;
			InputStream input = null;
			OutputStream output = null;
			try {
				// �ȴ����ӣ����ӳɹ��󣬷���һ��Socket����
				socket = serverSocket.accept();
				input = socket.getInputStream();
				output = socket.getOutputStream();

				// ����Request���󲢽���
				Request request = new Request(input);
				request.parse();
				// ����Ƿ��ǹرշ�������
				if (request.getUri() != null) {
					if (request.getUri().equals(SHUTDOWN_COMMAND)) {
						break;
					}
				}
//				System.out.println(request.getUri());
				// ���� Response ����
				Response response = new Response(output);
				response.setRequest(request);
				response.sendStaticResource();

				// �ر� socket ����
				socket.close();

			} catch (Exception e) {
				e.printStackTrace();
				continue;
			}
		}
	}
}
