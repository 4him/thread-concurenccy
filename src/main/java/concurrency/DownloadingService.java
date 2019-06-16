package concurrency;

public class DownloadingService implements Runnable {

    private int remainingTraffic = 100;

    public void run() {
        String threadName = Thread.currentThread().getName();
        while (true){
            if (remainingTraffic >= 25) {
                System.out.println(threadName + " is able to perform the operation");
                remainingTraffic = remainingTraffic - 25;
                System.out.println("Downloaded from " + threadName + ". Remained traffic = " + remainingTraffic);
            } else {
                break;
            }
        }
    }
}
