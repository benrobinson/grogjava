package com.grog.app.api;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;

public abstract class EventPool {

    private Hashtable<EventKey, LinkedBlockingQueue<Event>> events;
    private Hashtable<EventKey, LinkedBlockingQueue<EventHandler>> handlers;

    private <E extends EventKeyable> EventPool insertInto(Hashtable<EventKey, LinkedBlockingQueue<E>> table, E item) {
        try {
            if (table.containsKey(item.getKey())) {
                table.get(item.getKey()).put(item);
            } else {
                table.put(item.getKey(), new LinkedBlockingQueue<E>());
                table.get(item.getKey()).put(item);
            }
        } catch (InterruptedException e) {
            System.out.println(e.toString());
        }
        return this;
    }

    public <T> EventPool publish(Event<T> event) {
        if (handlers.containsKey(event.getKey())) {
            return this.insertInto(events, event);
        }
        return this;
    }

    public <T> EventPool subscribe(EventHandler<T> handler) {
        return this.insertInto(handlers, handler);
    }

    public EventPool flush(EventKey eventKey) {
        if (events.containsKey(eventKey) && handlers.containsKey(eventKey)) {
            Iterator<Event> eventIterator = events.get(eventKey).iterator();
            LinkedBlockingQueue<EventHandler> handlersQueue = handlers.get(eventKey);
            Iterator<EventHandler> handlerIterator;
            Event event;
            EventHandler handler;
            while(eventIterator.hasNext()) {
                event = eventIterator.next();
                handlerIterator = handlersQueue.iterator();
                while(handlerIterator.hasNext()) {
                    handler = handlerIterator.next();
                    handler.handle(event);
                }
            }
        }
        return this;
    }

    public EventPool flushAll() {
        Set<EventKey> keys = events.keySet();
        for (EventKey key: keys) {
            flush(key);
        }
        return this;
    }

}
