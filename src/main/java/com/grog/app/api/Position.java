package com.grog.app.api;

import java.lang.Number;

public class Position<T extends Number> {
    private T x;
    private T y;

    public Position(T x, T y) {
        this.x = x;
        this.y = y;
    }

    public T getX() {
      return x;
    }

    public T getY() {
      return y;
    }
}
