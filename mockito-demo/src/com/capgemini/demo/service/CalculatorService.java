package com.capgemini.demo.service;

import com.capgemini.demo.exception.FactorialOfNegativeNumberException;
import com.capgemini.demo.exception.SquareOfInvalidNumberException;

public interface CalculatorService {
 
	public int addition(int number1, int number2);
	public int substraction(int number1, int number2);
	public int multiplication(int number1, int number2);
	public int division(int number1, int number2);
	public int factorial(int number)throws FactorialOfNegativeNumberException, SquareOfInvalidNumberException;
	public int square(int number) throws  SquareOfInvalidNumberException, FactorialOfNegativeNumberException;
}
