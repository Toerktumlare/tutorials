package se.andolf.matrix;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MatrixTest {

    @Test
    public void shouldGetCorrectIndices() {
        final int[][] numbers = {{ 1 }};
        final Matrix matrix = new Matrix(numbers);
        assertEquals(1, matrix.get(0,0));
    }

    @Test
    public void shouldGetColumn() {
        final int[][] numbers = {{ 1, 2, 3 }, {1, 2, 3}};
        final Matrix matrix = new Matrix(numbers);
        System.out.println(matrix.toString());
        assertArrayEquals(new int[] { 1, 1 }, matrix.getColumn(0));
    }

    @Test
    public void shouldGetRow() {
        final int[][] numbers = {{ 1, 2, 3 }, {1, 2, 3}};
        final Matrix matrix = new Matrix(numbers);
        System.out.println(matrix.toString());
        assertArrayEquals(new int[] { 1, 2, 3 }, matrix.getRow(0));
    }

    @Test
    public void shouldAddTwoMatrices() {
        final int[][] values1 = {{ 0, 3, 5 }, { 5, 5, 2}};
        final int[][] values2 = {{ 3, 4 }, { 3, -2 }, {4, -2}};

        final Matrix matrix1 = new Matrix(values1);
        final Matrix matrix2 = new Matrix(values2);

        System.out.println(matrix1.toString());
        System.out.println(matrix2.toString());

        final Matrix matrixSum = matrix1.add(matrix2);

        System.out.println(matrixSum.toString());

        assertNotNull(matrixSum);
        assertEquals(29, matrixSum.get(0,0));
        assertEquals(-16, matrixSum.get(0,1));
        assertEquals(38, matrixSum.get(1,0));
        assertEquals(6, matrixSum.get(1,1));
    }
}
