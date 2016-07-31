package com.king.cyclicbarriertest;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;


public class Worker implements Runnable {
	
	final CyclicBarrier barrier;
	final int name;

	public Worker(CyclicBarrier barrier,int name) {
		this.barrier = barrier;
		this.name = name;
	}

	@Override
	public void run() {
		try {
			System.out.println("Thread"+name+" start...");
			Thread.sleep(name*1000);
			System.out.println("Thread"+name+"wating:"+name*1000+"s");
			barrier.await();
			System.out.println("Thread"+name+"end...");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//	
//	public static void main(String[] args) {
//		System.out.println(new Random(System.currentTimeMillis()).nextInt(20));
//	}

}
