package com.king.cyclicbarriertest;

import java.util.concurrent.CyclicBarrier;

public class Test {
	public static void main(String[] args) {
		int cores = Runtime.getRuntime().availableProcessors();
		System.out.println("cpu Cores:"+cores);
		CyclicBarrier  barrier = new CyclicBarrier(cores, new Runnable(){

			@Override
			public void run() {
				System.out.println("end...");
			}
			
		});
		for (int i = 0; i < cores; i++) {
			new Thread(new Worker(barrier,i)).start();
		}
//		barrier.reset();
	}
}
