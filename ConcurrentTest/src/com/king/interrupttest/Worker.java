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
		//cancal = true;//线程无法中断
	}

	@Override
	public void run() {
		try {
			while (!Thread.currentThread().isInterrupted()) {
			//while( !cancal ){//线程无法中断
				queue.put(BigInteger.ONE);
			}
		} catch (InterruptedException e) {
			System.out.println(e);
		}
	}
}
