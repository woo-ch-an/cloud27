package com.ktdsuniversity.edu.constants;

public class CalculatorTest {
	public static void main(String[] args) {

		Calculator c = new Calculator(10, 5);
		System.out.println(c.compute(Calculator.ADD));
		System.out.println(c.compute(Calculator.SUB));
		System.out.println(c.compute(Calculator.MUL));
		System.out.println(c.compute(Calculator.DIV));
		
		System.out.println(c.compute(1));
		System.out.println(c.compute(2));
		System.out.println(c.compute(3));
		System.out.println(c.compute(4));
		
		System.out.println(c.compute(5));
		System.out.println(c.compute(-1));
		
		System.out.println(c.compute2(Operator.ADD));
		System.out.println(c.compute2(Operator.DIV));
		System.out.println(c.compute2(Operator.MUL));
		System.out.println(c.compute2(Operator.SUB));
	}
}
