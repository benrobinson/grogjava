package com.grog.app.api;

public class EventKey<T, K> {

    private K value;

    EventKey(K value) {
        this.value = value;
    }

    public K getValue() {
        return value;
    }

    public boolean equals(EventKey<T, K> eventKey) {
        return this.value == eventKey.getValue();
    }
}
