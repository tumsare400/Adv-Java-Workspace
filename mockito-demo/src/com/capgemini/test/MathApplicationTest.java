package com.capgemini.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.capgemini.demo.MathApplication;
import com.capgemini.demo.exception.FactorialOfNegativeNumberException;
import com.capgemini.demo.exception.SquareOfInvalidNumberException;
import com.capgemini.demo.service.CalculatorService;

public class MathApplicationTest {

	@Mock
	private CalculatorService service;

	@InjectMocks
	MathApplication application = new MathApplication(service);

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void TestPerformAdditionwithPositiveIntegers() {
		when(service.addition(6, 4)).thenReturn(10);
		assertEquals(10, application.performAddition(6, 4));
	}

	@Test
	public void TestPerformAdditionwithNegativeIntegers() {
		when(service.addition(-6, -4)).thenReturn(-10);
		assertEquals(-10, application.performAddition(-6, -4));
	}

	@Test
	public void TestPerformAdditionwithOnePositiveOneNegativeIntegers() {
		when(service.addition(6, -4)).thenReturn(2);
		assertEquals(2, application.performAddition(6, -4));
	}

	@Test
	public void TestPerformAdditionwithOneZeroOnenonZeroIntegers() {
		when(service.addition(6, 0)).thenReturn(6);
		assertEquals(6, application.performAddition(6, 0));
	}

	@Test
	public void testPerformSubstractionwithPositiveIntegers() {
		when(service.substraction(10, 5)).thenReturn(5);
		assertEquals(5, application.performSubstraction(10, 5));
	}

	@Test
	public void TestPerformSubstractionwithNegativeIntegers() {
		when(service.substraction(-6, -4)).thenReturn(-2);
		assertEquals(-2, application.performSubstraction(-6, -4));
	}

	@Test
	public void TestPerformSubstractionwithOnePositiveOneNegativeIntegers() {
		when(service.substraction(6, -4)).thenReturn(10);
		assertEquals(10, application.performSubstraction(6, -4));
	}

	@Test
	public void TestPerformSubstractionwithOneZeroOnenonZeroIntegers() {
		when(service.substraction(6, 0)).thenReturn(6);
		assertEquals(6, application.performSubstraction(6, 0));
	}

	@Test
	public void testPerformMultiplicationwithPositiveIntegers() {
		when(service.multiplication(10, 10)).thenReturn(100);
		assertEquals(100, application.performMultiplication(10, 10));
	}

	@Test
	public void TestPerformMultiplicationnwithNegativeIntegers() {
		when(service.multiplication(-6, -4)).thenReturn(24);
		assertEquals(24, application.performMultiplication(-6, -4));
	}

	@Test
	public void TestPerformMultiplicationwithOnePositiveOneNegativeIntegers() {
		when(service.multiplication(6, -4)).thenReturn(-24);
		assertEquals(-24, application.performMultiplication(6, -4));
	}

	@Test
	public void TestPerformMultiplicationwithOneZeroOnenonZeroIntegers() {
		when(service.multiplication(6, 0)).thenReturn(0);
		assertEquals(0, application.performMultiplication(6, 0));
	}

	@Test
	public void testPerformDivisionwithPositiveIntegers() {
		when(service.division(10, 10)).thenReturn(1);
		assertEquals(1, application.performDivision(10, 10));
	}

	@Test
	public void TestPerformDivisionnnwithNegativeIntegers() {
		when(service.division(-10, -5)).thenReturn(2);
		assertEquals(2, application.performDivision(-10, -5));
	}

	@Test
	public void TestPerformDivisionwithOnePositiveOneNegativeIntegers() {
		when(service.division(10, -5)).thenReturn(-2);
		assertEquals(-2, application.performDivision(10, -5));
	}

	@Test(expected = ArithmeticException.class)
	public void testPerformDivisionWithDivisorZero() {
		doThrow(new ArithmeticException("/ by zero")).when(service).division(10, 0);
		application.performDivision(10, 0);
	}

	@Test
	public void TestFindSquareWithPositiveInteger() throws SquareOfInvalidNumberException, FactorialOfNegativeNumberException {
		when(service.square(5)).thenReturn(25);
		assertEquals(25, application.findSquare(5));
	}

	@Test
	public void TestFindSquareWithNegativeInteger() throws SquareOfInvalidNumberException, FactorialOfNegativeNumberException {
		when(service.square(-5)).thenReturn(25);
		assertEquals(25, application.findSquare(-5));
	}

	@Test
	public void TestFindSquareWithZeroInteger() throws SquareOfInvalidNumberException, FactorialOfNegativeNumberException {
		when(service.square(0)).thenReturn(0);
		assertEquals(0, application.findSquare(0));
	}

	@Test
	public void TestFindFactorialWithPositiveInteger() throws FactorialOfNegativeNumberException, SquareOfInvalidNumberException {
		when(service.factorial(5)).thenReturn(120);
		assertEquals(120, application.findFactorial(5));
	}
	
	@Test
	public void TestFindFactorialWithNegativeInteger() throws FactorialOfNegativeNumberException, SquareOfInvalidNumberException {
		when(service.factorial(-5)).thenReturn(-120);
		assertEquals(-120, application.findFactorial(-5));
	}
	
	@Test
	public void TestFindFactorialWithZeroInteger() throws FactorialOfNegativeNumberException, SquareOfInvalidNumberException {
		when(service.factorial(0)).thenReturn(1);
		assertEquals(1, application.findFactorial(0));
	}
}
