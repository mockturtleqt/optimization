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
        int[][] smallMatrix = {
                {1, 2},
                {4, 5}
        };

        int[][] itWillBeOk = {
                {0, 1, 0, 0},
                {1, 1, 0, 0},
                {0, 0, -1, 0},
                {1, 1, 0, 1},
        };
//        matrixOperations.printMatrix(anotherMatrix);
//        System.out.println();
//        matrixOperations.printMatrix(matrixOperations.transpose(anotherMatrix));
//        System.out.println();

        matrixOperations.printMatrix(matrixOperations.fillReducedMatrix(anotherMatrix, 1, 1));

        System.out.println();


        try {
            matrixOperations.printMatrix(matrixOperations.findInverseMatrix(itWillBeOk));
            System.out.println();
            System.out.println(matrixOperations.findDeterminant(anotherMatrix));
        } catch (MatrixException e) {
            System.out.println(e);
        }
    }


}
