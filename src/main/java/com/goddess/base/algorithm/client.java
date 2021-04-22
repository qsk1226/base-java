package com.goddess.base.algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class client implements Runnable {// 客户端
	static Socket socket = null;
	static String name = null;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("请输入你的用户名：（班级姓名学号）");
		String x = in.next();
		client.name = x;
		System.out.println("************客户端" + x + "*************");
		try {
			socket = new Socket("127.0.0.1", 9999);
			System.out.println("已经连上服务器了");
		} catch (Exception e) {
			e.printStackTrace();
		}
		client t = new client();
		Read r = new Read(socket);
		Thread print = new Thread(t);
		Thread read = new Thread(r);
		print.start();
		read.start();
	}

	@Override
	public void run() {
		//信息发送
		Scanner input = new Scanner(System.in);
		try {
			Thread.sleep(1000);
			PrintWriter out = new PrintWriter(socket.getOutputStream());
			while (true) {
				String msg = input.next();
				out.println(name + "说:" + msg);
				out.flush();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class Read implements Runnable {//信息读取
	static Socket socket = null;

	public Read(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(100);
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			while (true) {
				System.out.println(in.readLine());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}