package com.grog.app.api;

public abstract class Event<T> extends EventKeyable {
    private T data;
    private EventKey key;

    Event(EventKey key) {
        this.key = key;
        this.data = null;
    }

    Event(EventKey key, T data) {
        this.key = key;
        this.data = data;
    }

    public T getData() {
        return data;
    }

}
