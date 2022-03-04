package org.howard.edu.lsp.assignment5.implementation;

import java.util.ArrayList;

public class IntegerSet {
	// Hint: probably best to use an array list. You will need to do a little
	// research
	private ArrayList<Integer> set = new ArrayList<Integer>();

	// Default Constructor
	public IntegerSet() {

	}

	/**
	 * Clear function empties the internal representation of the set
	 */
	public void clear() {
		set.clear();
	};

	/**
	 * Returns the length of the set
	 * 
	 * @return integer representation of the length of the set
	 */
	public int length() {
		return set.size();
	};

	/**
	 * Equals function checks if an integerSet and this integerSet contain all the
	 * same values in any order
	 * 
	 * @param b a integerSet to be check against this one
	 * @return boolean value true if the sets contain the same values and false if
	 *         not
	 */
	public boolean equals(IntegerSet b) {
		for (int i = 0; i < set.size(); i++) {
			if (b.set.indexOf(set.get(i)) == -1) {
				return false;

			}
		}
		return true;

	};

	/**
	 * Returns true if the set contains the value, otherwise false
	 * 
	 * @param value is the integer the set will be checked for
	 * @return boolean value true if the set contains desired value, and false
	 *         otherwise
	 */
	public boolean contains(int value) {

		for (int i = 0; i < set.size() - 1; i++) {
			if (value == set.get(i)) {
				return true;
			}
		}
		return false;
	};

	/**
	 * Returns the largest item in the set; Throws a IntegerSetException if the set
	 * is empty
	 * 
	 * @return largest integer in the set
	 * @throws IntegerSetException if the set is empty
	 */

	public int largest() throws IntegerSetException {
		int max = set.get(0);
		if (set.isEmpty()) {
			throw new IntegerSetException("Integer set is empty");
		} else {
			for (int i = 0; i < set.size(); i++) {
				if (set.get(i) > max) {
					max = set.get(i);
				}
			}

		}
		return max;

	};

// 
	/**
	 * Returns the smallest item in the set; Throws a IntegerSetException if the set
	 * is empty
	 * 
	 * @return smallest integer in the set
	 * @throws IntegerSetException if the set is empty
	 */
	public int smallest() throws IntegerSetException {
		int min = set.get(0);

		if (set.isEmpty()) {
			throw new IntegerSetException("Integer set is empty");

		} else {
			for (int i = 0; i < set.size(); i++) {
				if (set.get(i) < min) {
					min = set.get(i);
				}
			}
		}
		return min;
	};

	/**
	 * Adds an item to the set or does nothing it already there
	 * 
	 * @param item is the integer item to be added to the set
	 */
	public void add(int item) {

		int tester = set.indexOf(item);

		if (tester == -1) {
			set.add(item);

		}

	}

	/**
	 * Removes an item from the set or does nothing if not there
	 * 
	 * @param item integer value of the item to be removed
	 * @throws IntegerSetException if the IntegerSet is empty
	 */

	public void remove(int item) throws IntegerSetException {

		if (set.size() == 0) {
			throw new IntegerSetException("Integer set is empty");
		} else {
			int tester = set.indexOf(item);

			if (tester != -1) {
				set.remove(tester);
			}
		}

	}

	/**
	 * union function takes integerSet input and adds all its elements to this
	 * IntegerSet
	 * 
	 * @param intSetb IntegerSet to be added to this IntegerSet
	 */
	public void union(IntegerSet intSetb) {
		for (int i = 0; i < intSetb.length(); i++) {
			set.addAll(intSetb.set);
		}
		for (int o = 0; o < set.size() - 1; o++) {
			for (int p = o + 1; p < set.size(); p++) {
				if (set.get(o) == set.get(p)) {
					set.remove(p);
				}
			}
		}
	}

	/**
	 * intersect function compares all values in this IntegerSet with the values in
	 * intSetb, then changes this set to only include the values that appear in both
	 * 
	 * @param intSetb IntegerSet used to be compared against
	 */
	public void intersect(IntegerSet intSetb) {
		ArrayList<Integer> intersectSet = new ArrayList<Integer>();
		for (int i = 0; i < set.size(); i++) {
			if (intSetb.contains(set.get(i))) {
				intersectSet.add(set.get(i));
			}
		}
		this.set = intersectSet;

	}

	/**
	 * diff function compares all values in this IntegerSet with the values in
	 * intSetb, then changes this IntegerSet to only include the values that appear
	 * in only one IntegerSet
	 * 
	 * @param intSetb
	 */
	public void diff(IntegerSet intSetb) {
		ArrayList<Integer> differenceSet = new ArrayList<Integer>();
		for (int i = 0; i < set.size(); i++) {
			if (intSetb.set.indexOf(set.get(i)) == -1) {
				differenceSet.add(set.get(i));
			}
		}
		for (int i = 0; i < intSetb.length(); i++) {
			if (set.indexOf(intSetb.set.get(i)) == -1) {
				differenceSet.add(intSetb.set.get(i));
			}
		}
		this.set = differenceSet;

	}

	/**
	 * isEmpty function checks if the IntegerSet is empty
	 * 
	 * @return boolean value true if the set is empty, false otherwise
	 */
	public boolean isEmpty() {
		if (set.size() == 0) {
			return true;
		} else {
			return false;
		}
	}


	public String toString() {
		String returnValue = "";
		for (int i = 0; i < set.size(); i++) {
			returnValue = returnValue + set.get(i).toString() + " ";

		}
		return "[ " + returnValue + "]";
	}; // return String representation of your set
}
