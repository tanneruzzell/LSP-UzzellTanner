/**
 * 
 */
package org.howard.edu.lsp.finalExam;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Class for testing MapUtilities.java
 * 
 * @author tanneruzzell
 *
 */
class MapUtilitiesTest {

	@Test
	@DisplayName("Testing MapUtilities.commonKeyValuePairs() when there are common key value pairs")
	void testCommonKeyValuePairs_withTwoCommonKeyValuePairs() {
		HashMap<String,String> hashMap1 = new HashMap<String, String>();
		hashMap1.put("Alice", "Healthy");
		hashMap1.put("Mary", "Ecstatic");
		hashMap1.put("Bob", "Happy");
		hashMap1.put("Chuck", "Fine");
		hashMap1.put("Felix", "Sick");

		HashMap<String,String> hashMap2 = new HashMap<String, String>();
		
		hashMap2.put("Mary", "Ecstatic");
		hashMap2.put("Felix", "Healthy");
		hashMap2.put("Ricardo", "Superb");
		hashMap2.put("Tam", "Fine");
		hashMap2.put("Bob", "Happy");

		int commonPairs = -1;
		try {
			commonPairs = MapUtilities.commonKeyValuePairs(hashMap1, hashMap2);
		} catch (NullMapException e) {
			e.printStackTrace();
		}
		
			assertEquals(commonPairs, 2);
		
	}
	@Test
	@DisplayName("Testing MapUtilities.commonKeyValuePairs() when one or more HashMap parameter is empty")
	void testCommonKeyValuePairs_WhenHashmapIsEmpty() {
		HashMap<String,String> hashMap1 = new HashMap<String, String>();
		hashMap1.put("Alice", "Healthy");
		hashMap1.put("Mary", "Ecstatic");
		hashMap1.put("Bob", "Happy");
		hashMap1.put("Chuck", "Fine");
		hashMap1.put("Felix", "Sick");

		HashMap<String,String> hashMap2 = new HashMap<String, String>();
		
		int commonPairs = -1;
		
		try {
			commonPairs = MapUtilities.commonKeyValuePairs(hashMap1, hashMap2);
		}catch(NullMapException e) {
			e.printStackTrace();
		}
		assertEquals(commonPairs, 0);
		
		
	}
	@Test
	@DisplayName("Testing MapUtilities.commonKeyValuePairs() throws NullMapException when one or more HashMap parameter is null")
	void testCommonKeyValuePairs_throwsNullMapException() {
		HashMap<String,String> hashMap1 = null;
		
		HashMap<String,String> hashMap2 = new HashMap<String, String>();
		
		hashMap2.put("Mary", "Ecstatic");
		hashMap2.put("Felix", "Healthy");
		hashMap2.put("Ricardo", "Superb");
		hashMap2.put("Tam", "Fine");
		hashMap2.put("Bob", "Happy");
		
		Exception exception = assertThrows(Exception.class, () -> {
			int testa = MapUtilities.commonKeyValuePairs(hashMap1, hashMap2);
		});
		
		String expectedMessage = "One or both maps are null!";
		String actualMessage = exception.getMessage();
		
		assertTrue(actualMessage.contains(expectedMessage));
		
	}
	

}
