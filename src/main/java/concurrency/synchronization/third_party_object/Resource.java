package concurrency.synchronization.third_party_object;

public class Resource {

    @Override
    public String toString() {
        return String.valueOf(hashCode());
    }
}
