package concurrency.synchronization.third_party_object;

public class ActionPerformer implements Runnable {

    private final Resource firstResource;

    private final Resource secondResource;

    public ActionPerformer(Resource first, Resource second) {
        this.firstResource = first;
        this.secondResource = second;
    }

    public void run() {
        try {
            performAction();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void performAction() throws InterruptedException {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " is going to get the lock for " + firstResource);
        synchronized (firstResource) {
            System.out.println(threadName + " possesses the lock for " + firstResource);
            Thread.sleep(5000);

            System.out.println(threadName + " is going to get the lock for " + secondResource);
            synchronized (secondResource) {
                System.out.println(threadName + " possesses the lock for " + secondResource);
                Thread.sleep(5000);
                System.out.println(threadName + " is going to release the lock of " + secondResource);
            }
            System.out.println(threadName + " is going to release the lock of " + firstResource);
        }
    }
}
