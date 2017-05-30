package by.bsuir.optimization.util;

import by.bsuir.optimization.exception.MatrixException;

public class MatrixOperations {
    public int[][] transpose(int[][] initialMatrix) {
        int[][] transposedMatrix = new int[initialMatrix[0].length][initialMatrix.length];
        for (int m = 0; m < initialMatrix.length; m++) {
            for (int n = 0; n < initialMatrix[m].length; n++) {
                transposedMatrix[n][m] = initialMatrix[m][n];
            }
        }
        return transposedMatrix;
    }

    public int findDeterminant(int[][] matrix) throws MatrixException {
        if (matrix != null && (matrix.length == matrix[0].length)) {
            if (matrix.length == 1) {
                return matrix[0][0];
            }

            if (matrix.length == 2) {
                return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
            }

            int determinant = 0;
            for (int n = 0; n < matrix[0].length; n++) {
                determinant += Math.pow(-1, n) * matrix[0][n] * findDeterminant(fillReducedMatrix(matrix, 0, n));
            }
            return determinant;
        } else {
            throw new MatrixException("Matrix isn't square.");
        }
    }

    public int[][] fillMatrix(int height, int width) {
        int[][] matrix = new int[height][width];
        for (int m = 0; m < height; m++) {
            for (int n = 0; n < width; n++) {
                matrix[m][n] = n;
            }
        }
        return matrix;
    }

    public int[][] findInverseMatrix(int[][] matrix) throws MatrixException {
        int[][] cofactorMatrix = new int[matrix.length][matrix[0].length];
        for (int m = 0; m < matrix.length; m++) {
            for (int n = 0; n < matrix[m].length; n++) {
                cofactorMatrix[m][n] = (int) Math.pow(-1, m + n) * findDeterminant(fillReducedMatrix(matrix, m, n));
            }
        }
        return transpose(cofactorMatrix);
    }

//    public int[][] multiplyMatrix(int[][] firstMatrix, int[][] secondMatrix) {
//        for ()
//    }

    public int[][] fillReducedMatrix(int[][] matrix, int excludedRowNumber, int excludedColumnNumber) {
        int[][] reducedMatrix = new int[matrix.length - 1][matrix[0].length - 1];
        int matrixRow, matrixColumn;
        for (int m = 0; m < matrix.length - 1; m++) {
            matrixRow = (m >= excludedRowNumber) ? m + 1 : m;
            for (int n = 0; n < matrix[m].length - 1; n++) {
                matrixColumn = (n >= excludedColumnNumber) ? n + 1 : n;
                reducedMatrix[m][n] = matrix[matrixRow][matrixColumn];
            }
        }
        return reducedMatrix;
    }

    public void printMatrix(int[][] matrix) {
        for (int m = 0; m < matrix.length; m++) {
            for (int n = 0; n < matrix[m].length; n++) {
                System.out.print(matrix[m][n] + " ");
            }
            System.out.println();
        }
    }
}
