package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(10000);
        MasterThread master = new MasterThread(70, 70);
        ArrayList<SubThread> subThreads = new ArrayList<>();
        subThreads.add(new SubThread(master));
        subThreads.add(new SubThread(master));
        subThreads.add(new SubThread(master));
        subThreads.add(new SubThread(master));
        subThreads.add(new SubThread(master));
        subThreads.add(new SubThread(master));

        var executor = Executors.newFixedThreadPool(6);
        List.of(1, 2, 3, 4, 5, 6).forEach(elem -> executor.execute(() -> System.out.println(elem)));
        executor.execute(() -> System.out.println("wow"));
        //executor.
        Thread thread21 = new Thread(() -> {
            for(int i = 0; i < 1000; i++)
                System.out.println("gg");
        });
        thread21.run();
        Thread.sleep(2000);
        executor.shutdown();
        master.setSubThreads(subThreads);
        master.start();
    }
}
