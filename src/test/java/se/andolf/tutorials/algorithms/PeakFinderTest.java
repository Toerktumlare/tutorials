package se.andolf.tutorials.algorithms;

import org.junit.jupiter.api.Test;
import se.andolf.tutorials.algorithms.PeakFinder;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PeakFinderTest {

    @Test
    void shouldTestStraightForwardSolutionWithSingleNumberArray() {
        int[] numbers = {2};
        var peak = PeakFinder.straightForward(numbers);
        assertEquals(2, peak);
    }

    @Test
    void shouldTestStraightForwardSolutionWithTwoNumberArrayWhereSecondNumberIsGreaterThanFirst() {
        int[] numbers = {2,3};
        var peak = PeakFinder.straightForward(numbers);
        assertEquals(3, peak);
    }

    @Test
    void shouldTestStraightForwardSolutionWithTwoNumberArrayWhereFirstNumberIsGreaterThanFirst() {
        int[] numbers = {3,2};
        var peak = PeakFinder.straightForward(numbers);
        assertEquals(3, peak);
    }

    @Test
    void shouldTestStraightForwardSolutionWithThreeNumberArrayWhereSecondNumberIsGreaterThanFirst() {
        int[] numbers = {1,3,2};
        var peak = PeakFinder.straightForward(numbers);
        assertEquals(3, peak);
    }

    @Test
    void shouldTestStraightForwardSolutionWithThreeNumberArrayWhereLastNumberIsAPeak() {
        int[] numbers = {1,2,3};
        var peak = PeakFinder.straightForward(numbers);
        assertEquals(3, peak);
    }

    @Test
    void shouldTestStraightForwardAndReturnFirstPeakOutOfMultiplePeaks() {
        int[] numbers = {1,2,3,2,3,1};
        var peak = PeakFinder.straightForward(numbers);
        assertEquals(3, peak);
    }

    @Test
    void shouldTestStraightForwardAndReturnFirstIndexIfThereIsNoPeak() {
        int[] numbers = {1,1,1,1,1,1,1,1,1};
        var peak = PeakFinder.straightForward(numbers);
        assertEquals(1, peak);
    }

    @Test
    void shouldTestStraightForwardAndReturnMinusOneIfEmptyArray() {
        int[] numbers = {};
        var peak = PeakFinder.straightForward(numbers);
        assertEquals(-1, peak);
    }

    @Test
    void shouldTestStraightForwardAndReturnLastIndexIfArrayIsJustSeqNumbers() {
        int[] numbers = new int[100000];
        for (int i = 0; i < 100000; i++) {
            numbers[i] = i;
        }
        var start = System.nanoTime();
        var peak = PeakFinder.straightForward(numbers);
        var end = System.nanoTime();
        System.out.println("Straight forward algorithm time taken: " + (end - start));
        assertEquals(99999, peak);
    }


    // Divide and Conquer recursive peak finder
    @Test
    void shouldTestDocAndReturnMinusOneIfEmptyArray() {
        int[] numbers = {};
        var peak = PeakFinder.divideAndConquer(numbers);
        assertEquals(-1, peak);
    }

    @Test
    void shouldTestDocSolutionWithSingleNumberArray() {
        int[] numbers = {2};
        var peak = PeakFinder.divideAndConquer(numbers);
        assertEquals(2, peak);
    }

    @Test
    void shouldTestDocSolutionWithTwoNumberArrayWhereFirstNumberIsGreaterThanFirst() {
        int[] numbers = {3,2};
        var peak = PeakFinder.divideAndConquer(numbers);
        assertEquals(3, peak);
    }

    @Test
    void shouldTestDocSolutionWithTwoNumberArrayWhereSecondNumberIsGreaterThanFirst() {
        int[] numbers = {2,3};
        var peak = PeakFinder.divideAndConquer(numbers);
        assertEquals(3, peak);
    }

    @Test
    void shouldTestDocWithThreeNumberArrayWhereSecondNumberIsGreaterThanFirst() {
        int[] numbers = {1,3,2};
        var peak = PeakFinder.divideAndConquer(numbers);
        assertEquals(3, peak);
    }

    @Test
    void shouldTestDocWithThreeNumberArrayWhereLastNumberIsAPeak() {
        int[] numbers = {1,2,3};
        var peak = PeakFinder.divideAndConquer(numbers);
        assertEquals(3, peak);
    }

    @Test
    void shouldTestDocAndReturnFirstPeakOutOfMultiplePeaks() {
        int[] numbers = {1,2,3,2,3,1};
        int peak = PeakFinder.divideAndConquer(numbers);
        assertEquals(3, peak);
    }

    @Test
    void shouldTestDocAndReturnFirstIndexIfThereIsNoPeak() {
        int[] numbers = {1,1,1,1,1,1,1,1,1};
        var peak = PeakFinder.divideAndConquer(numbers);
        assertEquals(1, peak);
    }

    @Test
    void shouldTestDocAndReturnLastIndexIfArrayIsJustSeqNumbers() {
        int[] numbers = new int[100000];
        for (int i = 0; i < 100000; i++) {
            numbers[i] = i;
        }
        var start = System.nanoTime();
        var peak = PeakFinder.divideAndConquer(numbers);
        var end = System.nanoTime();
        System.out.println("Divide and Conquer algorithm time taken: " + (end - start));
        assertEquals(99999, peak);
    }

    @Test
    void shouldFindMaxNumberInArray() {
        int[] numbers = {3,7,4,9,5};
        final var maximum = PeakFinder.maximum(numbers);
        assertEquals(9, maximum);

    }
}
