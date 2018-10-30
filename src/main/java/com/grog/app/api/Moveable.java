package com.grog.app.api;

public interface Moveable<T extends Number> {
    Moveable setXSpeed(T xSpeed);
    Moveable setYSpeed(T ySpeed);
    Moveable changeXSpeedBy(T amount);
    Moveable changeYSpeedBy(T amount);
}
