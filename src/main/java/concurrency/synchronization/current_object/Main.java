package concurrency.synchronization.current_object;

public class Main {

    public static void main(String[] args) {
        Runnable target = new DownloadingService();

        Thread iPhone = new Thread(target, "iPhone");
        Thread iPad = new Thread(target, "iPad");

        iPhone.start();
        iPad.start();

    }

}
