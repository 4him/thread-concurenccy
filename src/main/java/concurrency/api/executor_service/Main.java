package concurrency.api.executor_service;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws Exception {

        ScheduledExecutorService executorService = null;
        Future<String> feature;
        Callable<String> callable = () -> {
            System.out.println("\n1.st task executing by executor service");
            Thread.sleep(5000);
            return "some result";
        };

        System.out.println("main thread is going to submit one task to executor service \n");

        try {
            executorService = Executors.newSingleThreadScheduledExecutor();
            feature = executorService.schedule(callable, 10 , TimeUnit.SECONDS);
        } finally {
            if (executorService != null) {
                executorService.shutdown();
                System.out.println("executorService shut down? " + executorService.isShutdown());
                System.out.println("executorService terminated? " + executorService.isTerminated());
            }
        }

        System.out.println("\n1.st task done? = " + feature.isDone());
        System.out.println("1.st task's result = " + feature.get());
        System.out.println("1.st task done? = " + feature.isDone());

        System.out.println("\nexecutorService terminated? " + executorService.isTerminated());
    }
}
//TODO try scheduleAtFixedRate() together
