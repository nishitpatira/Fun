package com.np.fun;

import java.util.concurrent.Semaphore;

public class DeadLockWithItself {

	private static int count = 0;
	Semaphore sema = new Semaphore(1);
	
	public static void main(String[] args) throws InterruptedException{
		DeadLockWithItself deadLock = new DeadLockWithItself();
		
		deadLock.createDeadlock();
	}
	
	private void createDeadlock() throws InterruptedException {
		sema.acquire();
		System.out.println("Incrementing the count from " + count  + " to  : " + (count+1) );
		count++;
		createDeadlock();
	}
}
