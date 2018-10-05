package com.grog.app.api;

public abstract class Event<T> extends EventKeyable {

    private T data;

    Event() {
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
