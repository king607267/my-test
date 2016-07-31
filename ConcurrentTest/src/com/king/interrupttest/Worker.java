package com.king.interrupttest;

import java.math.BigInteger;
import java.util.concurrent.BlockingQueue;

public class Worker extends Thread {
	private final BlockingQueue<BigInteger> queue;
	private volatile boolean cancal = false;
		
	public Worker(BlockingQueue<BigInteger> queue) {
		this.queue = queue;
	}

	public void cancal(){
		interrupt();
		//cancal = true;//�߳��޷��ж�
	}

	@Override
	public void run() {
		try {
			while (!Thread.currentThread().isInterrupted()) {
			//while( !cancal ){//�߳��޷��ж�
				queue.put(BigInteger.ONE);
			}
		} catch (InterruptedException e) {
			System.out.println(e);
		}
	}
}
