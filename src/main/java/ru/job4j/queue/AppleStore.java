package ru.job4j.queue;

import java.util.LinkedList;
import java.util.Queue;

public class AppleStore {
    private final Queue<Customer> queue;

    private final int count;

    public AppleStore(Queue<Customer> queue, int count) {
        this.queue = new LinkedList<>(queue);
        this.count = count;
    }

    public String getLastHappyCustomer() {
        Customer lastHappy = null;
        int i = 0;
        for (Customer currentCustomer : queue) {
            if (i < count) {
                lastHappy = currentCustomer;
                i++;
            }
        }
        return lastHappy != null ? lastHappy.name() : null;
    }

    public String getFirstUpsetCustomer() {
        int i = 0;
        for (Customer currentCustomer : queue) {
            if (i >= count) {
                return currentCustomer.name();
            }
            i++;
        }
        return null;
    }
}