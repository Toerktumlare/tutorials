package se.andolf.tutorials.algorithms;

import java.util.Arrays;

/*
    - Peak finder
    - One dimensional version

    given a..i are numbers
    [a,b,c,d,e,f,g,h,i]

    position 2 is a peak if and only if
    b >= a and b >= c

    position 9 is a peak if and only if (edges of array)
    i >= h

    ----------------------------------------------------------------------

    Problem: Find A peak, (if it exists)!

 */
public class PeakFinder {


    /*
        Straight forward solution, we look at each element and then decide if it is a peak
        worst case scenario peak is the last element

        solution: Θ(n) linear complexity
     */
    public static int straightForward(int[] numbers) {
        for (var i = 0; i < numbers.length; i++) {
            if(numbers.length == 1) {
                return numbers[i];
            } else if (i == 0){
                if (numbers[i] >= numbers[i+1])
                    return numbers[i];
            } else if(i == numbers.length-1) {
                return numbers[i];
            } else {
                if(numbers[i] >= numbers[i-1] && numbers[i] >= numbers[i+1])
                    return numbers[i];
            }
        }
        return -1;
    }

    /*
        Divide and Conquer

        given array a with n numbers
        if a[n/2] < a[n/2-1] then only look at left half 1..(n/2-1) to look for a peak
        else if a[n/2] < a[n/2+1] then only look at right half (n/2+1)...n to look for a peak
        else n/2 is a peak
     */
    public static int divideAndConquer(int[] numbers) {
        return divideAndConquer(numbers, 0, numbers.length-1);
    }

    private static int divideAndConquer(int[] numbers, int start, int end) {
        if (numbers.length == 0)
            return -1;
        else if(end - start == 0)
            return numbers[start];

        var middle = (start+end)/2;
        if(numbers[middle] < numbers[middle+1]) {
            return divideAndConquer(numbers, middle+1, end);
        } else if(middle != 0 && numbers[middle] < numbers[middle-1]){
            return divideAndConquer(numbers, start, middle-1);
        } else {
            return numbers[middle];
        }
    }

    public static int maximum(int[] numbers){
        if(numbers.length == 0)
            return -1;
        else if(numbers.length == 1)
            return numbers[0];
        return Math.max(numbers[0], maximum(Arrays.copyOfRange(numbers, 1, numbers.length)));
    }

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static boolean isOdd(int number) {
        return number % 2 == 1;
    }
}
