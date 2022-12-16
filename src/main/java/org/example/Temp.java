package org.example;

import java.util.List;
import java.util.concurrent.Executors;

public class Temp {

    public static void main(String[] args) {
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        var ex =Executors.newFixedThreadPool(4);
        List.of(1, 2, 3, 4).forEach(n -> ex.execute(() -> System.out.println("sds")));
        ex.shutdown();
    }
}
