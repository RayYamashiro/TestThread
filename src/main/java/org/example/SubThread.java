package org.example;

public class SubThread extends Thread {
    private int[][] a;
    private int[][] b;
    private final MasterThread master;

    public SubThread(MasterThread master) {
        this.master = master;
    }

    public void getMatrices(final int[][] a, final int[][] b) {
        this.a = a;
        this.b = b;
    }

    public int[][] getResultMatrix() {
        return MatrixActions.multiplyMatrix(a, b);
    }

    public void sendResultToMaster() {
        master.getSubResultMatrix(getResultMatrix());
    }

    @Override
    public void run() {
        MatrixActions.printMatrix(getResultMatrix());
        sendResultToMaster();
    }
}
