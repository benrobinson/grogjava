package com.grog.app.api;

public abstract class Drawable<T extends Output> {
    protected T output;

    public abstract Drawable setOutput(T output);

    public abstract Drawable draw();
}
