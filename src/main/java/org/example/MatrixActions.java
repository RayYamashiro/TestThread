package org.example;

import java.util.Random;

public interface MatrixActions {
    static int[][] getRandomMatrix(final int size) {
        int[][] matrix = new int[size][size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = random.nextInt(10);
            }
        }
        return matrix;
    }

    static void printMatrix(final int[][] matrix) {
        int n = matrix[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static int[][] multiplyMatrix(final int[][] a, final int[][] b) {
        final int rowCount = a.length;
        final int colCount = b[0].length;
        final int sumLength = b.length;
        int[][] c = new int[rowCount][colCount];

        for (int row = 0; row < rowCount; ++row) {
            for (int col = 0; col < colCount; ++col) {
                int sum = 0;
                for (int i = 0; i < sumLength; ++i) {
                    sum += a[row][i] * b[i][col];
                }
                c[row][col] = sum;
            }
        }

        return c;
    }
}
