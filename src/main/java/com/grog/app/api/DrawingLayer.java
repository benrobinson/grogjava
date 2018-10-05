package com.grog.app.api;

import java.util.List;

public class DrawingLayer<T extends Output> extends Drawable<T> {

    private List<Drawable> drawables = null;

    public DrawingLayer add(Drawable<T> drawable) {
        drawables.add(drawable.setOutput(output));
        return this;
    }

    public DrawingLayer remove(Drawable drawable) {
        drawables.remove(drawable);
        return this;
    }

    public DrawingLayer draw() {
        while(drawables.iterator().hasNext()) {
            drawables.iterator().next().draw();
        }

        return this;
    }

    public DrawingLayer setOutput(T o) {
        output = o;
        return this;
    }
}
