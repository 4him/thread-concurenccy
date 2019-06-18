package concurrency.api.executor_service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    public static void main(String[] args) throws Exception /*TODO 2 try to remove "throws Exception"*/{

        ExecutorService executorService = Executors.newSingleThreadExecutor(); //TODO 3 try to use another implementation

        System.out.println("main thread is going to submit some tasks to executor service \n");

        final Future<?> feature1 =
                executorService.submit(() -> System.out.println(Thread.currentThread().getName() +
                        "   1.st task executing by executor service"));

        final Future<String> feature2 =
                executorService.submit(() -> {
                    System.out.println(Thread.currentThread().getName() +
                            "   2.nd task executing by executor service");
                    Thread.sleep(10000);
                    return "some result";
                });

        System.out.println("\n1.st task done? = " + feature1.isDone());
        System.out.println("1.st task's result = " + feature1.get());

        System.out.println("\n2.nd task done? = " + feature2.isDone());
        System.out.println("2.nd task's result = " + feature2.get());//TODO 1 try to add timeout
        System.out.println("2.nd task done? = " + feature2.isDone());
        System.out.println("2.nd task canceled? = " + feature2.isCancelled());

        System.out.println("\nmain thread is done");
    }
}
//TODO 4, revert changes, go to the next commit
