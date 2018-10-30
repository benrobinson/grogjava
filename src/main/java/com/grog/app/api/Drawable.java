package com.grog.app.api;

public interface Drawable<T> {
    Drawable<T> draw();
    Drawable<T> setOutput(T output);
}
