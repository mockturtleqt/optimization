package by.bsuir.optimization.runner;

import by.bsuir.optimization.exception.MatrixException;
import by.bsuir.optimization.util.MatrixOperations;

public class Main {
    public static void main(String[] args) {
        MatrixOperations matrixOperations = new MatrixOperations();
        int[][] matrix = matrixOperations.fillMatrix(3, 4);

        int[][] anotherMatrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 10}
        };
        matrixOperations.printMatrix(anotherMatrix);
        System.out.println();
        matrixOperations.printMatrix(matrixOperations.transpose(anotherMatrix));
        System.out.println();

        matrixOperations.printMatrix(matrixOperations.fillReducedMatrix(anotherMatrix, 0));

        System.out.println();
        try {
            System.out.println(matrixOperations.findDeterminant(anotherMatrix));
        } catch (MatrixException e) {
            System.out.println(e);
        }
    }


}
