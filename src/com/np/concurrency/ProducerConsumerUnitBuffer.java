package com.np.concurrency;

import java.util.Stack;

public class ProducerConsumerUnitBuffer {
	
	Stack<Integer> buffer = new Stack<>();
	int i = 1;

	class Consumer implements Runnable {
		@Override
		public void run() {
			while(true){
				synchronized (buffer) {
					while(buffer.isEmpty()){
						try{
							buffer.wait();
						} catch(InterruptedException ie){
							ie.printStackTrace();
						}
					}
					buffer.pop();
					buffer.notifyAll();
				}
			}
		}
	}

	class Producer implements Runnable {
		@Override
		public void run() {
			while(true){
				synchronized (buffer) {
					while(!buffer.isEmpty()){
						try {
							buffer.wait();
						} catch (InterruptedException ie) {
							ie.printStackTrace();
						}
					}
					buffer.push(i);
					buffer.notifyAll();
				}
			}
		}
	}
}

	/*public static void main(String[] args) {

		ProducerConsumerUnitBuffer obj = new ProducerConsumerUnitBuffer();
		Thread producerThread1 = new Thread(obj.new Consumer());
		Thread consumerThread1 = new Thread(obj.new Producer());
		Thread producerThread2 = new Thread(obj.new Consumer());
		Thread consumerThread2 = new Thread(obj.new Producer());
		Thread producerThread3 = new Thread(obj.new Consumer());
		Thread consumerThread3 = new Thread(obj.new Producer());
		Thread producerThread4 = new Thread(obj.new Consumer());
		Thread consumerThread4 = new Thread(obj.new Producer());
		Thread producerThread5 = new Thread(obj.new Consumer());
		Thread consumerThread5 = new Thread(obj.new Producer());
		Thread producerThread6 = new Thread(obj.new Consumer());
		Thread consumerThread6 = new Thread(obj.new Producer());
		Thread producerThread7 = new Thread(obj.new Consumer());
		Thread consumerThread7 = new Thread(obj.new Producer());
		Thread producerThread8 = new Thread(obj.new Consumer());
		Thread consumerThread8 = new Thread(obj.new Producer());
		Thread producerThread9 = new Thread(obj.new Consumer());
		Thread consumerThread9 = new Thread(obj.new Producer());
		Thread producerThread10 = new Thread(obj.new Consumer());
		Thread consumerThread10 = new Thread(obj.new Producer());

		producerThread1.start();
		consumerThread1.start();
		producerThread2.start();
		consumerThread2.start();
		producerThread3.start();
		consumerThread3.start();
		producerThread4.start();
		consumerThread4.start();
		producerThread5.start();
		consumerThread5.start();
		producerThread6.start();
		consumerThread6.start();
		producerThread7.start();
		consumerThread7.start();
		producerThread8.start();
		consumerThread8.start();
		producerThread9.start();
		consumerThread9.start();
		producerThread10.start();
		consumerThread10.start();

	}

}*/