package concurrency.synchronization.third_party_object;

public class Main {

    public static void main(String[] args) {
        Resource resource = new Resource();
        Runnable actionPerformer = new ActionPerformer(resource);

        Thread thread0 = new Thread(actionPerformer);
        Thread thread1 = new Thread(actionPerformer);

        thread0.start();
        thread1.start();
    }
}
