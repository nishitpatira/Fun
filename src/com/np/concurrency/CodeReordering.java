package com.np.concurrency;

public class CodeReordering {

	int A = 0; int B = 0; int r1 = 0; int r2 = 0;

	public static void main(String[] args) {
		final CodeReordering reorderObj = new CodeReordering();
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				reorderObj.r2 = reorderObj.A;
				reorderObj.B = 1;
			}
		});
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				reorderObj.r1 = reorderObj.B;
				reorderObj.A = 2;
			}
		});

		t1.start();
		t2.start();
		System.out.println(
				"r1 : " + reorderObj.r1 + " r2 : " + reorderObj.r2 + " A : " + reorderObj.A + " B : " + reorderObj.B);
	}
}
