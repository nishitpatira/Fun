package com.np.fun;

public class RunTimeVsCompileTime {

	public static void main(String[] args) {
		
		RunTimeVsCompileTime.Shape shape1 = new RunTimeVsCompileTime.Shape();
		RunTimeVsCompileTime.Rectangle rectangle1 = new RunTimeVsCompileTime.Rectangle();
		System.out.println("Shape's X from field variable is :" + shape1.x + " Method says it is :" + shape1.getX());
		System.out.println("Rectangle's X from field variable is :" + rectangle1.x + " Method says it is :" + rectangle1.getX());
		RunTimeVsCompileTime.Shape shape2 = new RunTimeVsCompileTime.Rectangle();
		System.out.println("Shape's X from field variable is :" + shape2.x + " Method says it is :" + shape2.getX());
	}

	static class Shape {
		int x = 1;

		protected int getX() {
			return this.x;
		}
	}

	static class Rectangle extends Shape {
		int x = 0;

		@Override
		protected int getX() {
			return this.x;
		}

	}

}
