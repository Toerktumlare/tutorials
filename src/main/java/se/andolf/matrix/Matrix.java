package se.andolf.matrix;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Matrix {

    private final int[][] values;

    public Matrix(int[][] values) {
        this.values = values;
    }

    public int get(int x, int y) {
        return values[x][y];
    }

    public int[] getRow(int x) {
        return values[x];
    }

    public int[] getColumn(int y) {
        return Stream.of(values)
                .map(currentRow -> currentRow[y])
                .mapToInt(value -> value)
                .toArray();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        for (final int[] currentRow : values) {
            for (int value : currentRow) {
                sb.append(value).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public Matrix add(Matrix matrix) {
        int[][] product = new int[this.getRowLength()][matrix.getColLength()];
        for (int i = 0; i < values.length; i++) {
            final int[] thisRow = values[i];
            for (int j = 0; j < matrix.getColLength(); j++) {
                final int[] matrixColumn = matrix.getColumn(j);
                product[i][j] = getSum(thisRow, matrixColumn);
            }
        }

        return new Matrix(product);
    }

    private int getSum(int[] row, int[] column) {
        return IntStream.range(0, column.length)
                .map(i -> (row[i] * column[i]))
                .sum();
    }

    private int getColLength() {
        if(values.length == 0)
            return 0;
        return values[0].length;
    }

    private int getRowLength() {
        return values.length;
    }
}
