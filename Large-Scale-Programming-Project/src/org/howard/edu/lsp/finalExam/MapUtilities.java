package org.howard.edu.lsp.finalExam;

import java.util.HashMap;

/**
 * Class MapUtilities for methods to analyze and handle HashMaps
 * 
 * @author tanneruzzell
 *
 */
public class MapUtilities {

	/**
	 * Method commonKeyValuePair returns the number of common key value pairs shared
	 * between two HashMaps
	 * 
	 * @param map1 String by String HashMap
	 * @param map2 String by String HashMap
	 * @return integer representing the number of common key value pairs. Will
	 *         always return 0 of one or more HashMaps are empty
	 * @throws NullMapException if on or more HashMaps are null
	 */
	public static int commonKeyValuePairs(HashMap<String, String> map1, HashMap<String, String> map2)
			throws NullMapException {
		int commonValuesCounter = 0;

		if (map1 == null || map2 == null) {
			throw new NullMapException("One or both maps are null!");
		} else if (map1.size() == 0 || map2.size() == 0) {
			return 0;
		} else {
			for (String map1key : map1.keySet()) {

				for (String map2key : map2.keySet()) {

					if (map1key.equals(map2key)) {

						if (map1.get(map1key).equals(map2.get(map2key))) {

							commonValuesCounter++;
						}
					}
				}
			}
		}

		return commonValuesCounter;
	}
}
