package ru.job4j.queue;

import java.util.Queue;

public class AppleStore {
    private final Queue<Customer> queue;

    private final int count;

    public AppleStore(Queue<Customer> queue, int count) {
        this.queue = queue;
        this.count = count;
    }

    public String getLastHappyCustomer() {
        int remainingCount = count;
        String lastHappy = null;
        for (int i = 0; i < queue.size(); i++) {
            Customer currentCustomer = queue.poll();
            if (remainingCount > 0) {
                lastHappy = currentCustomer.name();
                remainingCount -= 1;
            }
            queue.offer(currentCustomer);
        }
        return lastHappy;
    }

    public String getFirstUpsetCustomer() {
        int remainingCount = count;
        String firstUpsetCustomer = null;
        for (int i = 0; i < queue.size(); i++) {
            Customer currentCustomer = queue.poll();
            if (remainingCount == 0 && firstUpsetCustomer == null) {
                firstUpsetCustomer = currentCustomer.name();
            }
            if (remainingCount > 0) {
                remainingCount -= 1;
            }
            queue.offer(currentCustomer);
        }
        return firstUpsetCustomer;
    }
}
