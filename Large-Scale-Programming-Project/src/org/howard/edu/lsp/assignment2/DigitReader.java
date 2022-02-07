package org.howard.edu.lsp.assignment2;

import java.util.Scanner;
import java.util.ArrayList;

public class DigitReader {
	
	/**
	   *
	   * Main method below works creates and uses the scanner and calls the 
	   * necessary other functions
	   * 
	*/

	public static void main(String[] args) {
		
		System.out.println("Enter your digit(s) seperated by SPACE(s)") ;
		
		Scanner reader = new Scanner(System.in);
		
		
		String badStringDigits = reader.nextLine();
		
		reader.close();
		int[] numsArray = makeIntegerArray(badStringDigits);
		
		printer(numsArray);
		
	}
	/**
	   *
	   * This function converts the scanned string of integers to an array of
	   * strings, then to an array of integers before sending it back to the 
	   * main.
	   *
	*/
	
	public static int[] makeIntegerArray(String numsString){
		
		
		
		String[] midNumString = numsString.split(" ");
		int[] nums = new int[midNumString.length];
		
		for(int i = 0; i< midNumString.length; i++) {
		
		nums[i] = Integer.parseInt(midNumString[i]);
		
		}
		
		return nums;
		
	}
	/**
	   *
	   * This method does the necessary math and formatting then prints out the
	   * expected message to the console
	   *
	*/
	
	public static void printer(int polishedIntArray[]) {
		
		int sum = 0;
		int product = 1;
		
		System.out.println("Tokens:");
		for(int i = 0; i< polishedIntArray.length; i++) {
			System.out.println(polishedIntArray[i]);
			sum += polishedIntArray[i];
			product *= polishedIntArray[i];
		}
		System.out.println("Sum:" + sum);
		System.out.println("Product:" + product);
	}
	

}
