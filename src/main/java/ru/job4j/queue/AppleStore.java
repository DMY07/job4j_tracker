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
        Customer[] customers = queue.toArray(new Customer[0]);
        for (int i = 0; i < count && i < customers.length; i++) {
            lastHappy = customers[i];
        }
        return lastHappy != null ? lastHappy.name() : null;
    }

    public String getFirstUpsetCustomer() {
        Customer[] customers = queue.toArray(new Customer[0]);
        if (count < customers.length) {
            return customers[count].name();
        }
        return null;
    }
}
