package com.js.thread;

public class ExThread {
	static long startTime=0;

	public static void main(String[] args) {
		ThreadEx1 th1 = new ThreadEx1();
		ThreadEx2 th2 = new ThreadEx2();
		th1.start();
		th2.start();
		startTime = System.currentTimeMillis();
		
		try {
			th1.join(); // th1의 작업 종료까지 main쓰레드가 기다리게 된다.
			th2.join(); // ht2의 작업 종료까지 main쓰레드가 기다리게 된다.
		}catch(Exception e) {
			
		}
		
		System.out.println("소요시간 : " + (System.currentTimeMillis()-startTime));
		// 멀티 쓰레드 방식으로 실행
	}
}

class ThreadEx1 extends Thread { // Thread 클래스를 상속 받아 구현하는 방식
	public void run() {
		for (int i=0; i<100; i++) { 
			System.out.print(new String("-"));
		}
	}
}

class ThreadEx2 extends Thread { // Thread 클래스를 상속 받아 구현하는 방식
	public void run() {
		for (int i=0; i<100; i++) { 
			System.out.print(new String("|"));
		}
	}
}