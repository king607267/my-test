package com.king.interrupttest;

import java.math.BigInteger;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Test {
	
	public static void main(String[] args) {
		BlockingQueue<BigInteger> queue = new  LinkedBlockingQueue<BigInteger>(2);
		Worker worker = new Worker(queue);
		worker.start();
		try {
			System.out.println("sleep start....");
			Thread.sleep(2000);
			System.out.println("sleep end....");
			System.out.println("queue size:"+queue.size());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		worker.cancal();
		
	}
}
