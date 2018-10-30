package com.grog.app.api;

import java.util.List;

public class DrawingLayer<T extends Output> implements Drawable<T> {
    private T output;
    private List<Drawable<T>> drawables = null;

    public DrawingLayer<T> add(Drawable<T> drawable) {
        drawables.add(drawable.setOutput(output));
        return this;
    }

    public DrawingLayer<T> remove(Drawable<T> drawable) {
        drawables.remove(drawable);
        return this;
    }

    public DrawingLayer<T> draw() {
        while(drawables.iterator().hasNext()) {
            drawables.iterator().next().draw();
        }

        return this;
    }

    public DrawingLayer<T> setOutput(T o) {
        output = o;
        return this;
    }
}
