package com.grog.app.api;

public abstract class Positionable<T extends Number> {

    class Position {
        T x;
        T y;

        Position(T x, T y) {
            this.x = x;
            this.y = y;
        }
    }

    Position position;

    public abstract Position getPosition();
    public abstract Positionable setPosition(T x, T y);
}