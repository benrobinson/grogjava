package com.grog.app.api;

public interface Positionable<T extends Number> {
    Position getPosition();
    Positionable setPosition(T x, T y);
}