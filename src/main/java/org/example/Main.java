package org.example;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(10000);
        MasterThread master = new MasterThread(20, 20);
        ArrayList<SubThread> subThreads = new ArrayList<>();
        subThreads.add(new SubThread(master));
        subThreads.add(new SubThread(master));
        subThreads.add(new SubThread(master));
        subThreads.add(new SubThread(master));
        subThreads.add(new SubThread(master));
        subThreads.add(new SubThread(master));
        master.setSubThreads(subThreads);
        master.start();
    }
}
