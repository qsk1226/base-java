package com.goddess.base.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class server {// 服务端
	// 读取 In
	static Socket socket = null;
	static ServerSocket serverSocket = null;

	public server() {// 构造方法
		try {
			serverSocket = new ServerSocket(9999);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		System.out.println("************欢迎使用java聊天室*************");
		server t = new server();
		int count = 0;
		while (true) {
			try {
				socket = serverSocket.accept();
				count++;
				System.out.println("第" + count + "个客户已连接");
			} catch (IOException e) {
				e.printStackTrace();
			}
			Readl r = new Readl(socket);
			Print p = new Print(socket);
			Thread read = new Thread(r);
			Thread print = new Thread(p);
			read.start();
			print.start();
		}
	}
}

class Readl implements Runnable {//信息读取类
	static List<Socket> socketList = new ArrayList<>();
	Socket socket = null;

	public Readl(Socket s) {// 构造方法
		try {
			socketList.add(s);
			this.socket = s;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void run() { // 重写run方法

		try {
			Thread.sleep(1000);
			BufferedReader in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
			while (true) {
				String jieshou = in.readLine();
				System.out.println(jieshou);//在服务端输出信息
				for (int i = 0; i < socketList.size(); i++) {//把信息发送到各个客户端
					Socket socket = socketList.get(i);
					PrintWriter out = new PrintWriter(socket.getOutputStream());
					if (socket != this.socket) {
						out.println(jieshou);
					} else {
						out.println("(你)" + jieshou);
					}
					out.flush();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

class Print implements Runnable {//信息发送类
	static List<Socket> socketList = new ArrayList<Socket>();
	Scanner input = new Scanner(System.in);

	public Print(Socket s) {// 构造方法
		try {
			socketList.add(s);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		try {
			Thread.sleep(1000);
			while (true) {
				String msg = input.next();
				for (int i = 0; i < socketList.size(); i++) {
					Socket socket = socketList.get(i);
					PrintWriter out = new PrintWriter(socket.getOutputStream());
					out.println("服务端说：" + msg);
					out.flush();
				}
			}
		} catch (Exception e) { // TODO: handle exception e.printStackTrace(); } }
		}
	}
}