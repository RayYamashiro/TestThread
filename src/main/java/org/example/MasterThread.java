package org.example;

import java.util.ArrayList;

public class MasterThread extends Thread implements MatrixActions {
    private final ArrayList<int[][]> matrices = new ArrayList<>();
    private final int amountOfMatrices;
    private final int matrixSize;
    private int[][] resultMatrix;
    public ArrayList<SubThread> subThreads;

    public MasterThread(int amount, int size) {
        amountOfMatrices = amount;
        matrixSize = size;

        for (int i = 0; i < amountOfMatrices; i++) {
            matrices.add(MatrixActions.getRandomMatrix(matrixSize));
        }

        resultMatrix = new int[matrixSize][matrixSize];
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                if (i == j) {
                    resultMatrix[i][j] = 1;
                } else {
                    resultMatrix[i][j] = 0;
                }
            }
        }
    }

    public void sendMatrixToSubThread(SubThread destination, int[][] a, int[][] b) {
        destination.getMatrices(a, b);
    }

    public void getSubResultMatrix(int[][] matrix) {
        resultMatrix = MatrixActions.multiplyMatrix(resultMatrix, matrix);
    }

    public void setSubThreads(ArrayList<SubThread> subThreads) {
        this.subThreads = subThreads;
    }

    @Override
    public void run() {
        for (var matrix : matrices) {
            MatrixActions.printMatrix(matrix);
        }

        int j = 0;
        for (int i = 0; i < amountOfMatrices; i+= 2) {
            sendMatrixToSubThread(subThreads.get(j), matrices.get(i), matrices.get(i + 1));

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            subThreads.get(j).run();

            /*if (subThreads.get(j).isAlive()) {
                subThreads.get(j).notify();
            } else {
                subThreads.get(j).start();
            }*/

            j = (j + 1) % subThreads.size();
        }

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        MatrixActions.printMatrix(resultMatrix);
    }
}
