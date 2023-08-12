package fi.beanbakers.tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * Some examples and asserts on some basic programming problems.
 * 
 * @author Peter
 */
public class BeanBakersTests {

	@Test
	public void testReverseList() {
		List<String> input = Arrays.asList("a", "b", "c", "d", "e", "f", "g");
		List<String> expectedResult = Arrays.asList("g", "f", "e", "d", "c", "b", "a");

		List<String> result = doReverseList(input);
		Assert.assertArrayEquals(expectedResult.toArray(new String[expectedResult.size()]),
				result.toArray(new String[result.size()]));
	}

	/**
	 * Write your method here that returns the provided input list reversed.
	 * 
	 * @param input list
	 * @return provided list reversed
	 */
	private <T> List<T> doReverseList(List<T> input) {
		// Specification is a bit vague; do we want to reverse the existing list
		// in-place or do we want to allocate a new list?
		// If we assume the former, with the given imports we could simply do:
		//Collections.reverse(input);
		//return input;

		// But since the above is just calling a standard library function,
		// let's create a new list manually.
		// We needed to add "import java.util.ArrayList" for this.
		List<T> output = new ArrayList<>(input.size());
		for(int i = input.size() - 1; i >= 0; i--) {
			output.add(input.get(i));
		}

		return output;
	}

	@Test
	public void testFibonacciSequence() {
		int sequenceLength = 8;
		int[] expectedResult = { 1, 1, 2, 3, 5, 8, 13, 21 };
		int[] result = doFibonacciSequence(sequenceLength);
		Assert.assertArrayEquals(expectedResult, result);
	}

	/**
	 * Write your method here that returns the fibonacci sequence up to the provided
	 * sequence length.
	 * 
	 * @param sequenceLength the amount of fibonacci sequence items to calculate
	 * @return int array containing the calculated fibonacci sequence
	 */
	private int[] doFibonacciSequence(int sequenceLength) {
		int[] sequence = new int[sequenceLength];

		// Make sure we don't index out-of-bounds in case someone wants
		// a very short Fibonacci sequence.
		if (sequenceLength >= 1) {
			sequence[0] = 1;
		}
		if (sequenceLength >= 2) {
			sequence[1] = 1;
		}

		for (int i = 2; i < sequenceLength; i++) {
			sequence[i] = sequence[i-1] + sequence[i-2];
		}

		return sequence;
	}

	@Test
	public void testAscendingAndDescendingSeries() {
		List<Integer> testSeriesA = Arrays.asList(1, 2, 5, 8, 15, 27, 31, 50);
		List<Integer> testSeriesB = Arrays.asList(1, 2, 1, 8, 7, 27, 31, 50);

		Assert.assertTrue(isAscendingSeries(testSeriesA));
		Assert.assertFalse(isAscendingSeries(testSeriesB));
		Assert.assertTrue(isDescendingSeries(doReverseList(testSeriesA)));
		Assert.assertFalse(isDescendingSeries(doReverseList(testSeriesB)));
	}

	/**
	 * Write your method here that returns true if the provided list of integers is
	 * ascending, false otherwise.
	 * 
	 * @param series
	 * @return true if provided series ascends, false otherwise.
	 */
	private boolean isAscendingSeries(List<Integer> series) {
		for (int i = 1; i < series.size(); i++) {
			if (series.get(i-1) > series.get(i)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Write your method here that returns true if the provided list of integers is
	 * descending, false otherwise.
	 * 
	 * @param series
	 * @return true if the provided series descends, false otherwise.
	 */
	private boolean isDescendingSeries(List<Integer> series) {
		for (int i = 1; i < series.size(); i++) {
			if (series.get(i-1) < series.get(i)) {
				return false;
			}
		}
		return true;
	}
}
