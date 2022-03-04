package org.howard.edu.lsp.assignment5.test;

import org.howard.edu.lsp.assignment5.implementation.IntegerSet;
import org.howard.edu.lsp.assignment5.implementation.IntegerSetException;

/**
 * Driver class used to create IntegerSet objects and test it's functions
 * 
 * @author tanneruzzell
 *
 */
public class Driver {
	/**
	 * Main method used to test all IntegerSet functions This includes: IntegerSet
	 * constructor, add(), toString(), clear(), isEmpty(), equals(), contains(),
	 * remove(), smallest(), largest(), union(), intersection(), diff(),
	 * 
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		IntegerSet set1 = new IntegerSet();
		set1.add(1);
		set1.add(2);
		set1.add(3);
		System.out.println("Value of Set1 is: " + set1.toString());

		// Checking if clear empties the set and is empty function
		set1.clear();
		System.out.println("Value of Set1 is: " + set1.toString());
		System.out.println("Is set 1 empty? " + set1.isEmpty());

		// Print the length of set
		System.out.println("Length of set1 is: " + set1.length());

		// Test equals function with equal sets
		set1.add(1);
		set1.add(2);
		set1.add(3);

		IntegerSet set2 = new IntegerSet();
		set2.add(3);
		set2.add(2);
		set2.add(1);

		System.out.println("Value of Set1 is: " + set1.toString());
		System.out.println("Value of Set2 is: " + set2.toString());
		System.out.println("Are the two sets equal? " + set1.equals(set2));

		// Test equals function with unequal sets
		set1.add(4);
		System.out.println("Value of Set1 is: " + set1.toString());
		System.out.println("Value of Set2 is: " + set2.toString());
		System.out.println("Are the two sets equal? " + set1.equals(set2));

		// Test if a set contains a certain value
		System.out.println("Value of Set1 is: " + set1.toString());
		System.out.println("Does set1 contain '2'? " + set1.contains(2));
		System.out.println("Does set1 contain '10'? " + set1.contains(10));

		// Test remove function
		System.out.println("Value of Set1 is: " + set1.toString());
		System.out.println("Removing '4' from set 1");
		try {
			set1.remove(4);
		} catch (IntegerSetException e) {
			System.out.println("Set is empty");
		}
		System.out.println("Value of Set1 is: " + set1.toString());

		// Smallest

		try {
			System.out.println("Smallest value in Set1 is: " + set1.smallest());
		} catch (IntegerSetException e) {
			System.out.println("Set is empty");
		}

		// Largest
		try {
			System.out.println("Largest value in Set1 is: " + set1.largest());
		} catch (IntegerSetException e) {
			System.out.println("Set is empty");
		}

		set2.add(4);
		set2.add(5);

		// Testing union
		System.out.println("Union of Set1 and Set2");

		System.out.println("Value of Set1 is:" + set1.toString());
		System.out.println("Value of Set2 is:" + set2.toString());
		set1.union(set2); // union of set1 and set2
		System.out.println("Result of union of Set1 and Set2: ");
		System.out.println(set1.toString()); // result of union of set1 and set2

		// Testing intersection
		System.out.println("Intersection of Set1 and Set2");
		set1.clear();
		set2.clear();

		set1.add(1);
		set1.add(2);
		set1.add(4);
		set1.add(6);
		set1.add(7);

		set2.add(1);
		set2.add(2);
		set2.add(3);
		set2.add(4);
		set2.add(5);
		System.out.println("Value of Set1 is:" + set1.toString());
		System.out.println("Value of Set2 is:" + set2.toString());
		set1.intersect(set2);
		System.out.println("Result of Intersect of Set1 and Set2: " + set1.toString());

		// Testing Difference
		System.out.println("Difference of Set1 and Set2");
		set1.clear();
		set2.clear();

		set1.add(1);
		set1.add(2);
		set1.add(4);
		set1.add(6);
		set1.add(7);

		set2.add(1);
		set2.add(2);
		set2.add(3);
		set2.add(4);
		set2.add(5);
		System.out.println("Value of Set1 is:" + set1.toString());
		System.out.println("Value of Set2 is:" + set2.toString());
		set1.diff(set2);
		System.out.println("Result of Difference of Set1 and Set2: " + set1.toString());

	}

}
