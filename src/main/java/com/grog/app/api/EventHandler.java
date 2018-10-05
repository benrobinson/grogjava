package com.grog.app.api;

import java.util.function.Function;

public abstract class EventHandler<T> extends EventKeyable {

    private Function<Event<T>, Event<T>> handler;

    EventHandler(EventKey key, Function<Event<T>, Event<T>> handler) {
        this.key = key;
        this.handler = handler;
    }

    public void handle(Event<T> event) {
        handler.apply(event);
    }
}
