package concurrency;

public class Main {

    public static void main() {
        Runnable target = new DownloadingService();

        Thread iPhone = new Thread(target, "iPhone");
        Thread iPad = new Thread(target, "iPad");

        iPhone.start();
        iPad.start();

    }

    public static void main(String[] args) throws InterruptedException {
        while (true){
            main();
            Thread.sleep(1000);
        }
    }

}
