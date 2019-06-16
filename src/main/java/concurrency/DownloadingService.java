package concurrency;

import java.util.concurrent.atomic.AtomicInteger;

public class DownloadingService implements Runnable {

    private AtomicInteger remainingTraffic = new AtomicInteger(100);

    public void run() {
        String threadName = Thread.currentThread().getName();
        while (true){
            if (remainingTraffic.get() >= 25) {
                System.out.println(threadName + " is able to perform the operation");
                remainingTraffic.set(remainingTraffic.get() - 25);
                System.out.println("Downloaded from " + threadName + ". Remained traffic = " + remainingTraffic);
            } else {
                break;
            }
        }
    }
}
