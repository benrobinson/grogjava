package com.grog.app.api;

import java.util.function.Function;

public abstract class EventFactory<T, K> {
    private EventKey<T, K> eventKey;
    public abstract Event<T> createEvent(T data);
    public abstract EventHandler<T> createHandler(Function<Event<T>, Event<T>> function);
}
