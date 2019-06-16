package concurrency.synchronization.current_object;

public class DownloadingService implements Runnable {

    private int remainingTraffic = 100;

    public void run() {
        downloadContent();
    }

    private void downloadContent() {
        synchronized (this) {
            while (true) {
                if (remainingTraffic >= 25) {
                    remainingTraffic = remainingTraffic - 25;
                } else {
                    break;
                }
            }
        }
    }
}
